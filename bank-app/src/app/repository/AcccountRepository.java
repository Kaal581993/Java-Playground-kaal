package app.repository;

import app.domain.Account;
import app.domain.Customer;

import java.util.*;

public class AcccountRepository {
    private final Map<String, Account> accountsByNumber=new HashMap<>();

    public void save(Account account){
        accountsByNumber.put(account.getAccountNumber(), account);
    }

    public List<Account> findAll() {
        return new ArrayList<>(accountsByNumber.values());

    }

    public Optional<Account> findByNumber(String accountNumber) {
        return Optional.ofNullable(accountsByNumber.get(accountNumber));
    }

    public List<Account> findByCustomerId(String customerId) {
        //String q= (query== null)?"": query.toLowerCase();
        List<Account> result = new ArrayList<>();

        for(Account a: accountsByNumber.values()){
            if(a.getCustomerId().toLowerCase().equals(customerId))
                result.add(a);
        }

        return result;
    }
}
