package sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.enjapan.share.SayHello;
import lombok.extern.slf4j.Slf4j;
import sample.demo.property.AppProperties;

@RestController
@RequestMapping(path = "/helloworld", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class SayHelloControl extends AbstractRestController {

  //  プロパティファイルの使い方
  @Autowired
  private AppProperties property;

  /** テスト用のコントローラ */
  @GetMapping
  public String index() {
    SayHello say = new SayHello();
    log.info("-----------------");
    log.info("doSomething start" + say.isHello());
    log.info("-----------------");
    log.info("-----------------");
    log.info("DB Name" + property.getDbname());
    log.info("-----------------");
    return "hello";
  }

  @Override
  public String getFunctionName() {
    return "API_TEST";
  }
}
