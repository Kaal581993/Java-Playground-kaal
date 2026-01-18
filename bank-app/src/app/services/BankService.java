package app.services;

import app.domain.Account;
import app.domain.Transaction;

import java.util.List;
import java.util.Map;

public interface BankService {
    String openAccount(String name, String email, String accountType);
    List<Account> listAccounts ();

    void deposit(String accountNumber, Double amount, String deposit);

    void withdraw(String accountNumber, Double amount, String withdrawMoney);

    void moneyTransfer(String accountNumber, String accountNumber2, Double amount, String moneyTransferred);


    List<Transaction> getAccountStatement(String accountNumber);

    List<Account> searchAccountsByName(String query);
}
