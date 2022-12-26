package com.example.inventoryservice.CommandsController.aggregates;

import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String accoutId;
    private String currency;
    private double balance ;
}
