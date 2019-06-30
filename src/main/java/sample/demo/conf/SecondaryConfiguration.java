package sample.demo.conf;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "spring.datasource.secondary")
public class SecondaryConfiguration {

  private String driverClassName;
  private String url;
  private String username;
  private String password;

  @Bean(name = "secondaryds")
  public DataSource createDataSource() {
    return DataSourceBuilder.create().driverClassName(driverClassName).url(url).username(username)
        .password(password).build();
  }

  @Bean(name = "secondaryjdbc")
  public JdbcTemplate createJdbcTemplate(@Qualifier("secondaryds") DataSource dataSource) {
    return new JdbcTemplate(dataSource);
  }
}
