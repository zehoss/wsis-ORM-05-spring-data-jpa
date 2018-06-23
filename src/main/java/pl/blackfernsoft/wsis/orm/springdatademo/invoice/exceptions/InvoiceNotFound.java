package pl.blackfernsoft.wsis.orm.springdatademo.invoice.exceptions;

public class InvoiceNotFound extends RuntimeException {
    private final Long invoiceId;

    public InvoiceNotFound(String s, Long invoiceId) {
        this.invoiceId = invoiceId;
    }
}
