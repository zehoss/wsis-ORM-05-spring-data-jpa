package pl.blackfernsoft.wsis.orm.springdatademo.vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springdatademo.vehicles.entity.Car;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("")
    public List<Car> getCarList() {
        return carRepository.findAll();
    }

    @PostMapping("")
    public Car createCar(/*should get some parameters from POST request*/) {
        Car car = new Car();
        car.setName("Fiat");

        return carRepository.save(car);
    }

    /**
     * Warning - creating object using GET request method is not a good practice!
     * This is just an example.
     */
    @GetMapping("/createCar")
    public Car createCarGet(@RequestParam("name") String name, @RequestParam("plates") String plates) {
        Car car = new Car();
        car.setName(name);
        car.setPlatesNumber(plates);

        return carRepository.save(car);
    }

}
