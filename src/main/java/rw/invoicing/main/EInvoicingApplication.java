package rw.invoicing.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class EInvoicingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EInvoicingApplication.class, args);
	}

}
