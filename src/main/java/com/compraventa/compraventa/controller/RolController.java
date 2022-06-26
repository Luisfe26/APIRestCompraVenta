package com.compraventa.compraventa.controller;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.Rol;
import com.compraventa.compraventa.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rol" )
public class RolController {

    private final RolService rolService;

    @Autowired
    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> findAll(){
        return rolService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rol> findById(@PathVariable("id") Integer id){
        Rol obj = rolService.findById(id);
        if(obj.getIdrol() == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }else {
            return new ResponseEntity<Rol>(obj, HttpStatus.OK);
        }
    }

    @PostMapping
    public Rol save(@RequestBody Rol rol){
        return rolService.save(rol);
    }

    @PutMapping("/{id}")
    public Rol update(@RequestBody Rol rol, @PathVariable("id") Integer id){
        return rolService.update(rol, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        return rolService.delete(id);
    }
}
