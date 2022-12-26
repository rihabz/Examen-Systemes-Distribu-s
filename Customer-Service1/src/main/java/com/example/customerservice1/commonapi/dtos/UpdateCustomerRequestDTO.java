package com.example.customerservice1.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateCustomerRequestDTO {
    private String nom;
    private String adresse;
    private String adresseEmail;
}
