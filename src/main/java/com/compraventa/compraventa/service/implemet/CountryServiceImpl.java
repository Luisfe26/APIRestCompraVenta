package com.compraventa.compraventa.service.implemet;


import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.Country;
import com.compraventa.compraventa.repository.CountryRepository;
import com.compraventa.compraventa.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> findAll() {
        return countryRepository.findAll();
    }

    @Override
    public Country findById(Integer id) {
        Optional<Country> country = countryRepository.findById(id);
        if(country.isPresent()){
            return country.get();
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country update(Country country, Integer id) {
        Optional<Country> findcountry = countryRepository.findById(id);
        if (findcountry.isPresent()) {
            country.setIdpais(id);
            return save(country);
        } else {
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Country> country = countryRepository.findById(id);
        if(country.isPresent()){
            countryRepository.delete(country.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }
}
