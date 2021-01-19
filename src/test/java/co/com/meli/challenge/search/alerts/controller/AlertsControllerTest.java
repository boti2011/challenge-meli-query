package co.com.meli.challenge.search.alerts.controller;

import co.com.meli.challenge.search.alerts.model.SearchAlertResponse;
import co.com.meli.challenge.search.alerts.service.SearchAlertService;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class AlertsControllerTest {

  @InjectMocks private AlertsController controller;

  @Mock private SearchAlertService service;

  private SearchAlertResponse searchAlertResponse;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    this.searchAlertResponse = new SearchAlertResponse();
  }

  @Test
  public void findAlertByDescriptionSuccess() {
    // setup
    fillSuccessResponseWithData();

    // execution
    final ResponseEntity<SearchAlertResponse> response =
        controller.findAlertByDescription("DESC", 0, 1);

    // assertions
    assertNotNull(response);

    assertEquals(200, response.getStatusCodeValue());
    assertEquals("OK", response.getStatusCode().name());
  }

  @Test
  public void findAlertByServerNameSuccess() {
    // setup
    fillSuccessResponseWithData();

    // execution
    final ResponseEntity<SearchAlertResponse> response =
        controller.findAlertByServerName("SERVER", 0, 1);

    // assertions
    assertNotNull(response);

    assertEquals(200, response.getStatusCodeValue());
    assertEquals("OK", response.getStatusCode().name());
  }

  public void fillSuccessResponseWithData() {
    Map<String, Object> data = new HashMap<>();
    this.searchAlertResponse.setStatus(200);
    this.searchAlertResponse.setDescription("OK");
    this.searchAlertResponse.setData(data);
  }
}
