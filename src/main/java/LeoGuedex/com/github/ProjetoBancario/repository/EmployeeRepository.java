package LeoGuedex.com.github.ProjetoBancario.repository;

import LeoGuedex.com.github.ProjetoBancario.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
