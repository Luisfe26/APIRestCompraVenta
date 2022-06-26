package com.compraventa.compraventa.repository;

import com.compraventa.compraventa.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
