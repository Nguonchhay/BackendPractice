package com.nguonchhay.demo.CatFact.Controllers;

import com.nguonchhay.demo.CatFact.Models.CatFactDTO;
import com.nguonchhay.demo.CatFact.Services.CatFactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/catfacts")
public class CatFactController {

    @Autowired
    private CatFactService catFactService;

    @GetMapping
    public ResponseEntity<CatFactDTO> getCatFact() {
        return catFactService.getCatFact();
    }
}
