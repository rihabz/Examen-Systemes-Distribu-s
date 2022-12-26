package com.example.customerservice.commonapi.exceptions;

public class NegativeInitialBalanceException extends RuntimeException{
    public NegativeInitialBalanceException(String negativeBalance) {
        super(negativeBalance);
    }
}
