package com.nguonchhay.demo.customers.CommandHandlers;

import com.nguonchhay.demo.Command;
import com.nguonchhay.demo.customers.AddressRepository;
import com.nguonchhay.demo.customers.Models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateAddressCommandHandler implements Command<Address, ResponseEntity> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public ResponseEntity execute(Address address) {
        return ResponseEntity.ok(addressRepository.save(address));
    }
}
