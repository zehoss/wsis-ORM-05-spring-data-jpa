package pl.blackfernsoft.wsis.orm.springdatademo.common.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    private final Long customerId;

    public CustomerNotFoundException(String s, Long id) {
        this.customerId = id;
    }
}
