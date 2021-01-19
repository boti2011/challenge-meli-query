package co.com.meli.challenge.search.alerts.repository;

import co.com.meli.challenge.search.alerts.mappers.AlertServerMapper;
import co.com.meli.challenge.search.alerts.model.dto.AlertServerDto;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AlertRepositoryImpl implements AlertRepository {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertRepositoryImpl.class);

  private final JdbcTemplate template;

  @Override
  public Optional<Page<AlertServerDto>> findAlertByDescription(
      String descriptionAlert, Pageable paging) {
    LOGGER.info("Description Alert: {}", descriptionAlert);
    String sql =
        "SELECT * "
            + "FROM SERVER_ALERTS "
            + "WHERE MATCH(DESCRIPTION_ALERT) AGAINST ( ? IN BOOLEAN MODE ) "
            + "ORDER BY SERVER_ID ASC "
            + "LIMIT %d OFFSET %d";

    List<AlertServerDto> alerts =
        this.template.query(
            String.format(sql, paging.getPageSize(), paging.getOffset()),
            new Object[] {descriptionAlert},
            new AlertServerMapper());

    return Optional.of(new PageImpl<>(alerts, paging, countByDescriptionAlert(descriptionAlert)));
  }

  @Override
  public Optional<Page<AlertServerDto>> findAlertByServerName(String serverName, Pageable paging) {
    LOGGER.info("Server Name: {}", serverName);
    String sql =
        "SELECT * "
            + "FROM SERVER_ALERTS "
            + "WHERE MATCH(SERVER_ID) AGAINST ( ? IN BOOLEAN MODE ) "
            + "LIMIT %d OFFSET %d";

    List<AlertServerDto> alerts =
        this.template.query(
            String.format(sql, paging.getPageSize(), paging.getOffset()),
            new Object[] {serverName},
            new AlertServerMapper());

    return Optional.of(new PageImpl<>(alerts, paging, countByServerName(serverName)));
  }

  private int countByDescriptionAlert(String description) {
    String sql =
        "SELECT count(1) "
            + "FROM SERVER_ALERTS "
            + "WHERE MATCH(DESCRIPTION_ALERT) AGAINST ( ? IN BOOLEAN MODE ) "
            + "ORDER BY SERVER_ID ASC ";
    return this.template.queryForObject(sql, Integer.class, description);
  }

  private int countByServerName(String serverName) {
    String sql =
        "SELECT count(1) "
            + "FROM SERVER_ALERTS "
            + "WHERE MATCH(SERVER_ID) AGAINST ( ? IN BOOLEAN MODE ) "
            + "ORDER BY SERVER_ID ASC ";
    return this.template.queryForObject(sql, Integer.class, serverName);
  }
}
