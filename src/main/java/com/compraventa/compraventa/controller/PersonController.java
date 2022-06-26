package com.compraventa.compraventa.controller;

import com.compraventa.compraventa.DTO.ListPersonDTO;
import com.compraventa.compraventa.model.Person;
import com.compraventa.compraventa.service.PersonSevice;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/person" )
public class PersonController {

    private final PersonSevice personSevice;

    @Autowired
    public PersonController(PersonSevice personSevice) {
        this.personSevice = personSevice;
    }

    @ApiOperation(value = "Obtener todos los persona",
            notes = "No necesita parametros de entrada",
            responseContainer = "Persona")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
           response = Person.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron personas"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping
    public List<Person> findAll(){
        return personSevice.findAll();
    }


    @ApiOperation(value = "Obtener una persona por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Person.class,
            responseContainer = "Persona")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro la persona en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public Person findById(@PathVariable("id") Integer id){
        return personSevice.findById(id);
    }


    @ApiOperation(value = "Obtener personas por nombre",
            notes = "Se necesita el parametro nombre como entrada",
            responseContainer = "Persona")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Person.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron personas en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/nombre/{nombre}")
    public List<Person> findAllByName(@PathVariable("nombre") String nombre){
        return personSevice.findAllByName(nombre);
    }


    @ApiOperation(value = "Crear un registro",
            notes = "",
            response = Person.class,
            responseContainer = "Persona")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se pudo crear el registro"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Person save(@RequestBody Person person){
        return personSevice.save(person);
    }

    @ApiOperation(value = "Actualizar una persona por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Person.class,
            responseContainer = "Persona")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro la persona en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/{id}")
    public Person update(@RequestBody Person person, @PathVariable("id") Integer id){
        return personSevice.update(person, id);
    }

    @ApiOperation(value = "Eliminar una persona por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Person.class,
            responseContainer = "Persona")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro la persona en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        return personSevice.delete(id);
    }


    @ApiOperation(value = "Obtener lista de persona resumida",
            notes = "Se necesita el parametro nombre como entrada",
            responseContainer = "Persona")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Person.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron personas en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping(value = "/personas")
    public ResponseEntity<List<ListPersonDTO>> listperson(){
        List<ListPersonDTO> personaOrdenDTOS = new ArrayList<>();
        personaOrdenDTOS = personSevice.listperson();
        return new ResponseEntity<List<ListPersonDTO>>(personaOrdenDTOS, HttpStatus.OK);
    }
}
