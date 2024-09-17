package com.nguonchhay.demo.customers;

import com.nguonchhay.demo.customers.CommandHandlers.CreateAddressCommandHandler;
import com.nguonchhay.demo.customers.Models.Address;
import com.nguonchhay.demo.customers.QueryHandlers.GetAllAddressesQueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/addresses")
public class AddressController {

    @Autowired
    private GetAllAddressesQueryHandler getAllAddressesQueryHandler;

    @Autowired
    private CreateAddressCommandHandler createAddressCommandHandler;

    @GetMapping
    public ResponseEntity<List<Address>> getAddresses() {
        return getAllAddressesQueryHandler.execute(null);
    }

    @PostMapping
    public ResponseEntity createAddress(@RequestBody Address address) {
        return createAddressCommandHandler.execute(address);
    }
}
