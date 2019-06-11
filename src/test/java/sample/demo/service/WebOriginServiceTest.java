package sample.demo.service;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;
import static sample.demo.util.DomaUtils.createSelectOptions;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.seasar.doma.jdbc.SelectOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sample.demo.dao.OriginDao;
import sample.demo.entity.Pageable;
import sample.demo.entity.WebOrigin;

@RunWith(SpringRunner.class)
@SpringBootTest
// TODO いずれDBUnit @DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)
public class WebOriginServiceTest {

  @Autowired
  OriginDao dao;

  @Test
  public void Daoの実行結果を確認() {
    SelectOptions options = createSelectOptions(Pageable.NO_LIMIT).count();
    List<WebOrigin> samples = dao.selectAll(new WebOrigin(), options);
    assertThat(samples.size(), greaterThan(0));
    WebOrigin sample = samples.get(0);
    assertThat(sample, notNullValue());
  }

}
