package co.com.meli.challenge.search.alerts.mappers;

import co.com.meli.challenge.search.alerts.model.dto.AlertServerDto;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class AlertServerMapper implements RowMapper {
  @Override
  public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
    AlertServerDto alert = new AlertServerDto();
    alert.setAlertId(rs.getString("ALERT_ID"));
    alert.setCreatedAt(rs.getDate("CREATED_AT"));
    alert.setDescriptionAlert(rs.getString("DESCRIPTION_ALERT"));
    alert.setServerName(rs.getString("SERVER_ID"));
    alert.setServerType(rs.getString("SERVER_TYPE"));

    return alert;
  }
}
