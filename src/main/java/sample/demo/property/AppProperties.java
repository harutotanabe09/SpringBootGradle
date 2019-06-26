package sample.demo.property;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class AppProperties {

  @Value("${app.timezone:UTC}")
  private String timezone;

  @Value("${spring.datasource.url}")
  private String dbname;
}
