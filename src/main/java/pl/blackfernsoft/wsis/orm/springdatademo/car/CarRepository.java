package pl.blackfernsoft.wsis.orm.springdatademo.car;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
