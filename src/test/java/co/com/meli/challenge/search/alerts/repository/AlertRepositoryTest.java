package co.com.meli.challenge.search.alerts.repository;

import co.com.meli.challenge.search.alerts.mappers.AlertServerMapper;
import co.com.meli.challenge.search.alerts.model.dto.AlertServerDto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class AlertRepositoryTest {

  @TestConfiguration
  static class EmployeeServiceImplTestContextConfiguration {

    @Autowired private JdbcTemplate template;

    @Bean
    public AlertRepositoryImpl service() {
      return new AlertRepositoryImpl(template);
    }
  }

  @Autowired private AlertRepositoryImpl alertRepository;

  @MockBean private JdbcTemplate template;

  @MockBean private AlertServerMapper alertServerMapper;

  private AlertServerDto alertServerDto;

  @Before
  public void before() {
    MockitoAnnotations.initMocks(this);
    alertServerDto = new AlertServerDto();
  }

  @Test
  public void findAlertByDescriptionTestSuccess() {
    // setup
    Pageable paging = getPaging();

    alertServerDtoWithData();

    List<AlertServerDto> alerts = new ArrayList<>();
    alerts.add(this.alertServerDto);

    when(template.query(anyString(), any(Object[].class), any(AlertServerMapper.class)))
        .thenReturn(alerts);

    when(template.queryForObject(anyString(), any(Class.class), anyString())).thenReturn(1);

    // execution
    Optional<Page<AlertServerDto>> result = alertRepository.findAlertByDescription("", paging);

    AlertServerDto resultRepository = result.get().getContent().get(0);
    // asserts
    assertEquals("Virtual", resultRepository.getServerType());
    assertEquals("SERVER", resultRepository.getServerName());
    assertEquals("Alert", resultRepository.getDescriptionAlert());
    assertEquals(new Date(123123), resultRepository.getCreatedAt());
    assertEquals("sadasd-asdasd-asdasd-sadasd", resultRepository.getAlertId());
  }

  @Test
  public void findAlertByServerNameTestSuccess() {
    // setup
    Pageable paging = getPaging();

    alertServerDtoWithData();

    List<AlertServerDto> alerts = new ArrayList<>();
    alerts.add(this.alertServerDto);

    when(template.query(anyString(), any(Object[].class), any(AlertServerMapper.class)))
        .thenReturn(alerts);

    when(template.queryForObject(anyString(), any(Class.class), anyString())).thenReturn(1);

    // execution
    Optional<Page<AlertServerDto>> result = alertRepository.findAlertByServerName("", paging);

    AlertServerDto resultRepository = result.get().getContent().get(0);

    // asserts
    assertEquals("Virtual", resultRepository.getServerType());
    assertEquals("SERVER", resultRepository.getServerName());
    assertEquals("Alert", resultRepository.getDescriptionAlert());
    assertEquals(new Date(123123), resultRepository.getCreatedAt());
    assertEquals("sadasd-asdasd-asdasd-sadasd", resultRepository.getAlertId());
  }

  public void alertServerDtoWithData() {
    this.alertServerDto.setServerType("Virtual");
    this.alertServerDto.setServerName("SERVER");
    this.alertServerDto.setDescriptionAlert("Alert");
    this.alertServerDto.setCreatedAt(new Date(123123));
    this.alertServerDto.setAlertId("sadasd-asdasd-asdasd-sadasd");
  }

  public Pageable getPaging() {
    return new Pageable() {
      @Override
      public int getPageNumber() {
        return 0;
      }

      @Override
      public int getPageSize() {
        return 5;
      }

      @Override
      public long getOffset() {
        return 0;
      }

      @Override
      public Sort getSort() {
        return null;
      }

      @Override
      public Pageable next() {
        return null;
      }

      @Override
      public Pageable previousOrFirst() {
        return null;
      }

      @Override
      public Pageable first() {
        return null;
      }

      @Override
      public boolean hasPrevious() {
        return false;
      }
    };
  }
}
