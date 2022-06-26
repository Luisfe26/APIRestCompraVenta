package com.compraventa.compraventa.service;

import com.compraventa.compraventa.DTO.ListPersonDTO;
import com.compraventa.compraventa.model.Person;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PersonSevice extends ICRUD <Person> {

    List<Person> findAllByName(String nombre);

    List<ListPersonDTO> listperson();

}
