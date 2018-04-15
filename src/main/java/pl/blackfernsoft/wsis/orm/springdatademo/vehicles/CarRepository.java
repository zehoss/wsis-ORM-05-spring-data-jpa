package pl.blackfernsoft.wsis.orm.springdatademo.vehicles;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.blackfernsoft.wsis.orm.springdatademo.vehicles.entity.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
