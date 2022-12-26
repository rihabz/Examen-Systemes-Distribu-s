package com.example.customerservice1.query.repository;

import com.example.customerservice1.query.entitie.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,String> {
}
