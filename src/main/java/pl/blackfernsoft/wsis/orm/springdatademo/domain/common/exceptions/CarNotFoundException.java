package pl.blackfernsoft.wsis.orm.springdatademo.domain.common.exceptions;

public class CarNotFoundException extends RuntimeException {
    private Long carId;

    public CarNotFoundException(Long carId) {
        this.carId = carId;
    }

    public CarNotFoundException(String s, Long carId) {
        super(s);
        this.carId = carId;
    }
}
