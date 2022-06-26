package com.compraventa.compraventa.controller;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.Moneda;
import com.compraventa.compraventa.model.Person;
import com.compraventa.compraventa.service.MonedaService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/moneda" )
public class MonedaController {

    private final MonedaService monedaService;

    @Autowired
    public MonedaController(MonedaService monedaService) {
        this.monedaService = monedaService;
    }

    @ApiOperation(value = "Obtener todos las monedas",
            notes = "No necesita parametros de entrada",
            responseContainer = "Moneda")
    @ApiResponse(code = 200, message = "ApiResponseMessages.ITEM_FETCHED",
            response = Person.class, responseContainer = "List")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraron monedas"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping
    public List<Moneda> findAll(){
        return monedaService.findAll();
    }

    @ApiOperation(value = "Obtener una moneda por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Moneda.class,
            responseContainer = "Country")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro la moneda en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @GetMapping("/{id}")
    public ResponseEntity<Moneda> findById(@PathVariable("id") Integer id){
        Moneda obj = monedaService.findById(id);
        if(obj.getIdmoneda() == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }else {
            return new ResponseEntity<Moneda>(obj, HttpStatus.OK);
        }
    }

    @ApiOperation(value = "Crear un registro",
            notes = "",
            response = Moneda.class,
            responseContainer = "Moneda")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se pudo crear el registro"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PostMapping
    public Moneda save(@RequestBody Moneda moneda){
        return monedaService.save(moneda);
    }

    @ApiOperation(value = "Actualizar una moneda por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Moneda.class,
            responseContainer = "Moneda")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro la moneda en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @PutMapping("/{id}")
    public Moneda update(@RequestBody Moneda moneda, @PathVariable("id") Integer id){
        return monedaService.update(moneda, id);
    }

    @ApiOperation(value = "Eliminar una moneda por su id",
            notes = "Se necesita el parametro id como entrada",
            response = Moneda.class,
            responseContainer = "Moneda")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Bad request o datos no enviados correctamente"),
            @ApiResponse(code = 404, message = "Not found, no encontrado"),
            @ApiResponse(code = 405, message = "No se encontraro la moneda en la BD"),
            @ApiResponse(code = 200, message = "Peticón OK")})
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        return monedaService.delete(id);
    }

}
