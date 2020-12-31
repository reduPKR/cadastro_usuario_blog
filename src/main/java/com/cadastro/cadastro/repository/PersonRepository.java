package com.cadastro.cadastro.repository;

import com.cadastro.cadastro.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
