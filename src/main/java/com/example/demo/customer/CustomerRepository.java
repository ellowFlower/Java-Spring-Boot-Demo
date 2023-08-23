package com.example.demo.customer;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;

@Repository
public class CustomerRepository implements CustomerRepo {
    @Override
    public List<Customer> getCustomers() {
        return Collections.emptyList();
    }
}
