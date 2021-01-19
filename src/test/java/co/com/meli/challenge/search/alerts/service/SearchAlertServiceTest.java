package co.com.meli.challenge.search.alerts.service;

import co.com.meli.challenge.search.alerts.model.SearchAlertResponse;
import co.com.meli.challenge.search.alerts.model.dto.AlertServerDto;
import co.com.meli.challenge.search.alerts.repository.AlertRepositoryImpl;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class SearchAlertServiceTest {

  @InjectMocks SearchAlertServiceImpl service;

  @Mock private AlertRepositoryImpl repository;

  @Before
  public void Before() {
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void searchAlertByDescriptionTestSuccess() {

    // execution
    final SearchAlertResponse responseService =
        service.getAlertsByDescription("DESC", getPageable());

    // asserts
    assertNotNull(responseService);
  }

  @Test
  public void searchAlertByServerNameTestSuccess() {

    // execution
    final SearchAlertResponse responseService =
        service.getAlertsByServerName("DESC", getPageable());

    // asserts
    assertNotNull(responseService);
  }

  @Test
  public void searchAlertByAnyFieldTestSuccess() {

    // execution
    final SearchAlertResponse responseService = service.getAlertsByAnyField("DESC", getPageable());

    // asserts
    assertNotNull(responseService);
  }

  public Page<AlertServerDto> getAlertServerDtoPage() {
    return new Page<AlertServerDto>() {
      @Override
      public int getTotalPages() {
        return 1;
      }

      @Override
      public long getTotalElements() {
        return 1;
      }

      @Override
      public <U> Page<U> map(Function<? super AlertServerDto, ? extends U> converter) {
        return null;
      }

      @Override
      public int getNumber() {
        return 1;
      }

      @Override
      public int getSize() {
        return 1;
      }

      @Override
      public int getNumberOfElements() {
        return 1;
      }

      @Override
      public List<AlertServerDto> getContent() {
        final AlertServerDto alertServerDto = new AlertServerDto();
        alertServerDto.setServerType("Type");
        alertServerDto.setServerName("Name");
        alertServerDto.setDescriptionAlert("Desc");
        alertServerDto.setCreatedAt(new Date(123));
        alertServerDto.setAlertId("asdasd-sad-asd-asdasd");
        final List<AlertServerDto> alerts = new ArrayList<>();
        alerts.add(alertServerDto);
        return alerts;
      }

      @Override
      public boolean hasContent() {
        return false;
      }

      @Override
      public Sort getSort() {
        return null;
      }

      @Override
      public boolean isFirst() {
        return false;
      }

      @Override
      public boolean isLast() {
        return false;
      }

      @Override
      public boolean hasNext() {
        return false;
      }

      @Override
      public boolean hasPrevious() {
        return false;
      }

      @Override
      public Pageable nextPageable() {
        return null;
      }

      @Override
      public Pageable previousPageable() {
        return null;
      }

      @Override
      public Iterator<AlertServerDto> iterator() {
        return null;
      }
    };
  }

  public Pageable getPageable() {
    return new Pageable() {
      @Override
      public int getPageNumber() {
        return 0;
      }

      @Override
      public int getPageSize() {
        return 2;
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
