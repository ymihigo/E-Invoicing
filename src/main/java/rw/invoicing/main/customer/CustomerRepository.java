package rw.invoicing.main.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Optional<Customer> findByEmail(String email);

	Optional<Customer> findByIdAndEmail(Long id, String email);

	@Query("FROM Customer c WHERE c.id != :id and c.email != :email ")
	Optional<Customer> findByEmailAndNotEqualId(@Param("id") Long id, @Param("email") String email);

	@Query("FROM Customer c WHERE c.id != :id and c.phoneNumber != :phoneNumber ")
	Optional<Customer> findByPhonenumberAndNotEqualId(@Param("id") Long id, @Param("phoneNumber") String phoneNumber);

}
