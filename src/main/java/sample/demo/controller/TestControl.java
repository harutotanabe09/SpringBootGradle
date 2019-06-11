package sample.demo.controller;

import static sample.demo.base.WebConst.MESSAGE_SUCCESS;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import lombok.val;
import sample.demo.controller.api.resource.Resource;
import sample.demo.entity.Pageable;
import sample.demo.entity.WebOrigin;
import sample.demo.property.AppProperties;
import sample.demo.service.WebOriginService;

@RestController
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestControl extends AbstractRestController {

  //  プロパティファイルの使い方
  @Autowired
  private AppProperties property;

  @Autowired
  WebOriginService webOriginService;

  @GetMapping
  public Resource index() {
    List<WebOrigin> pages = webOriginService.findAll(Pageable.NO_LIMIT);
    Resource resource = resourceFactory.create();
    resource.setData(pages);
    return resource;
  }

  /**
   * ユーザーを取得します。
   *
   * @param userId
   * @return
   */
  @ApiOperation(value = "get Info", notes = "get info description", httpMethod = "GET",
      consumes = "application/json", response = WebOrigin.class)
  @GetMapping(value = "/{id}")
  public Resource show(@PathVariable int id) {
    // 1件取得する
    val webOrigin = webOriginService.findById(id);
    // DIからのインスタンス生成 ★ interfaceを呼びだしている
    Resource resource = resourceFactory.create();
    resource.setData(Arrays.asList(webOrigin.get()));
    // MassegeUtilsを使用してメッセージセット
    resource.setMessage(getMessage(MESSAGE_SUCCESS));
    return resource;
  }

  @Override
  public String getFunctionName() {
    return "API_TEST";
  }

}
