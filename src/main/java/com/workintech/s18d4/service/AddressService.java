package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;

import java.util.List;

public interface AddressService {

    Address save(Address address);

    Address findById(long id);

    List<Address> findAll();
    void delete(long id);
}
