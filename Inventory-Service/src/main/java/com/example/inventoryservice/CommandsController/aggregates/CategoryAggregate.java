package com.example.inventoryservice.CommandsController.aggregates;

import com.example.inventoryservice.commonapi.commands.CreateCategoryCommand;
import com.example.inventoryservice.events.CategoryCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CategoryAggregate {
    @AggregateIdentifier
    private String categoryId;
    private String nom;
    private String description;

    public CategoryAggregate() {
    }

    @CommandHandler
    public CategoryAggregate(CreateCategoryCommand command){
        //annotation : pour indiquer qu'il est à l'écoute d'un élément CreateAccountCommand
        AggregateLifecycle.apply(new CategoryCreatedEvent(
                command.getId(),
        ));
    }
}
