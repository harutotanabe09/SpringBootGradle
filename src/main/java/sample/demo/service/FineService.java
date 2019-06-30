package sample.demo.service;

import org.springframework.stereotype.Service;

@Service
public class FineService extends BaseTransactionalService {


  // @Autowired
  // FineDao fineDao;

  /**
   * 全件取得します。
   *
   * @param pageable ページング
   * @return 検索結果
   */
  // @Transactional(readOnly = true) // 読み取りのみの場合は指定する
  // public List<Fine> findAll() {
  // return fineDao.selectAll();
  // }

}
