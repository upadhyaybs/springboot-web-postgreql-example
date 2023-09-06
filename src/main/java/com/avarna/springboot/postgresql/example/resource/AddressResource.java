package com.avarna.springboot.postgresql.example.resource;

import com.avarna.springboot.postgresql.example.domain.Address;
import com.avarna.springboot.postgresql.example.service.IAddressService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/addresses")
public class AddressResource {

    private final IAddressService service;

    public  AddressResource(IAddressService service){
        this.service=service;
    }

    @PostMapping
    public Address createAddress(@RequestBody Address addresses){
       return this.service.createAddress(addresses);
    }

}
