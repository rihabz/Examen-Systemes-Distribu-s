package com.example.customerservice.controllers.aggregates;



import com.example.customerservice.commonapi.commands.CreateAccountCommand;
import com.example.customerservice.commonapi.commands.CreditAccountCommand;
import com.example.customerservice.commonapi.commands.DebitAccountCommand;
import com.example.customerservice.commonapi.enums.AccountStatus;
import com.example.customerservice.commonapi.exceptions.NegativeInitialBalanceException;
import com.example.customerservice.event.AccountCreatedEvent;
import com.example.customerservice.event.AccountCreditedEvent;
import com.example.customerservice.event.AccountDebitedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class AccountAggregate {

    @AggregateIdentifier
    private String accoutId;
    private String currency;
    private double balance ;
    private AccountStatus status;

    public  AccountAggregate(){}
    //Fonction de décision
    @CommandHandler
    //annotation : pour indiquer qu'il est à l'écoute d'un élément CreateAccountCommand
    public  AccountAggregate(CreateAccountCommand command) {
        if(command.getInitialSolde()<0) throw new NegativeInitialBalanceException("Negative Balance");
        //La méthode apply de la classe AggregateLifecycle est utilisée pour appliquer un événement à un agrégat.
        // Un événement est un message qui décrit un changement qui a eu lieu dans le système, et il est utilisé pour mettre à jour l'état de l'agrégat.
        AggregateLifecycle.apply(new AccountCreatedEvent(
                command.getId(),
                command.getCurrency(),
                command.getInitialSolde(),
                AccountStatus.CREATED
        ));
    }
    //Fonction De mise à jour
    @EventSourcingHandler
    public void on(AccountCreatedEvent event){
        this.accoutId = event.getId();
        this.balance =event.getBalance() ;
        this.status =  event.getStatus();
        this.currency = event.getCurrency() ;
    }

    @CommandHandler
    public  void handle (CreditAccountCommand command){
        if(command.getAmount()<0) throw new NegativeInitialBalanceException("Negative Amount");
        //Créer un événement
        AggregateLifecycle.apply(new AccountCreditedEvent(
                command.getId(),
                command.getCurrency(),
                command.getAmount()
        ));
    }
    @EventSourcingHandler
    public void on(AccountCreditedEvent event){
        this.balance = this.balance + event.getAmount() ;
    }

    @CommandHandler
    public  void handle (DebitAccountCommand command){
        if(command.getAmount()<0) throw new NegativeInitialBalanceException("Negative Amount");
        if(command.getAmount()>this.balance) throw new NegativeInitialBalanceException("Balance insufficient Exception");
        AggregateLifecycle.apply(new AccountDebitedEvent(
                command.getId(),
                command.getCurrency(),
                command.getAmount()
        ));
    }
    @EventSourcingHandler
    public void on(AccountDebitedEvent event){
        this.balance = this.balance - event.getAmount() ;
    }

}
