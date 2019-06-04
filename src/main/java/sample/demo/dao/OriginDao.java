package sample.demo.dao;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import sample.demo.entity.WebOrigin;

@ConfigAutowireable
@Dao
public interface OriginDao {

  /**
   * 全部を取得します。
   *
   * @param criteria
   * @param options
   * @return
   */
  @Select
  List<WebOrigin> selectAll(final WebOrigin criteria);
}
