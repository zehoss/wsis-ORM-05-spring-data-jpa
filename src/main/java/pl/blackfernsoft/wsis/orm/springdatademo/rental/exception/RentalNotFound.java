package pl.blackfernsoft.wsis.orm.springdatademo.rental.exception;

public class RentalNotFound extends RuntimeException {
    private final Long rentalId;

    public RentalNotFound(String s, Long rentalId) {
        this.rentalId = rentalId;
    }
}
