package co.com.meli.challenge.search.alerts.service;

import co.com.meli.challenge.search.alerts.model.SearchAlertResponse;
import org.springframework.data.domain.Pageable;

public interface SearchAlertService {

  SearchAlertResponse getAlertsByDescription(String description, Pageable paging);

  SearchAlertResponse getAlertsByServerName(String serverName, Pageable paging);
}
