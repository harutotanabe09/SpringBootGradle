package sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import sample.demo.util.MessageUtils;

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

  /**
   * メッセージを取得します。
   *
   * @param key
   * @param args
   * @return
   */
  protected String getMessage(String key, Object... args) {
    return MessageUtils.getMessage(key, args);
  }
}
