package LeoGuedex.com.github.ProjetoBancario.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Email.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String name;

  @Email
  private String email;
  private String password;

  @CPF
  private String cpf;
  private TypeKey typeKey;
  private Character gender;
  private LocalDate lastLogin;
  private LocalDate whenCreated;
  private LocalDateTime birthDay;
  private SavingAccount savingAccount;
  private CurrentAccount currentAccount;
  private List<String> pixKeys;

}
