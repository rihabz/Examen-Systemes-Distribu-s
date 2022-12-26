package com.example.customerservice.commonapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Data
public class CreateAccountRequestDTO {
    private String currency ;
    private double initialBalance;
}
