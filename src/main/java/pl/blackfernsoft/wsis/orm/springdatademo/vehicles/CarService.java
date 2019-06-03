package pl.blackfernsoft.wsis.orm.springdatademo.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.blackfernsoft.wsis.orm.springdatademo.common.exceptions.CarNotFoundException;
import pl.blackfernsoft.wsis.orm.springdatademo.technicalreview.TechnicalReview;
import pl.blackfernsoft.wsis.orm.springdatademo.vehicles.entity.Car;

import java.util.Optional;

@Service
class CarService {

    @Autowired
    private CarRepository carRepository;

    Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    Car addTechnicalReview(Long carId, TechnicalReview technicalReview) {
        Optional<Car> car = carRepository.findById(carId);
        if (!car.isPresent()) {
            throw new CarNotFoundException("Nie znaleziono pojazdu o podanym id", carId);
        }

        car.get().getTechnicalReview().add(technicalReview);
        technicalReview.setVehicle(car.get());
        return carRepository.save(car.get());
    }

    public Car save(CarDto carDto) {
        Car newCar = Car.of(carDto);
        return carRepository.save(newCar);
    }
}
