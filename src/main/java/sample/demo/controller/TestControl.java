package sample.demo.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sample.demo.entity.Pageable;
import sample.demo.entity.WebOrigin;
import sample.demo.property.AppProperties;
import sample.demo.service.WebOriginService;

@RestController
public class TestControl {

  @Autowired
  private AppProperties property;

  @Autowired
  WebOriginService webOriginService;

  @RequestMapping("/")
  public String welcome(Map<String, Object> model) {
    List<WebOrigin> pages = webOriginService.findAll(null, Pageable.DEFAULT);
    for (WebOrigin wo : pages) {
      System.out.println(wo.getClientId());
    }
    return "welcome" + property.getTimezone();
  }
}
