package com.workintech.s18d4.repository;

import com.workintech.s18d4.entity.Account;
import com.workintech.s18d4.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query("SELECT a FROM Account a")
    List<Account> findAll();

    @Query("DELETE FROM Account a WHERE a.id=:id")
    void delete(long id);
}
