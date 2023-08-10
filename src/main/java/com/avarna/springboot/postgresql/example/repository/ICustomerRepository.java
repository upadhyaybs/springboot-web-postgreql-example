package com.avarna.springboot.postgresql.example.repository;

import com.avarna.springboot.postgresql.example.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity,UUID> {
}
