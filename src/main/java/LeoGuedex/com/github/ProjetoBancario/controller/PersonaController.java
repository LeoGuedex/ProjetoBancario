package LeoGuedex.com.github.ProjetoBancario.controller;

import LeoGuedex.com.github.ProjetoBancario.domain.Persona;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.PersonaRequestDto;
import LeoGuedex.com.github.ProjetoBancario.domain.dto.PersonaResponseDto;
import LeoGuedex.com.github.ProjetoBancario.service.PersonaService;
import jakarta.validation.Valid;
import java.net.URI;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/personas")
public class PersonaController {

  @Autowired
  private PersonaService personaService;

  @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
  public ResponseEntity<Void> createPersona(@Valid @RequestBody Persona persona) {
    Persona savedPersona = null;

    try {
      savedPersona = personaService.createPersona(persona);
    } catch (DataIntegrityViolationException e) {
      return ResponseEntity.badRequest().build();
    }

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedPersona.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Persona> findPersona(@PathVariable Long id) {
    Persona persona = personaService.findPersona(id);

    return ResponseEntity.ok().body(persona);
  }

  @RequestMapping(method = RequestMethod.GET)
  public ResponseEntity<Set<PersonaResponseDto>> findAllPersonas() {
    Set<PersonaResponseDto> allPersonas = personaService.findAllPersonas();

    return ResponseEntity.ok().body(allPersonas);
  }

  @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
  public ResponseEntity<PersonaResponseDto> updatePersona(@PathVariable Long id,
      @RequestBody PersonaRequestDto personaDto) {
    PersonaResponseDto responseDto = personaService.updatePersona(id, personaDto);

    return ResponseEntity.ok().body(responseDto);
  }

  @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
  public ResponseEntity<Void> deletePersona(@PathVariable Long id) {
    personaService.deletePersona(id);

    return ResponseEntity.noContent().build();
  }

}
