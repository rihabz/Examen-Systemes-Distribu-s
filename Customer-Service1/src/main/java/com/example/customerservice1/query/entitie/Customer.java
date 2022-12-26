package com.example.customerservice1.query.entitie;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
public class Customer {
    @Id
    private String customerId;
    private String nom;
    private String adresse;
    private String adresseEmail;

    public Customer() {
    }
}
