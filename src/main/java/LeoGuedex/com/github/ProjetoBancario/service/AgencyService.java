package LeoGuedex.com.github.ProjetoBancario.service;

import LeoGuedex.com.github.ProjetoBancario.domain.Agency;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyRequestDto;
import LeoGuedex.com.github.ProjetoBancario.repository.AgencyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AgencyService {

  @Autowired
  private AgencyRepository agencyRepository;

  @Autowired
  private ModelMapper mapper;

  @Transactional
  public Agency createAgency(AgencyRequestDto agencyDto) {
    Agency agency = mapper.map(agencyDto, Agency.class);

    return agencyRepository.save(agency);
  }

}
