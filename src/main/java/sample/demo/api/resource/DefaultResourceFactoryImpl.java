package sample.demo.api.resource;

import sample.demo.controller.ResourceFactory;
import sample.demo.controller.api.resource.Resource;

/** リソースファクトリのデフォルト実装. */
public class DefaultResourceFactoryImpl implements ResourceFactory {

  /**
   * インスタンスを作成します.
   *
   * @return
   */
  @Override
  public Resource create() {
    return new ResourceImpl();
  }
}
