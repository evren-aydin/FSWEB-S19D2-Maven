package com.workintech.s18d4.controller;

import com.workintech.s18d4.entity.Address;
import com.workintech.s18d4.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workintech")
public class AddressController {

    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    public List<Address> findAll(){
        return addressService.findAll();
    }
    @GetMapping("/address/{id}")
    public Address findById(@PathVariable long id){
        return addressService.findById(id);
    }
    @PostMapping("/address")
    public Address save(@RequestBody Address address){
        return addressService.save(address);
    }

    @PutMapping("/address/{id}")
    public void update(@PathVariable long id,@RequestBody Address address){
        Address address1 = addressService.findById(id);
        if (address1!=null){
            address1.setCity(address.getCity());
            address1.setNo(address.getNo());
            address1.setCountry(address.getCountry());
            address1.setStreet(address.getStreet());
            address1.setDescription(address.getDescription());
            address1.setCustomer(address.getCustomer());
        }

    }

    @DeleteMapping("/address/{id}")
    public void delete(@PathVariable long id){
        addressService.delete(id);
    }


}
