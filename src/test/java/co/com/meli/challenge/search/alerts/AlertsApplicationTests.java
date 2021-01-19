package co.com.meli.challenge.search.alerts;

import co.com.meli.challenge.search.alerts.configuration.Config;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;

@Import(AlertsApplication.class)
@SpringBootTest
@ContextConfiguration(classes= Config.class)
class AlertsApplicationTests {

  @Autowired Config config;

  @Test
  public void contextLoads() {
    config.corsFilter();
  }
}
