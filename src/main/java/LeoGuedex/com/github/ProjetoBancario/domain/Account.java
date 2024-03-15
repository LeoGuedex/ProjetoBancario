package LeoGuedex.com.github.ProjetoBancario.domain;

import java.math.BigDecimal;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Account {

  private Persona customer;

  private String number;

  private BigDecimal balance;

  private List<Extract> extractList;

}
