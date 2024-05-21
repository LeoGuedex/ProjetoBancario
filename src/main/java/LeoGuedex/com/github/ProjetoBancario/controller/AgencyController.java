package LeoGuedex.com.github.ProjetoBancario.controller;

import LeoGuedex.com.github.ProjetoBancario.domain.Agency;
import LeoGuedex.com.github.ProjetoBancario.domain.BankingCheckbook;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyRequestDto;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyResponseDto;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.AgencyUpdateRequestDto;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.BankingCheckbookDto;
import LeoGuedex.com.github.ProjetoBancario.service.imp.AgencyService;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/agencies")
public class AgencyController {

  private final AgencyService agencyService;

  @Autowired
  public AgencyController(AgencyService agencyService) {
    this.agencyService = agencyService;
  }

  @PostMapping(consumes = "application/json", produces = "application/json")
  public ResponseEntity<Void> createAgency(@RequestBody AgencyRequestDto agencyDto) {
    Agency savedAgency = null;

    savedAgency = agencyService.createAgency(agencyDto);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedAgency.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<AgencyResponseDto> readAgencyById(@PathVariable Long id) {
    return ResponseEntity.ok(agencyService.readAgencyById(id));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<AgencyResponseDto> updateAgency(@PathVariable Long id,
      @RequestBody AgencyUpdateRequestDto agencyUpdateRequestDto) {
    return ResponseEntity.ok(agencyService.updateAgency(id, agencyUpdateRequestDto));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteAgency(@PathVariable Long id) {
    agencyService.deleteAgency(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping(value = "/checkbook", consumes = "application/json", produces = "application/json")
  public ResponseEntity<Void> createCheckbook(@RequestBody BankingCheckbookDto checkbookDto) {
    BankingCheckbook createdCheckbook = agencyService.createCheckbook(checkbookDto);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(createdCheckbook.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

}
