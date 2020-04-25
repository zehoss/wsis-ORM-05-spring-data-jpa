package pl.blackfernsoft.wsis.orm.springdatademo.domain.invoice;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface InvoiceRepository extends PagingAndSortingRepository<Invoice, Long> {
}
