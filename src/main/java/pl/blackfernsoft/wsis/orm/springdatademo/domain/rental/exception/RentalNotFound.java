package pl.blackfernsoft.wsis.orm.springdatademo.domain.rental.exception;

public class RentalNotFound extends RuntimeException {
    private final Long rentalId;

    public RentalNotFound(String s, Long rentalId) {
        this.rentalId = rentalId;
    }
}
