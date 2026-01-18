package app;

import app.domain.Account;
import app.domain.Type;
import app.exceptions.ValidationException;
import app.services.BankService;
import app.services.impl.BankServiceImpl;
import app.utility.Validation;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final Validation<Double> validateAmountValue = amountValue -> {
        if(amountValue == null || amountValue<0)
            throw new ValidationException("Amount must be positive and it cannot be blank");
    };
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
        BankService bankService = new BankServiceImpl();

        boolean running =true;

        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("\n\t\tHello and welcome to Kaal's Console Banking App!\n");

            //TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut actionId="ToggleLineBreakpoint"/>.
        while(running) {

            System.out.println("""
                    1) Open Account
                    2) Deposit Money
                    3) WithDraw Money
                    4) Transfer Money
                    5) Account Statement
                    6) List Accounts
                    7) Search Accounts by Customer Name
                    0) Exit
                    """);
            System.out.println("Choose your options for banking");
            String choice = scanner.nextLine().trim();
            System.out.println("You choosed option:" + choice);
            switch (choice){
                case "1"->{
                        System.out.println("Enter the following Details for Opening an account");
                        openAccount(scanner ,bankService);
                }
                case "2"->{
                        System.out.println("Enter the amount Money you want to deposit");
                        deposit(scanner, bankService);
                }
                case "3"->{
                        System.out.println("Enter the amount to withdraw the money");
                        withdraw(scanner, bankService);
                }
                case "4"->{
                        System.out.println("Enter the Account details for transferring the Money");
                        moneyTransfer(scanner, bankService);
                }
                case "5"->{
                        System.out.println("Enter the Account details for generating the account statement");
                        getStatement(scanner, bankService);
                }
                case "6"->{
                        System.out.println("Following are the details of accounts in the system");
                        getAccountDetails(scanner ,bankService);
                }
                case "7"->{
                        System.out.println("Enter the Customer Name");
                        getAccountDetailsByName(scanner, bankService);
                }
                case "0"->{
                        System.out.println("Exiting the Application");
                        running=false;
                }

            }
            
            

        }
    }


    private static void openAccount(Scanner scanner, BankService bankService) {
        System.out.println("Enter Customer Name");
        String name = scanner.nextLine().trim();

        System.out.println("Enter Customer email");
        String email = scanner.nextLine().trim();
        System.out.println("Select Account Type(SAVINGS, CURRENT, SALARY)");
        String type =scanner.nextLine().trim();
        System.out.println("Initial Deposit (Optional, blank for 0):");
        String amount = scanner.nextLine().trim();
        validateAmountValue.validate(Double.valueOf(amount));
        if(amount.isBlank())
            amount="0";
        Double initialAmount= Double.valueOf(amount);

        String accountNumber=bankService.openAccount(name, email, type);
        if(initialAmount>0)
            bankService.deposit(accountNumber, initialAmount, "Initial Deposit Amount:"+initialAmount);
        System.out.println("Acccount Opened:" + accountNumber);


    }

    private static void deposit(Scanner scanner, BankService bankService) {
        System.out.println("Available accounts:");
        bankService.listAccounts().forEach(account ->
                System.out.println(account.getAccountNumber()+" | "
                        +account.getCustomerName()+" | "
                        +account.getAccountType()+" | "+account.getAccountBalance()));
        System.out.println("Please Enter your Account Number:");
        String accountNumber=scanner.nextLine().trim();
        System.out.println("Please enter the Amount you want to Deposit:");
        Double amount= Double.valueOf(scanner.nextLine().trim());

        bankService.deposit(accountNumber, amount, "Deposit");
        System.out.println("Amount Deposited:" + amount);

        System.out.println("Updated account details:");
        Account updatedAccount = bankService.listAccounts().stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
        if (updatedAccount != null) {
            System.out.println(updatedAccount.getAccountNumber() + " | " + updatedAccount.getCustomerName() + " | " + updatedAccount.getAccountType() + " | " + updatedAccount.getAccountBalance());
        }
    }

    private static void withdraw(Scanner scanner, BankService bankService) {
        System.out.println("Please Enter your Account Number:");
        String accountNumber=scanner.nextLine().trim();
        System.out.println("Please enter the Amount you want to Withdraw:");
        Double amount= Double.valueOf(scanner.nextLine().trim());

        bankService.withdraw(accountNumber, amount, "Withdraw Money");
        System.out.println("Amount Withdrawn:" + amount);
        System.out.println("Updated account details:");
        Account updatedAccount = bankService.listAccounts().stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
        if (updatedAccount != null) {
            System.out.println(updatedAccount.getAccountNumber() + " | " + updatedAccount.getCustomerName() + " | " + updatedAccount.getAccountType() + " | " + updatedAccount.getAccountBalance());
        }
    }

    private static void moneyTransfer(Scanner scanner, BankService bankService) {
        System.out.println("Available accounts:");
        bankService.listAccounts().forEach(account ->
                System.out.println(account.getAccountNumber()+" | "
                        +account.getCustomerName()+" | "
                        +account.getAccountType()+" | "+account.getAccountBalance()));
        System.out.println("Please Enter your Account Number from which you want to transfer money:");
        String accountNumber=scanner.nextLine().trim();
        System.out.println("Please Enter your Account Number to which you want to transfer money:");
        String accountNumber2=scanner.nextLine().trim();
        System.out.println("Please enter the Amount you want to transfer money:");
        Double amount= Double.valueOf(scanner.nextLine().trim());

        bankService.moneyTransfer(accountNumber, accountNumber2, amount, "Money Transferred");
        System.out.println("Amount Transferrd:" + amount);

        System.out.println("Updated account1 details:");
        Account updatedAccount = bankService.listAccounts().stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null);
        if (updatedAccount != null) {
            System.out.println(updatedAccount.getAccountNumber() + " | " + updatedAccount.getCustomerName() + " | " + updatedAccount.getAccountType() + " | " + updatedAccount.getAccountBalance());
        }
    }

    private static void getStatement(Scanner scanner, BankService bankService) {
        System.out.println("Please Enter your Account Number for which you want a statement to be retreived:");
        String accountNumber=scanner.nextLine().trim();
        bankService.getAccountStatement(accountNumber).forEach(t ->{
            System.out.println(t.getId()+"|"+t.getTimeStamp()+" | "+t.getType()+" | "+t.getAmount()+" | "+t.getNote());
        });
    }

    private static void getAccountDetails(Scanner scanner, BankService bankService) {
        bankService.listAccounts().forEach(account ->
                System.out.println(account.getAccountNumber()+" | "+account.getCustomerName()+" | "
                        +account.getAccountType()+" | "+account.getAccountBalance()));
    }

    private static void getAccountDetailsByName(Scanner scanner, BankService bankService) {
        System.out.println("Customer Name contains");
        String query = scanner.nextLine().trim();
        bankService.searchAccountsByName(query).forEach(account -> {
            System.out.println(account.getAccountNumber()+" | "
            +account.getCustomerName()+" | "
            +account.getAccountBalance()+" | "
            +account.getAccountType());
        });
    }




}