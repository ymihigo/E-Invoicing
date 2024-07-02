package rw.invoicing.main.invoice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping(path = "/invoice")
public class InvoiceController {

	@Autowired
	private InvoiceServiceInterface invoiceService;

	@PostMapping(path = "/new")
	public ResponseEntity<Invoice> create(@RequestBody InvoicePayload invoice) throws InvalidParameters {
		try {
			return ResponseEntity.ok().body(
					invoiceService.createInvoice(invoice.getAmount(), invoice.getCustomerId(), invoice.getStatus()));
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@GetMapping(path = "/")
	public ResponseEntity<List<Invoice>> getAllInvoice() throws InvalidParameters {
		try {
			return ResponseEntity.ok().body(invoiceService.getAllInvoice());
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Invoice> getOneInvoice(@PathVariable(name = "id") Long id) throws InvalidParameters {
		try {
			return ResponseEntity.ok().body(invoiceService.getInvoice(id));
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@DeleteMapping(path = "/{id}")
	public void deleteOneInvoice(@PathVariable(name = "id") Long id) throws InvalidParameters {
		try {
			invoiceService.deleteInvoice(id);
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}

	@PutMapping
	public ResponseEntity<Invoice> updateInvoice(@RequestBody InvoicePayload payload) throws InvalidParameters {
		try {

			return ResponseEntity.ok().body(invoiceService.updateInvoice(payload.getId(), payload.getAmount(),
					payload.getCustomerId(), payload.getStatus()));
		} catch (Exception ex) {
			throw new InvalidParameters(ex.getMessage());
		}
	}
}
