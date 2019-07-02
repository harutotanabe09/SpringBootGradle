package sample.demo.dao;

import java.util.List;
import org.seasar.doma.Dao;
import org.seasar.doma.Select;
import org.seasar.doma.boot.ConfigAutowireable;
import sample.demo.entity.Fine;

/*
 * @AnnotateWith(annotations = {@Annotation(target = AnnotationTarget.CLASS, type =
 * Repository.class),
 *
 * @Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Autowired.class),
 *
 * @Annotation(target = AnnotationTarget.CONSTRUCTOR_PARAMETER, type = Qualifier.class, elements =
 * "\"secondaryds\"")})
 */
@Dao
@ConfigAutowireable
public interface FineDao {

  /**
   * 全部を取得します。
   *
   * @param criteria 検索条件
   * @param options ページング
   * @return 検索結果
   */
  @Select
  List<Fine> selectAll();
}
