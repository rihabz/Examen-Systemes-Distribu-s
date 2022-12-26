package com.example.customerservice.query.repository;

import com.example.customerservice.query.entitie.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<AccountTransaction,Long> {
}
