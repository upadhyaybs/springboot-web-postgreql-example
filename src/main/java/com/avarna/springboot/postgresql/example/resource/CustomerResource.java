package com.avarna.springboot.postgresql.example.resource;

import com.avarna.springboot.postgresql.example.domain.Customer;
import com.avarna.springboot.postgresql.example.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerResource {

    private final ICustomerService service;

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return service.save(customer);
    }

    @PutMapping
    public void update(@RequestBody Customer customer){
         service.update(customer.getId(),customer);
    }

    @GetMapping
    public List<Customer> getAll(){
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    public Customer findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @DeleteMapping("/id/{id}")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
