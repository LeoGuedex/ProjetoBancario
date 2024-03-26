package LeoGuedex.com.github.ProjetoBancario.controller;

import LeoGuedex.com.github.ProjetoBancario.domain.Persona;
import LeoGuedex.com.github.ProjetoBancario.service.PersonaService;
import jakarta.validation.Valid;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
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
  public ResponseEntity<Void> createPersona(@Valid @RequestBody Persona persona){
    Persona savedPersona = personaService.createPersona(persona);

    URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
        .buildAndExpand(savedPersona.getId()).toUri();

    return ResponseEntity.created(uri).build();
  }

  @RequestMapping(method = RequestMethod.GET, value = "/{id}")
  public ResponseEntity<Persona> findPersona(@PathVariable Long id){
    Persona persona = personaService.findPersona(id);

    return ResponseEntity.ok().body(persona);
  }

}
