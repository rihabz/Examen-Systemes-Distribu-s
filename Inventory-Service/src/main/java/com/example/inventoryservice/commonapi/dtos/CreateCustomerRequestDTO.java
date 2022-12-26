package com.example.inventoryservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomerRequestDTO {
    private String nom;
    private String adresse;
    private String adresseEmail;
}
