package sample.demo.service;

import static sample.demo.util.DomaUtils.createSelectOptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import sample.demo.dao.OriginDao;
import sample.demo.entity.Pageable;
import sample.demo.entity.WebOrigin;
import sample.demo.entity.WebOriginJdbc;

@Service
public class WebOriginService extends BaseTransactionalService {

  @Autowired private OriginDao originDao;

  @Autowired private JdbcTemplate jdbcTemplate;

  @Autowired
  @Qualifier("secondaryjdbc")
  private JdbcTemplate mysql;

  /**
   * 全件取得します。
   *
   * @param pageable ページング
   * @return 検索結果
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public List<WebOrigin> findAll(Pageable pageable) {
    val options = createSelectOptions(pageable).count();
    return originDao.selectAll(new WebOrigin(), options);
  }

  // 他のデータベースへ接続
  public List<WebOriginJdbc> findJdbcAll() {
    // 別のデータベース設定（MYSQL）をJDBCに設定
    List mysqlLists = mysql.queryForList("SELECT * FROM test.fine");
    List<WebOriginJdbc> newlist = new ArrayList<>();
    for (Iterator<?> it = mysqlLists.iterator(); it.hasNext(); ) {
      Map map = (Map) it.next();
      newlist.add(createEntity(map));
    }
    return newlist;
  }

  private WebOriginJdbc createEntity(Map map) {
    WebOriginJdbc jdbc = new WebOriginJdbc();
    System.out.println(map);
    jdbc.setClientid((Long) map.get("number"));
    jdbc.setValue((String) map.get("name"));
    return jdbc;
  }

  /**
   * 1件を取得します。
   *
   * @return 検索結果
   */
  @Transactional(readOnly = true)
  public Optional<WebOrigin> findById(int id) {
    Assert.notNull(id, "id must not be null");
    return originDao.selectById(id);
  }
}
