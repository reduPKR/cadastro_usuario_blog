package com.cadastro.cadastro.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PersonDTO {
    private long id;

    @NotEmpty
    @Size(min=3, max=100)
    private String name;

    @NotEmpty
    @Size(min=3, max=100)
    @Email
    private String email;

    @NotEmpty
    @CPF
    private String cpf;

    private LocalDate birthdate;

    public PersonDTO() {
    }

    public PersonDTO(String name, String email, String cpf, LocalDate birthdate) {
        this.name = name;
        this.email = email;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
