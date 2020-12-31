package com.cadastro.cadastro.service;

import com.cadastro.cadastro.dto.PersonDTO;
import com.cadastro.cadastro.entity.Person;
import com.cadastro.cadastro.mapper.PersonMapper;
import com.cadastro.cadastro.repository.PersonRepository;
import com.cadastro.cadastro.response.MessagePerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        try{
            return trySavePerson(person);
        }catch (Exception ex){
            return messageException(ex.getMessage());
        }

    }

    private MessagePerson trySavePerson(Person person){
        Person new_person = repository.save(person);
        return messageReturn("Novo usuário cadastrado id: "+new_person.getId()+" nome: "+new_person.getName(),
                HttpStatus.CREATED);
    }

    private MessagePerson messageException(String message) {
        if(message.contains("email_UNIQUE")){
            return messageReturn("Email já foi cadastrado",HttpStatus.BAD_REQUEST);
        }
        if(message.contains("cpf_UNIQUE")){
            return messageReturn("CPF já foi cadastrado",HttpStatus.BAD_REQUEST);
        }
        return messageReturn(message,HttpStatus.BAD_REQUEST);
    }

    private MessagePerson messageReturn(String message, HttpStatus status) {
        return new MessagePerson(message, status);
    }
}
