package com.avarna.springboot.postgresql.example.service;

import com.avarna.springboot.postgresql.example.domain.Customer;
import com.avarna.springboot.postgresql.example.entity.CustomerEntity;
import com.avarna.springboot.postgresql.example.exception.CustomerNotFoundException;
import com.avarna.springboot.postgresql.example.repository.ICustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;


import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final ICustomerRepository memberRepository;

    private final ModelMapper modelMapper;

    @Override
    public Customer save(Customer customer) {
        CustomerEntity customerEntity = convertToEntity(customer);
        customerEntity.setCreatedBy("customer-api");
        customerEntity.setCreatedOn(LocalDateTime.now());
        memberRepository.save(customerEntity);
       return convertToDto(customerEntity);
    }

    @Override
    public Customer findById(UUID id) {
        Optional<CustomerEntity> optionalMemberEntity = memberRepository.findById(id);
        return optionalMemberEntity.map(memberEntity -> modelMapper.map(memberEntity, Customer.class))
                .orElseThrow(()-> new CustomerNotFoundException("Customer id is not found :" + id.toString()));
    }

    @Override
    public List<Customer> getAll() {
        List<CustomerEntity> customerEntities = memberRepository.findAll();
        if (!customerEntities.isEmpty()){
            Type targetListType =new TypeToken<List<Customer>>(){}.getType();
            return modelMapper.map(customerEntities,targetListType);
        }
        throw new CustomerNotFoundException("Customers not found");
    }

    @Override
    public void update(UUID id, Customer member) {
        Optional<CustomerEntity> optionalCustomerEntity = memberRepository.findById(id);
        if (optionalCustomerEntity.isPresent()) {
            CustomerEntity existingMember = optionalCustomerEntity.get();
            modelMapper.map(member, existingMember);
            memberRepository.save(existingMember);
        } else {
            // Handle the case when member with the given ID is not found
            throw new CustomerNotFoundException("Customer not found with ID: " + id);
        }
    }

    @Override
    public void delete(UUID id) {
        memberRepository.deleteById(id);
    }

    private Customer convertToDto(CustomerEntity memberEntity) {
        return modelMapper.map(memberEntity, Customer.class);
    }

    private CustomerEntity convertToEntity(Customer member) {
        return modelMapper.map(member, CustomerEntity.class);
    }

    private Throwable handleDataAccessException(Throwable ex) {
        // Perform custom error handling here if needed
        return new RuntimeException("Failed to save member to the database", ex);
    }
}
