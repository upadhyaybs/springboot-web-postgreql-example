package com.avarna.springboot.postgresql.example.service;

import com.avarna.springboot.postgresql.example.domain.Address;

public interface IAddressService {

    Address createAddress(Address addresses);
}
