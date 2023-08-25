package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    private CustomerService sut;
    @Autowired
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        sut = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer martin = new Customer(1L, "Martin", "password123");
        Customer amal = new Customer(2L, "Amal", "password1233");
        customerRepository.saveAll(Arrays.asList(martin, amal));

        List<Customer> customers = sut.getCustomers();
        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        Customer martin = new Customer(1L, "Martin", "password123");
        customerRepository.save(martin);

        Customer customer = sut.getCustomer(1L);

        assertEquals(1L, customer.getId());
        assertEquals("Martin", customer.getName());
        assertEquals("password123", customer.getPassword());
    }
}