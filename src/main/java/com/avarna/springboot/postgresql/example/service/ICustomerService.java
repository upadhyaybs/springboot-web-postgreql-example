package com.avarna.springboot.postgresql.example.service;

import com.avarna.springboot.postgresql.example.domain.Customer;


import java.util.List;
import java.util.UUID;

public interface ICustomerService {

    Customer save(Customer member);

    Customer findById(UUID uui);

    List<Customer> getAll();

    void update(UUID id, Customer member);

   void delete(UUID id);
}
