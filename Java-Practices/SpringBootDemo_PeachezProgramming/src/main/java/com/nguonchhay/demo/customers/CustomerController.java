package com.nguonchhay.demo.customers;

import com.nguonchhay.demo.customers.Models.Customer;
import com.nguonchhay.demo.customers.QueryHandlers.GetCustomerQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private GetCustomerQueryHandler getCustomerQueryHandler;

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        return getCustomerQueryHandler.execute(id);
    }
}
