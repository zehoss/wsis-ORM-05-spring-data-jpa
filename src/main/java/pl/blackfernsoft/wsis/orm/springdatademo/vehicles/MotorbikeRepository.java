package pl.blackfernsoft.wsis.orm.springdatademo.vehicles;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.blackfernsoft.wsis.orm.springdatademo.vehicles.entity.Motorbike;

public interface MotorbikeRepository extends JpaRepository<Motorbike, Long> {
}
