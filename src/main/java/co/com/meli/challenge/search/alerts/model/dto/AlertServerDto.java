package co.com.meli.challenge.search.alerts.model.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertServerDto {
  private String alertId;
  private String serverName;
  private String descriptionAlert;
  private Date createdAt;
  private String serverType;
}
