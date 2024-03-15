package LeoGuedex.com.github.ProjetoBancario.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Card {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @CreditCardNumber
  private String number;

  private Integer cvv;
  private Boolean credit;
  private BigDecimal limit;
  private BigDecimal debit;
  private LocalDate validity;
  private CurrentAccount account;
  private Boolean onlineShopping;
  private CardIdentification identification;

}