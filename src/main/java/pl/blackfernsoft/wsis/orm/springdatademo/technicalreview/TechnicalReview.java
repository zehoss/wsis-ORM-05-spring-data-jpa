package pl.blackfernsoft.wsis.orm.springdatademo.technicalreview;

import pl.blackfernsoft.wsis.orm.springdatademo.common.enums.TechnicalReviewResultEnum;
import pl.blackfernsoft.wsis.orm.springdatademo.vehicles.entity.Vehicle;

import javax.persistence.*;
import java.util.Date;

@Entity
public class TechnicalReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Temporal(TemporalType.TIMESTAMP)
    private Date nextReview;

    @Enumerated(EnumType.STRING)
    private TechnicalReviewResultEnum result;

    @ManyToOne(fetch = FetchType.LAZY)
    private Vehicle vehicle;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getNextReview() {
        return nextReview;
    }

    public void setNextReview(Date nextReview) {
        this.nextReview = nextReview;
    }

    public TechnicalReviewResultEnum getResult() {
        return result;
    }

    public void setResult(TechnicalReviewResultEnum result) {
        this.result = result;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return "TechnicalReview{" +
                "id=" + id +
                ", date=" + date +
                ", nextReview=" + nextReview +
                ", result=" + result +
                ", vehicle=" + vehicle +
                '}';
    }
}
