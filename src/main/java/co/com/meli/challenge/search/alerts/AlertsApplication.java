package co.com.meli.challenge.search.alerts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class AlertsApplication {

  public static void main(String[] args) {
    SpringApplication.run(AlertsApplication.class, args);
  }
}
