package sample.demo.property;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
public class AppProperties {

  @Value("${app.timezone:UTC}")
  private String timezone;

}
