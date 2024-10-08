package com.nguonchhay.demo.customers.QueryHandlers;

import com.nguonchhay.demo.Query;
import com.nguonchhay.demo.customers.CustomerRepository;
import com.nguonchhay.demo.customers.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetCustomerQueryHandler implements Query<Integer, Customer> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<Customer> execute(Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isEmpty()) {
            throw new RuntimeException("Customer not found");
        }

        return ResponseEntity.ok(customerOptional.get());
    }
}
