package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;

public interface CustomerService {

    Customer save(Customer customer);

    Customer findById(long id);
}
