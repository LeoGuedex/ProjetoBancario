package LeoGuedex.com.github.ProjetoBancario.repository;

import LeoGuedex.com.github.ProjetoBancario.domain.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

}
