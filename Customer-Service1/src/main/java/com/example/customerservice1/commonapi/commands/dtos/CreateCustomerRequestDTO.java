package com.example.customerservice1.commonapi.commands.dtos;

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
