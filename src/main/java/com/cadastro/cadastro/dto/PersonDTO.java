package com.cadastro.cadastro.dto;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class PersonDTO {
    private long id;

    @NotEmpty
    @Size(min=3, max=100, message = "Nome tem que ter entre 3 e 100 caracteres")
    private String name;

    @NotEmpty(message = "Email não pode estar vazio")
    @Size(min=5, max=100, message = "Email tem que ter entre 5 e 100 caracteres")
    @Email(message = "Email inválido")
    private String email;

    @NotEmpty(message = "CPF não pode estar vazio")
    @CPF(message = "* CPF inválido")
    private String cpf;

    @NotNull(message = "Data de nascimento não pode estar vazia")
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
