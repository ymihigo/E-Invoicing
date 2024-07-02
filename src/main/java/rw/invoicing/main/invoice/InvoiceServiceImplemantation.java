package rw.invoicing.main.invoice;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rw.invoicing.main.customer.Customer;
import rw.invoicing.main.customer.CustomerRepository;

@Service
public class InvoiceServiceImplemantation implements InvoiceServiceInterface {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private InvoiceRepository invoiceRepository;

	@Override
	public Invoice createInvoice(Double amount, Long customerId, InvoiceStatus status) {
		try {

			Optional<Customer> customer = customerRepository.findById(customerId);

			if (!customer.isPresent())
				throw new RuntimeException("no customer found");

			return invoiceRepository.saveAndFlush(new Invoice(amount, LocalDate.now(), customer.get(), status));
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage());
		}
	}

	@Override
	public void deleteInvoice(Long id) {
		Optional<Invoice> invoice = invoiceRepository.findById(id);

		if (!invoice.isPresent())
			throw new RuntimeException("No invoice found");
		invoiceRepository.delete(invoice.get());

	}

	@Override
	public Invoice updateInvoice(Long id, Double amount, Long customerId, InvoiceStatus status) {
		Optional<Invoice> invoice = invoiceRepository.findById(id);

		if (!invoice.isPresent())
			throw new RuntimeException("No invoice found");

		Optional<Customer> customer = customerRepository.findById(customerId);

		if (!customer.isPresent())
			throw new RuntimeException("no customer found");

		Invoice in = new Invoice(id, amount, LocalDate.now(), customer.get(), status);

		return invoiceRepository.saveAndFlush(in);
	}

	@Override
	public Invoice getInvoice(Long id) {
		Optional<Invoice> invoice = invoiceRepository.findById(id);

		if (!invoice.isPresent())
			throw new RuntimeException("No invoice found");
		return invoice.get();
	}

	@Override
	public List<Invoice> getAllInvoice() {
		return invoiceRepository.findAll();
	}

	@Override
	public List<Invoice> getCustomerInvoice(Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}

}
