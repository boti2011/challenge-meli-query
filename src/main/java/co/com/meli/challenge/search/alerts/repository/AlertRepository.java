package co.com.meli.challenge.search.alerts.repository;

import co.com.meli.challenge.search.alerts.model.dto.AlertServerDto;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlertRepository {

  Optional<Page<AlertServerDto>> findAlertByDescription(String descriptionAlert, Pageable paging);

  Optional<Page<AlertServerDto>> findAlertByServerName(String serverName, Pageable paging);

  Optional<Page<AlertServerDto>> findAlertByAnyField(String field, Pageable paging);
}
