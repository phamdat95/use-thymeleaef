package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    void save(Customer customer);
    void edit(Customer customer, int id);
    Customer findById(int id);
    void delete(int id);
}
