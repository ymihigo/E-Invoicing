package rw.invoicing.main.customer;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import rw.invoicing.main.messaging.RabbitMQProducer;

@Service
//@CacheConfig(cacheNames = "customer", keyGenerator = "CustomerKeyGenerator")
public class CustomerService implements CustomerServiceInterface {

	@Autowired
	private CustomerRepository customerRepository;

//	@Autowired
//	private RabbitMQProducer rabbitMQProducer;

	@Override
	public Customer createCustomer(String name, String email, String phoneNumber) {
		if (name == null || name.isBlank() || name.isEmpty())
			throw new RuntimeException("name is required");
		if (!email.isBlank() || !email.isEmpty()) {
			Optional<Customer> customer = customerRepository.findByEmail(email);
			if (customer.isPresent())
				throw new RuntimeException("Email was taken");
		}
//		rabbitMQProducer.sendMessage("new user created!");
		return customerRepository.saveAndFlush(new Customer(name, email, phoneNumber));
	}

	@Override
	public List<Customer> findAll() {

		return customerRepository.findAll();
	}

	@Override
	public void deleteCustomer(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);

		if (!customer.isPresent())
			throw new IllegalStateException("No customer found");
		customerRepository.delete(customer.get());

	}

	@Override
	public Customer updateCustomer(Long id, String email, String name, String phoneNumber) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (!customer.isPresent())
			throw new RuntimeException("no customer found");

		Optional<Customer> custo = customerRepository.findByEmailAndNotEqualId(id, email);

		if (!custo.isEmpty())
			throw new RuntimeException("Email was taken");

		Optional<Customer> custPhone = customerRepository.findByPhonenumberAndNotEqualId(id, phoneNumber);

		if (!custPhone.isEmpty())
			throw new RuntimeException("Phone number was taken");

		return customerRepository.saveAndFlush(new Customer(id, name, email, phoneNumber));
	}

	@Override
	public Customer getCustomer(Long id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (!customer.isPresent())
			throw new RuntimeException("no customer found");

		return customer.get();
	}

}
