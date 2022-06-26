package com.compraventa.compraventa.controller;


import com.compraventa.compraventa.model.Orders;
import com.compraventa.compraventa.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/orders" )
public class OrdersController {

    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService;
    }

    @GetMapping
    public List<Orders> findAll(){
        return ordersService.findAll();
    }

    @GetMapping("/{id}")
    public Orders findById(@PathVariable("id") Integer id){
        return ordersService.findById(id);
    }

    @GetMapping("/fecha/{fechaorden}")
    public List<Orders> buscarfecha(@PathVariable("fechaorden") String fechaorden){
        return ordersService.buscarfecha(fechaorden);
    }

    @PostMapping
    public Orders save(@RequestBody Orders orders){
        return ordersService.save(orders);
    }

    @PutMapping("/{id}")
    public Orders update(@RequestBody Orders orders, @PathVariable("id") Integer id){
        return ordersService.update(orders, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
        return ordersService.delete(id);
    }
}
