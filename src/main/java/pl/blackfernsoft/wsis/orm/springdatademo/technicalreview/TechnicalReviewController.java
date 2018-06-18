package pl.blackfernsoft.wsis.orm.springdatademo.technicalreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("technical-reviews")
public class TechnicalReviewController {

    @Autowired
    private TechnicalReviewRepository technicalReviewRepository;

    @GetMapping("")
    public Page<TechnicalReview> findAll(Pageable pageable) {
        return technicalReviewRepository.findAll(pageable);
    }

    @PostMapping("")
    public TechnicalReview create(@RequestBody @Valid TechnicalReview technicalReview) {
        return technicalReviewRepository.save(technicalReview);
    }

    @DeleteMapping("")
    public void delete(@RequestBody TechnicalReview technicalReview) {
        technicalReviewRepository.delete(technicalReview);
    }
}
