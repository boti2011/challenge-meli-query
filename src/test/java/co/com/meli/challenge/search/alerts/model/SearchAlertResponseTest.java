package co.com.meli.challenge.search.alerts.model;

import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchAlertResponseTest {

  private SearchAlertResponse searchAlertResponse;

  @Before
  public void before() {
    searchAlertResponse = new SearchAlertResponse();
  }

  @Test
  public void createSearchAlertResponseEmptyConstructorTest() {
    // assertions
    assertNotNull(this.searchAlertResponse);
  }

  @Test
  public void createSearchAlertResponseWithDataBySetters() {
    // setup
    this.searchAlertResponse.setDescription("OK");
    this.searchAlertResponse.setStatus(200);
    this.searchAlertResponse.setData(new HashMap<>());

    // assertions
    assertNotNull(this.searchAlertResponse);

    assertEquals(HttpStatus.OK.name(), this.searchAlertResponse.getDescription());
    assertEquals(HttpStatus.OK.value(), this.searchAlertResponse.getStatus().intValue());
    assertNotNull(this.searchAlertResponse.getData());
  }
}
