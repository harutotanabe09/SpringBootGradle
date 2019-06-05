package sample.demo.util;

import org.seasar.doma.jdbc.SelectOptions;
import sample.demo.entity.Pageable;

/**
 * Doma関連ユーティリティ ＊注意＊ import static でインポートして使用する
 */
public class DomaUtils {
  /**
   * SearchOptionsを作成して返します。
   *
   * @return
   */
  public static SelectOptions createSelectOptions() {
    return SelectOptions.get();
  }

  /**
   * SearchOptionsを作成して返します。
   *
   * @param pageable
   * @return
   */
  public static SelectOptions createSelectOptions(Pageable pageable) {
    int page = pageable.getPage();
    int perpage = pageable.getPerpage();
    return createSelectOptions(page, perpage);
  }

  /**
   * SearchOptionsを作成して返します。
   *
   * @param page
   * @param perpage
   * @return
   */
  public static SelectOptions createSelectOptions(int page, int perpage) {
    int offset = (page - 1) * perpage;
    return SelectOptions.get().offset(offset).limit(perpage);
  }
}
