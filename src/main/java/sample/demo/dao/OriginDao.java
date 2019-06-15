package sample.demo.dao;

import java.util.List;
import java.util.Optional;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import org.seasar.doma.jdbc.SelectOptions;
import sample.demo.entity.WebOrigin;

@ConfigAutowireable
@Dao
public interface OriginDao {

  /**
   * 全部を取得します。
   *
   * @param criteria 検索条件
   * @param options ページング
   * @return 検索結果
   */
  @Select
  List<WebOrigin> selectAll(final WebOrigin criteria, final SelectOptions options);

  /**
   * １件を取得します。
   *
   * @param id  ユーザID
   * @return 検索結果
   */
  @Select
  Optional<WebOrigin> selectById(long id);
}
