package pl.blackfernsoft.wsis.orm.springdatademo.vehicles.entity;

import pl.blackfernsoft.wsis.orm.springdatademo.common.Address;
import pl.blackfernsoft.wsis.orm.springdatademo.common.enums.CarType;
import pl.blackfernsoft.wsis.orm.springdatademo.customer.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
// Can't set @Table if inheritance strategy is SINGLE_TABLE
@NamedQueries({
        @NamedQuery(
                name = "Car.findIfExpiredReview",
                query = "from Vehicle c where c.firstRegistrationDate <= :firstRegistrationDate ")
})
public class Car extends Vehicle {

    private Integer numberOfSeats;

    @Enumerated(EnumType.ORDINAL)
    private CarType carType;

    @ElementCollection
    @CollectionTable(name = "RENTAL_ADDRESS", joinColumns = @JoinColumn(name = "CAR_ID"))
    private List<Address> rentalAddress = new ArrayList<Address>();

    @ElementCollection
    @CollectionTable(name = "RENTAL_DATES", joinColumns = @JoinColumn(name = "CAR_ID"))
    @Column(name = "RENTAL_DATES")
    private Collection<Date> rentalDates = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "vehicles")
    private List<Customer> customers = new ArrayList<>();


    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public CarType getCarType() {
        return carType;
    }

    public void setCarType(CarType carType) {
        this.carType = carType;
    }

    public List<Address> getRentalAddress() {
        return rentalAddress;
    }

    public void setRentalAddress(List<Address> rentalAddress) {
        this.rentalAddress = rentalAddress;
    }

    public Collection<Date> getRentalDates() {
        return rentalDates;
    }

    public void setRentalDates(Collection<Date> rentalDates) {
        this.rentalDates = rentalDates;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfSeats=" + numberOfSeats +
                ", carType=" + carType +
                ", rentalAddress=" + rentalAddress +
                ", rentalDates=" + rentalDates +
                "} " + super.toString();
    }
}
