package pl.blackfernsoft.wsis.orm.springdatademo.domain.customer;


import pl.blackfernsoft.wsis.orm.springdatademo.domain.common.Address;
import pl.blackfernsoft.wsis.orm.springdatademo.domain.vehicles.entity.Vehicle;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(
                name = "Customer.findCustomersWithXCars",
                query = "from Customer c where c.vehicles.size >= :numberOfCars"
        )
})
@Entity
public class Customer {

//    @EmbeddedId
//    private CustomerPK primaryKey;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CREATED_AT", nullable = false, updatable = false)
    private Date creationDate = new Date();

    @Embedded
    private Address address;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "CUSTOMER_VEHICLE",
            joinColumns = @JoinColumn(name = "CUSTOMER_ID"),
            inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
    private List<Vehicle> vehicles = new ArrayList<>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> cars) {
        this.vehicles = cars;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", creationDate=" + creationDate +
                ", address=" + address +
                ", vehicles=" + vehicles +
                '}';
    }
}
