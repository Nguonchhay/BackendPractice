package com.nguonchhay.demo.customers;

import com.nguonchhay.demo.customers.CommandHandlers.CreateCustomerCommandHandler;
import com.nguonchhay.demo.customers.Models.Customer;
import com.nguonchhay.demo.customers.QueryHandlers.GetAllCustomersQueryHandler;
import com.nguonchhay.demo.customers.QueryHandlers.GetCustomerQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private GetAllCustomersQueryHandler getAllCustomersQueryHandler;

    @Autowired
    private GetCustomerQueryHandler getCustomerQueryHandler;

    @Autowired
    private CreateCustomerCommandHandler createCustomerCommandHandler;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {
        return getAllCustomersQueryHandler.execute(null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable Integer id) {
        return getCustomerQueryHandler.execute(id);
    }

    @PostMapping
    public ResponseEntity createCustomer(@RequestBody Customer customer) {
        return createCustomerCommandHandler.execute(customer);
    }
}
