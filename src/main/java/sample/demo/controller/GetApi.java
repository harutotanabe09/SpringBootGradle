package sample.demo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/getapidata", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class GetApi {

  /** テスト用のGET APIするためのコントローラ 。ぐるなびのデータを取得 */
  @GetMapping
  public String index() {
    // SpringはRestTemplateが使える！！
    RestTemplate resttemplate = new RestTemplate();
    String str = resttemplate.getForObject(
        "https://api.gnavi.co.jp/RestSearchAPI/v3/?keyid=d30ce23746256b6bac79291446bf8323&address=東京",
        String.class);
    System.out.println("loginfo ----" + str);
    return "hello";
  }
}
