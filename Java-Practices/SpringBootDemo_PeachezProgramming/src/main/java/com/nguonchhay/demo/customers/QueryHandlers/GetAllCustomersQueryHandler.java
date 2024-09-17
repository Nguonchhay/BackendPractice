package com.nguonchhay.demo.customers.QueryHandlers;

import com.nguonchhay.demo.Query;
import com.nguonchhay.demo.customers.CustomerRepository;
import com.nguonchhay.demo.customers.Models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllCustomersQueryHandler implements Query<Void, List<Customer>> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public ResponseEntity<List<Customer>> execute(Void input) {
        return ResponseEntity.ok(customerRepository.findAll());
    }
}
