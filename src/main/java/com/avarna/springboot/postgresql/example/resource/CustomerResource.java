package com.avarna.springboot.postgresql.example.resource;

import com.avarna.springboot.postgresql.example.domain.Customer;
import com.avarna.springboot.postgresql.example.service.ICustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@Api(value = "Customer Management")
public class CustomerResource {

    private final ICustomerService service;


    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return service.save(customer);
    }

    @PutMapping
    @ApiOperation(value = "Update a customer")
    public void update(@RequestBody Customer customer){
         service.update(customer.getId(),customer);
    }

    @GetMapping
    @ApiOperation(value = "View a list of all the customers", response = List.class)
    public List<Customer> getAll(){
        return service.getAll();
    }

    @GetMapping("/id/{id}")
    @ApiOperation(value = "Get a customer by its ID")
    public Customer findById(@PathVariable UUID id){
        return service.findById(id);
    }

    @DeleteMapping("/id/{id}")
    @ApiOperation(value = "Delete a customer by its ID")
    public void delete(@PathVariable UUID id){
        service.delete(id);
    }
}
