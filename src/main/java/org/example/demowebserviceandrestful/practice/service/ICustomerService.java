package org.example.demowebserviceandrestful.practice.service;

import org.example.demowebserviceandrestful.practice.model.Customer;

import java.util.Optional;

public interface ICustomerService {
    Iterable<Customer> findAll();
    Optional<Customer> findById(Long id);
    Customer save(Customer customer);
    void remove(Long id);
}
