package app.services.impl;

import app.domain.Account;
import app.domain.Customer;
import app.domain.Transaction;
import app.domain.Type;
import app.exceptions.AccountNotFoundException;
import app.exceptions.InsufficientFundsException;
import app.exceptions.ValidationException;
import app.repository.AcccountRepository;
import app.repository.CustomerRepository;
import app.repository.TransactionRepository;
import app.services.BankService;
import app.utility.Validation;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class BankServiceImpl implements BankService {

    private final AcccountRepository accountRepository = new AcccountRepository();
    private final TransactionRepository transactionRepository = new TransactionRepository();
    private final CustomerRepository customerRepository= new CustomerRepository();

    private final Validation<String> validateName = name -> {
        if(name == null || name.isBlank())
            throw new ValidationException("Name is required");
    };

    private final Validation<String> validateEmail = email -> {
        if(email == null || !email.contains("@"))
            throw new ValidationException("Email is required or invalid email id is passed");
    };

    private final Validation<String> validateAccountType = accountType -> {
        if(accountType == null || (!accountType.equalsIgnoreCase("SAVINGS") && !accountType.equalsIgnoreCase("CURRENT") && !accountType.equalsIgnoreCase("SALARY")))
            throw new ValidationException("INVALID ACCOUNT TYPE\n SELECT From CURRENT | SAVINGS | SALARY");
    };

    private final Validation<Double> validateAmountValue = amountValue -> {
        if(amountValue == null || amountValue<0)
            throw new ValidationException("Amount must be positive and it cannot be blank");
    };

    @Override
    public String openAccount(String name, String email, String accountType) {
        validateName.validate(name);
        validateEmail.validate(email);
        validateAccountType.validate(accountType);

        String customerId= UUID.randomUUID().toString();
        Customer customer = new Customer(customerId, name, email);
        customerRepository.save(customer);
        // Change Prefix Later
        //String accountNumber= UUID.randomUUID().toString();
//        int temp = accountRepository.findAll().size() +1;
//        String accountNumber =String.format("AC%6d",temp);
        String accountNumber = getAccountNumber();
        Account account = new Account(accountNumber, customerId, name, (double) 0, accountType);

        accountRepository.save(account);

        // Add initial transaction for account opening
        Transaction initialTransaction = new Transaction(accountNumber, 0.0, UUID.randomUUID().toString(), "Account Opened", LocalDateTime.now(), Type.DEPOSIT);
        transactionRepository.add(initialTransaction);

        return accountNumber;
    }



    private String getAccountNumber() {
        int size = accountRepository.findAll().size() +1;
        return String.format("AC%06d",size+1);
    }

    @Override
    public List<Account> listAccounts() {
        return accountRepository.findAll().stream()
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
    }

    @Override
    public void deposit(String accountNumber, Double amount, String note) {
        validateAmountValue.validate(amount);
        Account account = accountRepository.findByNumber(accountNumber)
                .orElseThrow(()-> new AccountNotFoundException("Account not found:" + accountNumber));
        account.setAccountBalance(Double.valueOf(account.getAccountBalance() + amount));
        Transaction transaction = new Transaction(account.getAccountNumber(),amount, UUID.randomUUID().toString(), note, LocalDateTime.now(), Type.DEPOSIT );
        transactionRepository.add(transaction);
    }

    @Override
    public void withdraw(String accountNumber, Double amount, String note) {
        validateAmountValue.validate(amount);
        Account account = accountRepository.findByNumber(accountNumber)
                .orElseThrow(()-> new AccountNotFoundException("Account not found:" + accountNumber));
        if (account.getAccountBalance().compareTo(amount)<0)
            throw new InsufficientFundsException("Insufficient Balance");
        account.setAccountBalance(Double.valueOf(account.getAccountBalance() - amount));
        Transaction transaction = new Transaction(account.getAccountNumber(),amount, UUID.randomUUID().toString(), note, LocalDateTime.now(), Type.WITHDRAW );
        transactionRepository.add(transaction);
    }

    @Override
    public void moneyTransfer(String accountNumber, String accountNumber2, Double amount, String moneyTransferred) {
        if (accountNumber.equals(accountNumber2))
            throw new ValidationException("You cannot Transfer money to your own account");
        validateAmountValue.validate(amount);
        //Fetching account details
        Account account = accountRepository.findByNumber(accountNumber)
                .orElseThrow(()-> new AccountNotFoundException("Account not found:" + accountNumber));
        Account account2 = accountRepository.findByNumber(accountNumber2)
                .orElseThrow(()-> new AccountNotFoundException("Account not found:" + accountNumber2));


        if (account.getAccountBalance().compareTo(amount)<0)
            throw new InsufficientFundsException("Insufficient Balance");
        account.setAccountBalance(Double.valueOf(account.getAccountBalance() - amount));
        account2.setAccountBalance(Double.valueOf(account2.getAccountBalance()+amount));
        Transaction transaction2 = new Transaction(account2.getAccountNumber(),amount, UUID.randomUUID().toString(), moneyTransferred, LocalDateTime.now(), Type.TRANSFER_IN);
        Transaction transaction = new Transaction(account.getAccountNumber(),amount, UUID.randomUUID().toString(), moneyTransferred, LocalDateTime.now(), Type.TRANSFER_OUT);

        transactionRepository.add(transaction);
        transactionRepository.add(transaction2);
    }

    @Override
    public List<Transaction> getAccountStatement(String accountNumber) {
        return transactionRepository.findByAccount(accountNumber).stream().sorted(Comparator.comparing(Transaction::getTimeStamp))
                .collect(Collectors.toList());
    }

    @Override
    public List<Account> searchAccountsByName(String query) {
        String q= (query== null)?"": query.toLowerCase();
//        List<Account> result = new ArrayList<>();
//
//        for(Customer c: customerRepository.findAll()){
//            if(c.getName().toLowerCase().contains(q))
//                result.addAll(accountRepository.findByCustomerId(c.getId()));
//        }
//        result.sort(Comparator.comparing(Account::getAccountNumber));

        return customerRepository.findAll().stream()
                .filter(c -> c.getName().toLowerCase().contains(q))
                .flatMap(c -> accountRepository.findByCustomerId(c.getId()).stream())
                .sorted(Comparator.comparing(Account::getAccountNumber))
                .collect(Collectors.toList());
        //return result;
    }
}
