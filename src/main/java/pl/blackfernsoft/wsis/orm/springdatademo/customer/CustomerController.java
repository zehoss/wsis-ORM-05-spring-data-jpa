package pl.blackfernsoft.wsis.orm.springdatademo.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pl.blackfernsoft.wsis.orm.springdatademo.common.exceptions.CustomerNotFoundException;

import javax.validation.Valid;
import java.util.Optional;

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
        Optional<Customer> customer = this.customerRepository.findById(id);
        if (!customer.isPresent()) {
            throw new CustomerNotFoundException("Nie znaleziono klienta o podanym id", id);
        }
        return customer.get();
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
