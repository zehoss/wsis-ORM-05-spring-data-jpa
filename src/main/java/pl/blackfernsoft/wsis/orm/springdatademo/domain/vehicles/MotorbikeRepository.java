package pl.blackfernsoft.wsis.orm.springdatademo.domain.vehicles;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.blackfernsoft.wsis.orm.springdatademo.domain.vehicles.entity.Motorbike;

public interface MotorbikeRepository extends JpaRepository<Motorbike, Long> {
}
