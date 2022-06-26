package com.compraventa.compraventa.service;

import com.compraventa.compraventa.model.Orders;
import org.springframework.http.ResponseEntity;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public interface OrdersService extends ICRUD<Orders>{

    List<Orders> buscarfecha(String fechaorden);

}
