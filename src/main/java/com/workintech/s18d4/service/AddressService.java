package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Address;

public interface AddressService {

    Address save(Address address);

    Address findById(long id);
}
