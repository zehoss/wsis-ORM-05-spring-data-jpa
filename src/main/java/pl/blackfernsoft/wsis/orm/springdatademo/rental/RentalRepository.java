package pl.blackfernsoft.wsis.orm.springdatademo.rental;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface RentalRepository extends PagingAndSortingRepository<Rental, Long> {
}
