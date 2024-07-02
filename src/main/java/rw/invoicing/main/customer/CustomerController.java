package rw.invoicing.main.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import rw.invoicing.main.exceptionHandler.InvalidParameters;

import rw.invoicing.main.invoice.InvoiceServiceInterface;

@RestController
@RequestMapping(path = "/customer")

public class CustomerController {

	@Autowired
	private CustomerServiceInterface customerService;

	@Autowired
	private InvoiceServiceInterface invoiceService;

	@PostMapping(path = "/")
	public ResponseEntity<Customer> create(@RequestBody Customer customer) throws InvalidParameters {
		try {
			return ResponseEntity.ok().body(
					customerService.createCustomer(customer.getName(), customer.getEmail(), customer.getPhoneNumber()));
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<Customer>> getAll() throws InvalidParameters {
		try {
			return ResponseEntity.ok().body(customerService.findAll());
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@DeleteMapping(path = "/{customerId}")

	public String deleteCustomer(@PathVariable("customerId") Long id) throws InvalidParameters {
		try {
			customerService.deleteCustomer(id);
			return "Success";
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@PutMapping(path = "/")

	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) throws InvalidParameters {
		try {
			return ResponseEntity.ok().body(customerService.updateCustomer(customer.getId(), customer.getEmail(),
					customer.getName(), customer.getPhoneNumber()));
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@GetMapping(path = "/{customerId}")

	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") Long id) throws InvalidParameters {
		try {
			return ResponseEntity.ok().body(customerService.getCustomer(id));
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

}
