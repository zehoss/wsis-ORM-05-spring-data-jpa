package pl.blackfernsoft.wsis.orm.springdatademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.blackfernsoft.wsis.orm.springdatademo.car.TechnicalReview;

public interface TechnicalReviewRepository extends JpaRepository<TechnicalReview, Long> {
}
