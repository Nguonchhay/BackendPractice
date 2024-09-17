package com.nguonchhay.demo.customers.CommandHandlers;

import com.nguonchhay.demo.Command;
import com.nguonchhay.demo.customers.CustomerRepository;
import com.nguonchhay.demo.customers.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerCommandHandler implements Command<Customer, ResponseEntity> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity execute(Customer customer) {
        return ResponseEntity.ok(customerRepository.save(customer));
    }
}
