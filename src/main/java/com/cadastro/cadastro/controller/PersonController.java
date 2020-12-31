package com.cadastro.cadastro.controller;

import com.cadastro.cadastro.dto.PersonDTO;
import com.cadastro.cadastro.response.MessagePerson;
import com.cadastro.cadastro.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessagePerson create(@Valid @RequestBody PersonDTO personDTO){
        return service.create(personDTO);
    }
}
