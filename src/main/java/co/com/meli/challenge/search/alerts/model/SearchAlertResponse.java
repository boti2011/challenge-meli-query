package co.com.meli.challenge.search.alerts.model;

import io.swagger.annotations.ApiModelProperty;
import java.util.Map;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SearchAlertResponse {

  @ApiModelProperty(notes = "Status response")
  private Integer status;

  @ApiModelProperty(notes = "Description of response")
  private String description;

  @ApiModelProperty(notes = "Data of alerts and pagination information to show in front")
  private Map<String, Object> data;
}
