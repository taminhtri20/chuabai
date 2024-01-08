package org.example.customer_management.service;

import org.example.customer_management.model.Customer;
import org.example.customer_management.respository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class HibernateCustomerService implements ICustomerService{
    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public void save(Customer customer) {
        customerRepository.save(new Customer(customer.getName(), customer.getEmail(), customer.getAddress()));
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public void remove(int id) {
        customerRepository.deleteById(id);
    }
    @Override
    public void edit(int id, Customer customer) {
        customerRepository.save(new Customer(id, customer.getName(), customer.getEmail(), customer.getAddress()));
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = customerRepository.findByNameContainsIgnoreCase(name);
        return customerList;
    }
}
