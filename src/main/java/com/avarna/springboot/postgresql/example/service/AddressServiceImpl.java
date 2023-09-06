package com.avarna.springboot.postgresql.example.service;

import com.avarna.springboot.postgresql.example.domain.Address;
import com.avarna.springboot.postgresql.example.entity.AddressEntity;
import com.avarna.springboot.postgresql.example.repository.IAddressRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AddressServiceImpl implements IAddressService{

    private final IAddressRepository repository;
    private final ModelMapper mapper;

    public AddressServiceImpl(IAddressRepository repository, ModelMapper mapper){
        this.repository=repository;
        this.mapper=mapper;
    }

    @Override
    public Address createAddress(Address addresses) {
        AddressEntity entity= mapper.map(addresses, AddressEntity.class);
        entity.setCreatedBy("address-api");
        entity.setCreatedOn(LocalDateTime.now());
        repository.save(entity);
        return mapper.map(entity, Address.class);
    }
}
