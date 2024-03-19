package LeoGuedex.com.github.ProjetoBancario.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
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
public class Pix {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private BigDecimal value;

  @JsonIgnore
  @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
  private LocalDateTime whenCreated;

  @ManyToOne
  @JoinColumn(name = "current_account_id")
  private CurrentAccount destinyAccount;

  @NotNull
  private String destinyKey;

}