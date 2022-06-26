package com.compraventa.compraventa.repository;

import com.compraventa.compraventa.model.Moneda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MonedaRepository extends JpaRepository<Moneda,Integer> {
}
