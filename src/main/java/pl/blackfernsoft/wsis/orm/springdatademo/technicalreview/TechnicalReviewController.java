package pl.blackfernsoft.wsis.orm.springdatademo.technicalreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TechnicalReviewController {

    @Autowired
    TechnicalReviewRepository technicalReviewRepository;

    @GetMapping("/technicalReview")
    public List<TechnicalReview> getTechnicalReview() {
        return technicalReviewRepository.findAll();
    }
}
