package com.nguonchhay.demo.CatFact.Services;

import com.nguonchhay.demo.CatFact.Models.CatFact;
import com.nguonchhay.demo.CatFact.Models.CatFactDTO;
import com.nguonchhay.demo.Exceptions.ExternalCatFactException;
import com.nguonchhay.demo.Exceptions.SimpleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CatFactService {

    private final RestTemplate restTemplate;

    public CatFactService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity<CatFactDTO> getCatFact() {
        try {
            CatFact catFact = restTemplate.getForObject("https://catfact.ninja/fact", CatFact.class);
            CatFactDTO catFactDTO = new CatFactDTO((catFact.getFact()));
            return ResponseEntity.ok(catFactDTO);
        } catch (Exception exception) {
            throw new ExternalCatFactException(
                    HttpStatus.SERVICE_UNAVAILABLE,
                    new SimpleResponse("The CatFact API is down")
            );
        }

    }
}
