package LeoGuedex.com.github.ProjetoBancario.service;

import LeoGuedex.com.github.ProjetoBancario.domain.Agency;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyRequestDto;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyResponseDto;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyUpdateRequestDto;

public interface AgencyServiceInterface {

  Agency createAgency(AgencyRequestDto agencyDto);

  AgencyResponseDto readAgencyById(Long id);

  AgencyResponseDto updateAgency(Long id, AgencyUpdateRequestDto dto);

  void deleteAgency(Long id);

}
