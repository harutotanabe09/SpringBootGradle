package sample.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.demo.entity.Pageable;
import sample.demo.entity.WebOrigin;
import sample.demo.property.AppProperties;
import sample.demo.service.WebOriginService;

@RestController
@RequestMapping(path = "/api/v1/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class TestControl extends AbstractRestController {

  @Autowired
  private AppProperties property;

  @Autowired
  WebOriginService webOriginService;

  @RequestMapping("/")
  public String welcome(Map<String, Object> model) {
    List<WebOrigin> pages = webOriginService.findAll(Pageable.NO_LIMIT);
    for (WebOrigin wo : pages) {
      System.out.println(wo.getClientId());
    }
    return "welcome" + property.getTimezone();
  }

  @Override
  public String getFunctionName() {
    return "API_TEST";
  }
}
