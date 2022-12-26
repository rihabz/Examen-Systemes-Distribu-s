package com.example.customerservice.query.repository;

import com.example.customerservice.query.entitie.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
}
