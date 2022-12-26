package com.example.customerservice.query.entitie;

import com.example.customerservice.commonapi.enums.AccountStatus;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.List;

@Data
@Entity

@AllArgsConstructor
public class Account {

    @Id
    private String id;
    private Instant createdAt;
    private  double balance ;
    private AccountStatus status ;
    private String currency ;

    @OneToMany(mappedBy = "account")
    private List<AccountTransaction> transactions;
    public Account() {
    }
}
