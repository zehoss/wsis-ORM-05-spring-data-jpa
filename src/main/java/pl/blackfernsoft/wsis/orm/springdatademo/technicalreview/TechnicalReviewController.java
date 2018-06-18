package pl.blackfernsoft.wsis.orm.springdatademo.technicalreview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springdatademo.common.exceptions.TechnicalReviewNotFoundException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("technical-reviews")
public class TechnicalReviewController {

    @Autowired
    private TechnicalReviewRepository technicalReviewRepository;

    @GetMapping("")
    public Page<TechnicalReview> findAll(Pageable pageable) {
        return technicalReviewRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public TechnicalReview findById(@PathVariable(name = "id") Long technicalReviewId) {
        Optional<TechnicalReview> technicalReview = this.technicalReviewRepository.findById(technicalReviewId);
        if (!technicalReview.isPresent()) {
            throw new TechnicalReviewNotFoundException("Nie znaleziono przeglądu o podanym id", technicalReviewId);
        }
        return technicalReview.get();
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
