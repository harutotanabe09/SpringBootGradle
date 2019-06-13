package sample.demo.controller;

import sample.demo.controller.api.resource.Resource;

/** リソースファクトリ */
public interface ResourceFactory {

  /**
   * インスタンスを作成します.
   *
   * @return
   */
  Resource create();
}
