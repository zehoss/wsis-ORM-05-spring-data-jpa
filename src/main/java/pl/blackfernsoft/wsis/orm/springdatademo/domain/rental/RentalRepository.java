package pl.blackfernsoft.wsis.orm.springdatademo.domain.rental;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RentalRepository extends PagingAndSortingRepository<Rental, Long> {
}
