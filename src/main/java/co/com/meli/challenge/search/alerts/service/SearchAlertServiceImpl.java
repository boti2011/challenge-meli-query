package co.com.meli.challenge.search.alerts.service;

import co.com.meli.challenge.search.alerts.model.SearchAlertResponse;
import co.com.meli.challenge.search.alerts.model.dto.AlertServerDto;
import co.com.meli.challenge.search.alerts.repository.AlertRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchAlertServiceImpl implements SearchAlertService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SearchAlertServiceImpl.class);

  private final AlertRepository repository;

  @Override
  public SearchAlertResponse getAlertsByDescription(String description, Pageable paging) {
    LOGGER.info("Service alert description: {}", description);
    Optional<Page<AlertServerDto>> alerts = repository.findAlertByDescription(description, paging);
    return getResponseService(alerts);
  }

  @Override
  public SearchAlertResponse getAlertsByServerName(String serverName, Pageable paging) {
    LOGGER.info("Service server name: {}", serverName);
    Optional<Page<AlertServerDto>> alerts = repository.findAlertByServerName(serverName, paging);
    return getResponseService(alerts);
  }

  public SearchAlertResponse getResponseService(Optional<Page<AlertServerDto>> alerts) {
    SearchAlertResponse response = new SearchAlertResponse();
    if (!alerts.isPresent() || alerts.get().getContent().isEmpty()) {
      response.setDescription(HttpStatus.NOT_FOUND.name());
      response.setStatus(HttpStatus.NOT_FOUND.value());
    } else {
      // Get information to return response
      Map<String, Object> data = new HashMap<>();
      data.put("alerts", alerts.get().getContent());
      data.put("currentPage", alerts.get().getNumber());
      data.put("totalItems", alerts.get().getTotalElements());
      data.put("totalPages", alerts.get().getTotalPages());

      // Set values to response service
      response.setDescription(HttpStatus.OK.name());
      response.setStatus(HttpStatus.OK.value());
      response.setData(data);
    }
    return response;
  }
}
