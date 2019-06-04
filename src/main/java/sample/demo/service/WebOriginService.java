package sample.demo.service;

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
   * 祝日を複数取得します。
   *
   * @param criteria
   * @param pageable
   * @return
   */
  @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  public List<WebOrigin> findAll(WebOrigin criteria, Pageable pageable) {
    // TODO ページングを指定する
    val options = Pageable.NO_LIMIT;
    return originDao.selectAll(new WebOrigin());
  }

}
