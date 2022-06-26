package com.compraventa.compraventa.repository;

import com.compraventa.compraventa.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findAllByNombres(String nombre);

    Person findOneByEmail(String email);

    @Query(value = "select * from persona", nativeQuery = true)
    List<Object[]> listperson();

}
