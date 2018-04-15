package pl.blackfernsoft.wsis.orm.springdatademo.technicalreview;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnicalReviewRepository extends JpaRepository<TechnicalReview, Long> {
}
