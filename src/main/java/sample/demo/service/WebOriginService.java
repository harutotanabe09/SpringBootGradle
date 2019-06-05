package sample.demo.service;

import static sample.demo.util.DomaUtils.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}
