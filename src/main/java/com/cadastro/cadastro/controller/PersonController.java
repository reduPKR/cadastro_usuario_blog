package com.cadastro.cadastro.controller;

import com.cadastro.cadastro.dto.PersonDTO;
import com.cadastro.cadastro.service.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    private final PersonService service;

    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<PersonDTO> getAll(){
        return service.getAll();
    }
}
