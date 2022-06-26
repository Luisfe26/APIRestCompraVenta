package com.compraventa.compraventa.controller;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.TipoOrder;
import com.compraventa.compraventa.service.TipoOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tipoordenes" )
public class TipoOredersController {

    private final TipoOrdersService tipoOrdersService;

    @Autowired
    public TipoOredersController(TipoOrdersService tipoOrdersService) {
        this.tipoOrdersService = tipoOrdersService;
    }

    @GetMapping
    public List<TipoOrder> findAll(){
        return tipoOrdersService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoOrder> findById(@PathVariable("id") Integer id){
        TipoOrder obj = tipoOrdersService.findById(id);
        if(obj.getIdtipoorden() == null){
            throw new ModeloNotFoundException("ID NO ENCONTRADO" + id);
        }else {
            return new ResponseEntity<TipoOrder>(obj, HttpStatus.OK);
        }
    }

    @PostMapping
    public TipoOrder save(@RequestBody TipoOrder tipoOrder){
        return tipoOrdersService.save(tipoOrder);
    }

    @PutMapping("/{id}")
    public TipoOrder update(@RequestBody TipoOrder tipoOrder, @PathVariable("id") Integer id){
        return tipoOrdersService.update(tipoOrder, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        return tipoOrdersService.delete(id);
    }
}
