package LeoGuedex.com.github.ProjetoBancario.repository;

import LeoGuedex.com.github.ProjetoBancario.domain.CurrentAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrentAccountRepository extends JpaRepository<CurrentAccount, Long> {

}
