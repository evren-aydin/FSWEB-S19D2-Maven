package com.workintech.s18d4.controller;


import com.workintech.s18d4.dto.AccountResponse;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.AccountService;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/workintech")
public class AccountController {

    private AccountService accountService;
    private CustomerService customerService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @Autowired
    public AccountController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/accounts")
    public List<AccountResponse> findAll() {
        List<Account> accounts = accountService.findAll();
        List<AccountResponse> accountResponses = new ArrayList<>();

        for (Account account : accounts) {
            accountResponses.add(new AccountResponse(account.getAccountName()));
        }

        return accountResponses;
    }
    @GetMapping("/accounts/{id}")
    public AccountResponse findById(@PathVariable long id){
        Account account =accountService.findById(id);
        return new AccountResponse(account.getAccountName());

    }
    @PostMapping("/accounts/{customerId}")
    public AccountResponse save(@PathVariable long customerId,@RequestBody Account account){
        Customer customer = customerService.findById(customerId);

        account.setCustomer(customer);
        Account savedAccount = accountService.save(account);

        return new AccountResponse(savedAccount.getAccountName());

    }

    @PutMapping("/accounts/{customerId}")
    public void update(@PathVariable long customerId,@RequestBody Account account){
        Customer customer = customerService.findById(customerId);
        // Mevcut Account'u bulun
        Account existingAccount = accountService.findById(account.getId());

        existingAccount.setAccountName(account.getAccountName());
        existingAccount.setMoneyAmount(account.getMoneyAmount());

        existingAccount.setCustomer(customer);

        accountService.save(existingAccount);

    }

    @DeleteMapping("/accounts/{id}")
    public void delete(@PathVariable long id){
        accountService.delete(id);
    }
}
