package LeoGuedex.com.github.ProjetoBancario.service;

import LeoGuedex.com.github.ProjetoBancario.domain.Persona;
import LeoGuedex.com.github.ProjetoBancario.exception.BankObjectNotFoundException;
import LeoGuedex.com.github.ProjetoBancario.repository.PersonaRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService {

  @Autowired
  private PersonaRepository personaRepository;

  public Persona createPersona(Persona persona) {
    persona.setId(null);
    persona.setLastLogin(LocalDateTime.now());
    persona.setWhenCreated(LocalDateTime.now());
    Persona savedPersona = personaRepository.save(persona);

    return savedPersona;
  }

  public Persona findPersona(Long id) {
    Optional<Persona> optionalPersona = personaRepository.findById(id);

    return optionalPersona.orElseThrow(
        () -> new BankObjectNotFoundException("Persona Not Found with id: " + id));
  }

}
