package rw.invoicing.main.invoice;

import java.util.List;

public interface InvoiceServiceInterface {

	Invoice createInvoice(Double amount, Long customerId, InvoiceStatus status);

	public void deleteInvoice(Long id);

	public Invoice updateInvoice(Long id, Double amount, Long customerId, InvoiceStatus status);

	public Invoice getInvoice(Long id);

	public List<Invoice> getAllInvoice();

	public List<Invoice> getCustomerInvoice(Long customerId);
}
