package rw.invoicing.main.customer;

import java.util.List;

public interface CustomerServiceInterface {

	public Customer createCustomer(String name, String email, String phoneNumber);

	List<Customer> findAll();

	public void deleteCustomer(Long id);

	public Customer updateCustomer(Long id, String email, String name, String phoneNumber);

	public Customer getCustomer(Long id);
}
