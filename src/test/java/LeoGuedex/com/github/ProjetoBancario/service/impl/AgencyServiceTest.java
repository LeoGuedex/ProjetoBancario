package LeoGuedex.com.github.ProjetoBancario.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

import LeoGuedex.com.github.ProjetoBancario.domain.Agency;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyRequestDto;
import LeoGuedex.com.github.ProjetoBancario.repository.AgencyRepository;
import LeoGuedex.com.github.ProjetoBancario.service.imp.AgencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

public class AgencyServiceTest {

  @InjectMocks
  private AgencyService agencyService;

  @Mock
  private ObjectMapper mapper;

  @Mock
  private AgencyRepository repository;

  @BeforeEach
  public void setup() {
    mapper = new ObjectMapper();
    repository = Mockito.mock(AgencyRepository.class);
    agencyService = Mockito.mock(AgencyService.class);
  }

  @Test
  public void createAgencyWithSuccess() {
    //Preparacao
    Agency expectedAgency = new Agency(1L, "Santander", "1234", "Rua12", null, null, null, null);

    AgencyRequestDto dto = mock(AgencyRequestDto.class);

    //Execucao
    Mockito.when(repository.save(any())).thenReturn(expectedAgency);
    Mockito.when(agencyService.createAgency(any())).thenReturn(expectedAgency);

    Agency agency = agencyService.createAgency(dto);

    //Validacao
    assertNotNull(agency);
    assertEquals(agency.getId(), 1L);
    assertNull(agency.getCurrentAccounts());
  }

}
