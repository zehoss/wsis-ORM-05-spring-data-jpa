package pl.blackfernsoft.wsis.orm.springdatademo.domain.common.exceptions;

public class TechnicalReviewNotFoundException extends RuntimeException {
    private final Long technicalReviewId;

    public TechnicalReviewNotFoundException(String s, Long technicalReviewId) {
        this.technicalReviewId = technicalReviewId;
    }
}
