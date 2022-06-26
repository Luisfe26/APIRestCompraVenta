package com.compraventa.compraventa.repository;

import com.compraventa.compraventa.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    @Query("select o from Orders o where o.fechaOrden = :fechaOrden order by o.fechaOrden")
    List<Orders> buscarfecha(@Param("fechaOrden") String fechaOrden);

}
