package LeoGuedex.com.github.ProjetoBancario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Agency {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private List<Persona> customers;

  private String address;

  private String number;

  private List<Employee> employees;

  private List<CurrentAccount> currentAccounts;

  private List<SavingAccount> savingAccounts;

}
