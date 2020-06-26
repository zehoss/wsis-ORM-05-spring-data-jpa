package pl.blackfernsoft.wsis.orm.springdatademo.domain.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springdatademo.domain.common.exceptions.CustomerNotFoundException;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("")
    public Page<Customer> findAll(Pageable pageable) {
        return customerRepository.findAll(pageable);
    }

    @GetMapping("{id}")
    public Customer findById(@PathVariable(name = "id") Long id) {
        return this.customerRepository.findById(id)
                .orElseThrow(() -> new CustomerNotFoundException("Nie znaleziono klienta o podanym id", id));
    }

    @PostMapping("")
    public Customer create(@RequestBody @Valid Customer customer) {
        return customerRepository.save(customer);
    }

    @DeleteMapping("")
    public void delete(@RequestBody Customer customer) {
        customerRepository.delete(customer);
    }

}
