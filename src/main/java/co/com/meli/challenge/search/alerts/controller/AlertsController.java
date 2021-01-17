package co.com.meli.challenge.search.alerts.controller;

import co.com.meli.challenge.search.alerts.model.SearchAlertResponse;
import co.com.meli.challenge.search.alerts.service.SearchAlertService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alerts/search")
@RequiredArgsConstructor
public class AlertsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertsController.class);

  private final SearchAlertService service;

  @GetMapping("/description")
  public ResponseEntity<SearchAlertResponse> findAlertByDescription(
      @RequestParam(name = "description") String description,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size) {
    LOGGER.info("Find by Description: {}", description);

    Pageable paging = PageRequest.of(page, size);
    SearchAlertResponse response = service.getAlertsByDescription(description, paging);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/name")
  public ResponseEntity<SearchAlertResponse> createAlert(
      @RequestParam(name = "name") String serverName,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size) {
    LOGGER.info("ServerName: {}", serverName);
    Pageable paging = PageRequest.of(page, size);
    SearchAlertResponse response = service.getAlertsByServerName(serverName, paging);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
