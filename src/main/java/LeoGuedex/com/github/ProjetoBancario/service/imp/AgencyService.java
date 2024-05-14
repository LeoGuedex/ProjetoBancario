package LeoGuedex.com.github.ProjetoBancario.service.imp;

import LeoGuedex.com.github.ProjetoBancario.domain.Agency;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyRequestDto;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyResponseDto;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyUpdateRequestDto;
import LeoGuedex.com.github.ProjetoBancario.exception.ObjectNotFoundException;
import LeoGuedex.com.github.ProjetoBancario.repository.AgencyRepository;
import LeoGuedex.com.github.ProjetoBancario.service.AgencyServiceInterface;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgencyService implements AgencyServiceInterface {

  private final AgencyRepository agencyRepository;
  private final ObjectMapper mapper;

  @Autowired
  public AgencyService(AgencyRepository agencyRepository, ObjectMapper mapper) {
    this.agencyRepository = agencyRepository;
    this.mapper = mapper;
  }

  @Transactional
  public Agency createAgency(AgencyRequestDto agencyDto) {
    Agency agency = mapper.convertValue(agencyDto, Agency.class);

    return agencyRepository.save(agency);
  }

  public AgencyResponseDto readAgencyById(Long id) {
    Optional<Agency> optionalAgency = agencyRepository.findById(id);

    if (optionalAgency.isEmpty()) {
      throw new ObjectNotFoundException("Agency not found with id: " + id);
    }

    ObjectMapper objectMapper = new ObjectMapper();
    AgencyResponseDto result = objectMapper.convertValue(optionalAgency.get(),
        AgencyResponseDto.class);

    return result;
  }

  public AgencyResponseDto updateAgency(Long id, AgencyUpdateRequestDto dto) {
    Optional<Agency> optionalAgency = agencyRepository.findById(id);

    if (optionalAgency.isEmpty()) {
      throw new ObjectNotFoundException("Agency not found with id: " + id);
    }

    Agency agency = optionalAgency.get();
    agency.setNumber(dto.getNumber());
    agency.setAddress(dto.getAddress());

    Agency savedAgency = agencyRepository.save(agency);

    return mapper.convertValue(savedAgency, AgencyResponseDto.class);
  }

  public void deleteAgency(Long id) {
    readAgencyById(id);
    agencyRepository.deleteById(id);
  }

}
