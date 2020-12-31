package com.cadastro.cadastro.service;

import com.cadastro.cadastro.dto.PersonDTO;
import com.cadastro.cadastro.entity.Person;
import com.cadastro.cadastro.mapper.PersonMapper;
import com.cadastro.cadastro.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private final PersonRepository repository;
    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }


    public List<PersonDTO> getAll() {
        List<Person> list = repository.findAll();
        return list.stream()
                .map(personMapper::toDTO)
                .collect(Collectors.toList());
    }
}
