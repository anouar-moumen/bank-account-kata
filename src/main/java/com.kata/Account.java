package com.kata;

import com.kata.exceptions.InsufficientBalanceException;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class Account {

    private float balance;

    private List<Operation> operations;

    public void deposit(float amountToDeposite, String description){
        balance += amountToDeposite;
        operations.add(new Operation(description, LocalDateTime.now(), amountToDeposite));
    }

    public float withdrawal(float amountToRetrieve, String description){
        if(amountToRetrieve > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        }
        balance -= amountToRetrieve;
        operations.add(new Operation(description, LocalDateTime.now(), amountToRetrieve));
        return balance;
    }

    public List<Operation> getAccountHistory(){
        return operations;
    }
}
