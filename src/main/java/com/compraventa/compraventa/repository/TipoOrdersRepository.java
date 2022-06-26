package com.compraventa.compraventa.repository;

import com.compraventa.compraventa.model.TipoOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoOrdersRepository extends JpaRepository<TipoOrder, Integer> {
}
