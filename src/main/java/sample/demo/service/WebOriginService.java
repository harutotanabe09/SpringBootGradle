package sample.demo.service;

import static sample.demo.util.DomaUtils.createSelectOptions;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import lombok.val;
import sample.demo.dao.OriginDao;
import sample.demo.entity.Pageable;
import sample.demo.entity.WebOrigin;

@Service
public class WebOriginService extends BaseTransactionalService {

  @Autowired
  OriginDao originDao;

  /**
   * 全件取得します。
   *
   * @param criteria
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public List<WebOrigin> findAll(Pageable pageable) {
    val options = createSelectOptions(pageable).count();
    return originDao.selectAll(new WebOrigin(), options);
  }

  /**
   * 1件を取得します。
   *
   * @return
   */
  @Transactional(readOnly = true)
  public Optional<WebOrigin> findById(int id) {
    Assert.notNull(id, "id must not be null");
    return originDao.selectById(id);
  }

}
