package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Account;

public interface AccountService {

    Account save(Account account);

    Account findById(long id);

}
