package com.cadastro.cadastro.service;

import com.cadastro.cadastro.dto.PersonDTO;
import com.cadastro.cadastro.entity.Person;
import com.cadastro.cadastro.mapper.PersonMapper;
import com.cadastro.cadastro.repository.PersonRepository;
import com.cadastro.cadastro.response.MessagePerson;
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

    public MessagePerson create(PersonDTO personDTO) {
        Person person = personMapper.toModel(personDTO);
        Person new_person = repository.save(person);
        return messageReturn("Novo usuário cadastrado id: "+new_person.getId()+" nome: "+new_person.getName());
    }

    private MessagePerson messageReturn(String message) {
        return MessagePerson.builder()
                .message(message)
                .build();
    }
}
