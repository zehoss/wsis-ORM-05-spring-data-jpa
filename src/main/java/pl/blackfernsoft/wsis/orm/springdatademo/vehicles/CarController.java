package pl.blackfernsoft.wsis.orm.springdatademo.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springdatademo.common.exceptions.CarNotFoundException;
import pl.blackfernsoft.wsis.orm.springdatademo.technicalreview.TechnicalReview;
import pl.blackfernsoft.wsis.orm.springdatademo.vehicles.entity.Car;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("")
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @PostMapping("")
    public Car create(@RequestBody @Valid Car car) {
        return carRepository.save(car);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Car car) {
        carRepository.delete(car);
    }

    @PostMapping("{carId}/technical-review")
    public Car addTechnicalReview(@PathVariable(name = "carId") Long carId, @RequestBody TechnicalReview technicalReview) {
        Optional<Car> car = carRepository.findById(carId);
        if (!car.isPresent()) {
            throw new CarNotFoundException("Nie znaleziono pojazdu o podanym id", carId);
        }

        car.get().getTechnicalReview().add(technicalReview);
        technicalReview.setVehicle(car.get());
        return carRepository.save(car.get());
    }
}
