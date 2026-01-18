package app.repository;

import app.domain.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository {
    private final Map<String, Customer> customersByID = new HashMap<>();

    public void save(Customer customer) {
        customersByID.put(customer.getId(), customer);
    }

    public List<Customer> findAll() {
        return new ArrayList<>(customersByID.values());
    }
}
