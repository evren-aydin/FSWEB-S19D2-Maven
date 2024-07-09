package com.workintech.s18d4.repository;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("SELECT c FROM Customer c")
    List<Customer> findAll();

    @Query("DELETE FROM Customer c WHERE c.id=:id")
    void delete(long id);
}
