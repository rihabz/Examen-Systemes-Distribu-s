package com.example.customerservice1.CommandsController.agregates;

import com.example.customerservice1.commonapi.commands.CreateCustomerCommand;
import com.example.customerservice1.commonapi.commands.UpdateCustomerCommand;
import com.example.customerservice1.events.CustomerCreatedEvent;
import com.example.customerservice1.events.CustomerUpdatedEvent;
import lombok.Getter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class CustomerAggregate {
    @AggregateIdentifier
    private String customerId;
    private String nom;
    private String adresse;
    private String adresseEmail;

    public CustomerAggregate() {
    }
    @CommandHandler
            public CustomerAggregate(CreateCustomerCommand command){
    //annotation : pour indiquer qu'il est à l'écoute d'un élément CreateAccountCommand
            AggregateLifecycle.apply(new CustomerCreatedEvent (
                    command.getId(),
                    command.getNom(),
                    command.getAdresseEmail(),
                    command.getAdresse()
        ));
    }
    //Fonction De mise à jour
    @EventSourcingHandler
    public void on(CustomerCreatedEvent event){
        this.customerId =event.getId();
        this.nom =event.getNom() ;
        this.adresse =  event.getAdresse();
        this.adresseEmail = event.getAdresseEmail() ;
    }
    @CommandHandler
    public void handle(UpdateCustomerCommand command){
        //annotation : pour indiquer qu'il est à l'écoute d'un élément CreateAccountCommand
        AggregateLifecycle.apply(new CustomerUpdatedEvent(
                command.getId(),
                command.getNom(),
                command.getAdresseEmail(),
                command.getAdresse()
        ));
    }
    //Fonction De mise à jour
    @EventSourcingHandler
    public void on(CustomerUpdatedEvent event){
        this.customerId =event.getId();
        this.nom =event.getNom() ;
        this.adresse =  event.getAdresse();
        this.adresseEmail = event.getAdresseEmail() ;
    }
}
