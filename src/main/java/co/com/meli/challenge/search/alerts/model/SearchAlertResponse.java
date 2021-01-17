package co.com.meli.challenge.search.alerts.model;

import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchAlertResponse {

  private Integer status;
  private String description;
  private Map<String, Object> data;
}
