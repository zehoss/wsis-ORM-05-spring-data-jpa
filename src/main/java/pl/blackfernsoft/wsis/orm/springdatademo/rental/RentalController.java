package pl.blackfernsoft.wsis.orm.springdatademo.rental;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springdatademo.rental.exception.RentalNotFound;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    private RentalRepository invrentalRepositoryiceRepository;

    @GetMapping("")
    public Page<Rental> findAll(Pageable pageable) {
        return invrentalRepositoryiceRepository.findAll(pageable);
    }

    @GetMapping("{rentalId}")
    public Rental findById(@PathVariable(name = "rentalId") Long rentalId) {
        Optional<Rental> rental = this.invrentalRepositoryiceRepository.findById(rentalId);
        if (!rental.isPresent()) {
            throw new RentalNotFound("Nie znaleziono wypozyczenia o podanym id", rentalId);
        }
        return rental.get();
    }

    @PostMapping("")
    public Rental create(@RequestBody @Valid Rental rental) {
        return invrentalRepositoryiceRepository.save(rental);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Rental rental) {
        invrentalRepositoryiceRepository.delete(rental);
    }

}
