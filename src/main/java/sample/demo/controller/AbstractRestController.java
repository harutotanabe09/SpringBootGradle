package sample.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import sample.demo.api.resource.DefaultResourceFactoryImpl;
import sample.demo.util.FunctionNameAware;

/**
 * 基底APIコントローラー
 */
@ResponseStatus(HttpStatus.OK)
@Slf4j
public abstract class AbstractRestController extends BaseController implements FunctionNameAware {

  @Bean
  protected ResourceFactory resourceFactory() {
    return new DefaultResourceFactoryImpl();
  }

  @Autowired
  protected ResourceFactory resourceFactory;
}
