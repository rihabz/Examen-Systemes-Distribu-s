package com.example.customerservice1.query.service;

import com.example.customerservice1.events.CustomerCreatedEvent;
import com.example.customerservice1.query.entitie.Customer;
import com.example.customerservice1.query.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CustomerEventHandlerService {
    private CustomerRepository customerRepository;


    @EventHandler
    public void on(CustomerCreatedEvent event, EventMessage<CustomerCreatedEvent> eventEventMessage){
        log.info("Account Repository Received");
        Customer customer=new Customer();
        customer.setCustomerId(event.getId());
        customer.setNom(event.getNom());
        customer.setAdresse(event.getAdresse());
        customer.setAdresseEmail(customer.getAdresseEmail());
        customerRepository.save(customer);
    }
    //@QueryHandler
   // public List<Customer> on(GetAllAccounts getAllAccounts){
     //   return accountRepository.findAll() ;
    //}
}
