package com.workintech.s18d4.controller;


import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/workintech")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }


    @GetMapping("/customers")
    public List<CustomerResponse> findAll(){
        List<Customer> customers= customerService.findAll();
        List<CustomerResponse> customerResponses = new ArrayList<>();
        for (Customer customer:customers){
          customerResponses.add(new CustomerResponse(customer.getFirstName(),customer.getLastName(),customer.getEmail()));
        }
        return customerResponses;
    }
    @GetMapping("/customers/{id}")
    public CustomerResponse findById(@PathVariable long id){
        Customer customer =customerService.findById(id);
        return new CustomerResponse(customer.getFirstName(),customer.getLastName(),customer.getEmail());


    }
    @PostMapping("/customers")
    public CustomerResponse save(@RequestBody Customer customer){
        Customer customer1= customerService.save(customer);
        return new CustomerResponse(customer1.getFirstName(),customer1.getLastName(),customer1.getEmail());

    }

    @PutMapping("/customers/{id}")
    public void update(@PathVariable long id,@RequestBody Customer customer){
        Customer customer1 = customerService.findById(id);
        if (customer1!=null){
            customer1.setFirstName(customer.getFirstName());
            customer1.setLastName(customer.getLastName());
            customer1.setEmail(customer.getEmail());
            customer1.setSalary(customer.getSalary());
            customer1.setAddress(customer.getAddress());
        }

    }

    @DeleteMapping("/customers/{id}")
    public void delete(@PathVariable long id){
        customerService.delete(id);
    }
}
