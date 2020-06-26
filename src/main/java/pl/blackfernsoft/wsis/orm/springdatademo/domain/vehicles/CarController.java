package pl.blackfernsoft.wsis.orm.springdatademo.domain.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springdatademo.domain.common.exceptions.CarNotFoundException;
import pl.blackfernsoft.wsis.orm.springdatademo.domain.technicalreview.TechnicalReview;
import pl.blackfernsoft.wsis.orm.springdatademo.domain.vehicles.entity.Car;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("")
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    // This is a simplified endpoint which just returns a plain list of cars
    // - this is not a good practice for returning lists in restapi without using pagination by default!
    @GetMapping("list")
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @GetMapping("{carId}")
    public Car findById(@PathVariable(name = "carId") Long carId) {
        return this.carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Nie znaleziono pojazdu o podanym id", carId));
    }

    @PostMapping("")
    public Car create(@RequestBody @Valid Car car) {
        return carRepository.save(car);
    }

    @PutMapping("{carId}")
    public Car update(@PathVariable(name = "carId") Long carId, @RequestBody @Valid Car car) {
        car.setId(carId);
        return carRepository.save(car);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Car car) {
        carRepository.delete(car);
    }

    @PostMapping("{carId}/technical-review")
    public Car addTechnicalReview(@PathVariable(name = "carId") Long carId, @RequestBody TechnicalReview technicalReview) {
        Car car = this.carRepository.findById(carId)
                .orElseThrow(() -> new CarNotFoundException("Nie znaleziono pojazdu o podanym id", carId));

        car.getTechnicalReview().add(technicalReview);
        technicalReview.setVehicle(car);
        return carRepository.save(car);
    }
}
