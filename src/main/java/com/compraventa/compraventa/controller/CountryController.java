package com.compraventa.compraventa.controller;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.Country;
import com.compraventa.compraventa.model.Person;
import com.compraventa.compraventa.service.CountryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/country" )
public class CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }


    @ApiOperation(value = "Obtener todos los paises",
            notes = "No necesita parametros de entrada",
            responseContainer = "Country")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Person.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron paises"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping
    public List<Country> findAll(){
        return countryService.findAll();
    }

    @ApiOperation(value = "Obtener un país por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Person.class,
            responseContainer = "Country")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro el país en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public ResponseEntity<Country> findById(@PathVariable("id") Integer id){
        Country obj = countryService.findById(id);
        if(obj.getIdpais() == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }else {
            return new ResponseEntity<Country>(obj, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Crear un registro",
            notes = "",
            response = Country.class,
            responseContainer = "Country")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se pudo crear el registro"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Country save(@RequestBody Country country){
        return countryService.save(country);
    }

    @ApiOperation(value = "Actualizar un país por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Country.class,
            responseContainer = "Country")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro el país en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/{id}")
    public Country update(@RequestBody Country country, @PathVariable("id") Integer id){
        return countryService.update(country, id);
    }

    @ApiOperation(value = "Eliminar un país por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Country.class,
            responseContainer = "Country")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro el país en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        return countryService.delete(id);
    }

}
