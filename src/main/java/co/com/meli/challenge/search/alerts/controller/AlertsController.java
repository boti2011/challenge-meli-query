package co.com.meli.challenge.search.alerts.controller;

import co.com.meli.challenge.search.alerts.model.SearchAlertResponse;
import co.com.meli.challenge.search.alerts.service.SearchAlertService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alerts/search")
@RequiredArgsConstructor
@Api(value = "Search of alerts by his properties")
public class AlertsController {

  private static final Logger LOGGER = LoggerFactory.getLogger(AlertsController.class);

  private final SearchAlertService service;

  @ApiOperation(value = "Search of alerts by description field", response = ResponseEntity.class)
  @RequestMapping(
      method = RequestMethod.GET,
      path = "/{description}/{page}/{size}",
      produces = "application/json")
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success search"),
        @ApiResponse(
            code = 404,
            message = "Success search but can't get information for this description")
      })
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

  @ApiOperation(value = "Search of alerts by description field", response = ResponseEntity.class)
  @ApiResponses(
      value = {
        @ApiResponse(code = 200, message = "Success search"),
        @ApiResponse(
            code = 404,
            message = "Success search but can't get information for this description")
      })
  @RequestMapping(
      method = RequestMethod.GET,
      path = "/{name}/{page}/{size}",
      produces = "application/json")
  @GetMapping("/name")
  public ResponseEntity<SearchAlertResponse> findAlertByServerName(
      @RequestParam(name = "name") String serverName,
      @RequestParam(defaultValue = "0") int page,
      @RequestParam(defaultValue = "5") int size) {
    LOGGER.info("ServerName: {}", serverName);
    Pageable paging = PageRequest.of(page, size);
    SearchAlertResponse response = service.getAlertsByServerName(serverName, paging);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
