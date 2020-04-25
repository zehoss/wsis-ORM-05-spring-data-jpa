package pl.blackfernsoft.wsis.orm.springdatademo.domain.vehicles.entity;


import pl.blackfernsoft.wsis.orm.springdatademo.domain.common.enums.Color;
import pl.blackfernsoft.wsis.orm.springdatademo.domain.technicalreview.TechnicalReview;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE")
public abstract class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "PLATES_NUMBER")
    private String platesNumber;

    @Column(name = "FIRST_REGISTRATION")
    private Date firstRegistrationDate = new Date();

    @Enumerated(EnumType.STRING)
    private Color color;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "CAR_ID")
    private Set<TechnicalReview> technicalReview = new HashSet<>();

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlatesNumber() {
        return platesNumber;
    }

    public void setPlatesNumber(String platesNumber) {
        this.platesNumber = platesNumber;
    }

    public Date getFirstRegistrationDate() {
        return firstRegistrationDate;
    }

    public void setFirstRegistrationDate(Date firstRegistrationDate) {
        this.firstRegistrationDate = firstRegistrationDate;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Set<TechnicalReview> getTechnicalReview() {
        return technicalReview;
    }

    public void setTechnicalReview(Set<TechnicalReview> technicalReview) {
        this.technicalReview = technicalReview;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", platesNumber='" + platesNumber + '\'' +
                ", firstRegistrationDate=" + firstRegistrationDate +
                ", color=" + color +
                '}';
    }
}
