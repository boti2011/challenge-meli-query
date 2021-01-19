package co.com.meli.challenge.search.alerts.model.dto;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AlertServerDtoTest {

  private AlertServerDto alertServerDto;

  @Before
  public void before() {
    this.alertServerDto = new AlertServerDto();
  }

  @Test
  public void createSaveAlertRequestAllArgsConstructorTest() {
    this.alertServerDto =
        new AlertServerDto("1234-123sd-123csd", "SERVER", "DESC", new Date(23124), "VVVV");
    assertNotNull(this.alertServerDto);
  }

  @Test
  public void createSaveAlertRequestWithDataBySetters() {
    // setup
    this.alertServerDto.setCreatedAt(new Date(23124));
    this.alertServerDto.setDescriptionAlert("DESC");
    this.alertServerDto.setServerName("SERVER");
    this.alertServerDto.setServerType("VVVV");
    this.alertServerDto.setAlertId("1234-123sd-123csd");

    // assertions
    assertNotNull(this.alertServerDto);

    assertEquals("DESC", this.alertServerDto.getDescriptionAlert());
    assertEquals(new Date(23124), this.alertServerDto.getCreatedAt());
    assertEquals("SERVER", this.alertServerDto.getServerName());
    assertEquals("VVVV", this.alertServerDto.getServerType());
    assertEquals("1234-123sd-123csd", this.alertServerDto.getAlertId());
  }
}
