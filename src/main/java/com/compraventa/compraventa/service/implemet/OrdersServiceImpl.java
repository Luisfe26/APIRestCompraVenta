package com.compraventa.compraventa.service.implemet;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.Country;
import com.compraventa.compraventa.model.Orders;
import com.compraventa.compraventa.repository.OrdersRepository;
import com.compraventa.compraventa.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersServiceImpl implements OrdersService {

    private final OrdersRepository ordersRepository;

    @Autowired
    public OrdersServiceImpl(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Orders save(Orders orders) {
        return ordersRepository.save(orders);
    }

    @Override
    public Orders update(Orders orders, Integer id){
        Optional<Orders> findorders = ordersRepository.findById(id);
        if (findorders.isPresent()) {
            orders.setIdorden(id);
            return save(orders);
        } else {
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Orders> orders = ordersRepository.findById(id);
        if(orders.isPresent()){
            ordersRepository.delete(orders.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public Orders findById(Integer id) {
        Optional<Orders> orders = ordersRepository.findById(id);
        if(orders.isPresent()){
            return orders.get();
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public List<Orders> buscarfecha(String fechaorden) {
        return ordersRepository.buscarfecha(fechaorden);
    }
}
