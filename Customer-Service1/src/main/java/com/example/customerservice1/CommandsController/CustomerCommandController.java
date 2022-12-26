package com.example.customerservice1.CommandsController;

import com.example.customerservice1.commonapi.commands.CreateCustomerCommand;
import com.example.customerservice1.commonapi.dtos.CreateCustomerRequestDTO;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/commands/customer")
public class CustomerCommandController {

    private CommandGateway commandGateway ;
    private EventStore eventStore ;
    public CustomerCommandController(CommandGateway commandGateway, EventStore eventStore) {
        this.commandGateway = commandGateway;
        this.eventStore = eventStore;
    }
    @PostMapping("/create")
    public CompletableFuture<String> createNewCustomer(@RequestBody CreateCustomerRequestDTO request){
        return   commandGateway.send(new CreateCustomerCommand(
                UUID.randomUUID().toString(),
                request.getNom(),
                request.getAdresse(),
                request.getAdresseEmail()
        ));
    }

}
