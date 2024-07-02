package rw.invoicing.main;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import rw.invoicing.main.customer.Customer;
import rw.invoicing.main.customer.CustomerRepository;
import rw.invoicing.main.customer.CustomerServiceInterface;

@SpringBootTest
class EInvoicingApplicationTests {

	@Autowired
	private CustomerServiceInterface customerService;

	private MockMvc mockMvc;

	@Test
	void contextLoads() {
	}
	
//	@Test
//	public void createCustomerTest() {
//		Customer custo = customerService.createCustomer("MIHIGO", "xxxx90@0xx.xx", "8780006123");
//		
//		Assertions.assertEquals(new Customer(custo.getId(), "MIHIGO", "xxxx90@0xx.xx", "9780006123"), custo);
//	}
	
	
}
