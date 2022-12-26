package com.example.inventoryservice.events;

import lombok.Getter;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class BaseEvent<T>{
    @Getter
    @TargetAggregateIdentifier
    private T id;

    public BaseEvent(T id) {
        this.id = id;
    }
}
