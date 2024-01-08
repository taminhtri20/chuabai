package org.example.customer_management.service;

import org.example.customer_management.model.Customer;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    Optional<Customer> findById(int id);
    void remove(int id);
    void edit(int id, Customer customer);
    List<Customer> findByName(String name);
}
