package LeoGuedex.com.github.ProjetoBancario.repository;

import LeoGuedex.com.github.ProjetoBancario.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {

}
