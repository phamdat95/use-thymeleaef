package com.codegym.service;

import com.codegym.model.Customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImp implements CustomerService {
    private static Map<Integer,Customer> map = new HashMap<>();
    static {
        map.put(1,new Customer(1,"Pham Dat","phamdatvmu95@gmail.com","Hai Phong"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public void save(Customer customer) {
        map.put(customer.getId(),customer);
    }

    @Override
    public void edit(Customer customer, int id) {
        map.put(id,customer);
    }

    @Override
    public Customer findById(int id) {
        return map.get(id);
    }

    @Override
    public void delete(int id) {
        map.remove(id);
    }
}
