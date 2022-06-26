package com.compraventa.compraventa.service;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ICRUD <E>{

    List<E> findAll();

    E findById(Integer id) throws ModeloNotFoundException;

    E save(E e);

    E update(E e, Integer id) throws ModeloNotFoundException;

    ResponseEntity<Object> delete(Integer id);

}
