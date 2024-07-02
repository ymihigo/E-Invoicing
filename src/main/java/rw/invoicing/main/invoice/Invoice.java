package rw.invoicing.main.invoice;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import rw.invoicing.main.customer.Customer;

@Entity
@Table
public class Invoice {
	@Id
	@SequenceGenerator(name = "invoice_sequence", sequenceName = "invoice_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "invoice_sequence")
	private Long id;
	private Double amount = 0.0;
	private LocalDate invoiceDate = LocalDate.now();

	@ManyToOne
	@JoinColumn(name = "Customer")
	private Customer customerId;

	@Enumerated(EnumType.STRING)
	private InvoiceStatus status = InvoiceStatus.PAID;

	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Invoice(Long id, Double amount, LocalDate invoiceDate, Customer customerId, InvoiceStatus status) {
		super();
		this.id = id;
		this.amount = amount;
		this.invoiceDate = invoiceDate;
		this.customerId = customerId;
		this.status = status;

	}

	public Invoice(Double amount, LocalDate invoiceDate, Customer customerId, InvoiceStatus status) {
		super();
		this.amount = amount;
		this.invoiceDate = invoiceDate;
		this.customerId = customerId;
		this.status = status;
	}


	public Invoice(Double amount, Customer customerId, InvoiceStatus status) {
		super();
		this.amount = amount;
		this.customerId = customerId;
		this.status = status;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Customer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Customer customerId) {
		this.customerId = customerId;
	}

	public InvoiceStatus getStatus() {
		return status;
	}

	public void setStatus(InvoiceStatus status) {
		this.status = status;
	}

}
