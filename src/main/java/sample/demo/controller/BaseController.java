package sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public class BaseController {

  public static final String VALIDATION_ERROR = "ValidationError";

  @Autowired
  protected ApplicationContext applicationContext;

  /**
   * コンテキストを返します。
   *
   * @return
   */
  protected ApplicationContext getApplicationContext() {
    return applicationContext;
  }


}
