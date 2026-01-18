package app.domain;

import java.util.Scanner;

public class Account {
    private String AccountNumber;
    private String CustomerId;
    private String CustomerName;
    private Double AccountBalance;
    private String AccountType;

    public Account(String accountNumber, String customerId, Double accountBalance, String accountType) {
        AccountNumber = accountNumber;
        CustomerId = customerId;
        AccountBalance = accountBalance;
        AccountType = accountType;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public Double getAccountBalance() {
        return AccountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        AccountBalance = accountBalance;
    }



    public String getAccountType() {
        return AccountType;
    }

    public void setAccountType(String accountType) {
        AccountType = accountType;
    }

    @Override
    public String toString() {
        return "Account{" +
                "AccountNumber='" + AccountNumber + '\'' +
                ", CustomerId='" + CustomerId + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", AccountBalance=" + AccountBalance +
                ", AccountType='" + AccountType + '\'' +
                '}';
    }

    public Account(String accountNumber, String customerId, String customerName, Double accountBalance, String accountType) {
        AccountNumber = accountNumber;
        CustomerId = customerId;
        CustomerName = customerName;
        AccountBalance = accountBalance;
        AccountType = accountType;
    }


}
