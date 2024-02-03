package com.example.demo.repository;

import com.example.demo.entity.Customer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@ComponentScan
public class CustomerRepository {

    private final List<Customer> list = new ArrayList<Customer>();

    public List<Customer> getAllCustomers() {
        return list;
    }

    public Customer findById(int id) {
        for(Customer c: list) {
            if(c.getId() == id) {
                return list.get(id);
            }
        }
        return null;
    }

    public Customer save(Customer customer) {
        Customer c = new Customer();
        c.setId(customer.getId());
        c.setName(customer.getName());
        c.setAge(customer.getAge());
        c.setAddress(c.getAddress());
        list.add(c);
        return c;
    }
}
