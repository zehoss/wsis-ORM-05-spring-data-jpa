package pl.blackfernsoft.wsis.orm.springdatademo.domain.invoice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springdatademo.domain.invoice.exceptions.InvoiceNotFound;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @GetMapping("")
    public Page<Invoice> findAll(Pageable pageable) {
        return invoiceRepository.findAll(pageable);
    }

    @GetMapping("{invoiceId}")
    public Invoice findById(@PathVariable(name = "invoiceId") Long invoiceId) {
        Optional<Invoice> invoice = this.invoiceRepository.findById(invoiceId);
        if (!invoice.isPresent()) {
            throw new InvoiceNotFound("Nie znaleziono faktury o podanym id", invoiceId);
        }
        return invoice.get();
    }

    @PostMapping("")
    public Invoice create(@RequestBody @Valid Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Invoice invoice) {
        invoiceRepository.delete(invoice);
    }

}
