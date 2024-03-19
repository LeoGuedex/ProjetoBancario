package LeoGuedex.com.github.ProjetoBancario.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transfer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal value;

  @ManyToOne
  @JoinColumn(name = "current_account_id")
  private CurrentAccount destinyAccount;

  @ManyToOne
  @JoinColumn(name = "saving_account_id")
  private SavingAccount savingAccount;

  @JsonIgnore
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime whenCreated;

}