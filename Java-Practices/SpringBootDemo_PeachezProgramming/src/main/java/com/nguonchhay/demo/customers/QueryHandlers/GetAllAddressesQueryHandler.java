package com.nguonchhay.demo.customers.QueryHandlers;

import com.nguonchhay.demo.Query;
import com.nguonchhay.demo.customers.AddressRepository;
import com.nguonchhay.demo.customers.Models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllAddressesQueryHandler implements Query<Void, List<Address>> {

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public ResponseEntity<List<Address>> execute(Void input) {
        return ResponseEntity.ok(
            addressRepository.findAll()
        );
    }
}
