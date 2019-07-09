package com.kata;

import com.kata.exceptions.InsufficientBalanceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnit4.class)
public class AccountTest {

    @Test
    public void should_be_able_to_make_a_deposit(){
        //GIVEN
        Account account = Account.builder().balance(0).operations(new ArrayList<Operation>()).build();

        //WHEN
        account.deposit(10, "first deposit");

        //THEN
        assertThat(account.getBalance()).isEqualTo(10);
        assertThat(account.getOperations().size()).isEqualTo(1);
    }

    @Test
    public void should_be_able_to_make_a_withdrawal(){
        //GIVEN
        Account account = Account.builder().balance(30).operations(new ArrayList<Operation>()).build();

        //WHEN
        account.withdrawal(10, "Withdrawal");

        //THEN
        assertThat(account.getBalance()).isEqualTo(20);
        assertThat(account.getOperations().size()).isEqualTo(1);
    }

    @Test(expected = InsufficientBalanceException.class)
    public void should_not_authorize_withdrawal_when_no_sufficient_balance(){
        //GIVEN
        Account account = Account.builder().balance(0).operations(new ArrayList<Operation>()).build();

        //WHEN
        account.withdrawal(10, "Withdrawal");

        //THEN
        //THROW InsufficientBalanceException
    }

    @Test
    public void should_be_able_to_get_account_operations_history(){
        //GIVEN
        Account account = Account.builder().balance(0).operations(new ArrayList<Operation>()).build();

        //WHEN
        account.deposit(10, "Deposit 1");
        account.deposit(20, "Deposit 2");
        account.withdrawal(10, "Withdrawal");

        List<Operation> operationsHistory = account.getAccountHistory();


        //THEN
        assertThat(account.getBalance()).isEqualTo(20);
        assertThat(operationsHistory.size()).isEqualTo(3);
    }


}
