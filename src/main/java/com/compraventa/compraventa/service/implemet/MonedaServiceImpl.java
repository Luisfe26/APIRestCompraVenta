package com.compraventa.compraventa.service.implemet;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.Moneda;
import com.compraventa.compraventa.model.Orders;
import com.compraventa.compraventa.model.Person;
import com.compraventa.compraventa.repository.MonedaRepository;
import com.compraventa.compraventa.service.MonedaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MonedaServiceImpl implements MonedaService {

    private MonedaRepository monedaRepository;

    @Autowired
    public MonedaServiceImpl(MonedaRepository monedaRepository) {
        this.monedaRepository = monedaRepository;
    }

    @Override
    public List<Moneda> findAll() {
        return monedaRepository.findAll();
    }

    @Override
    public Moneda findById(Integer id) {
        Optional<Moneda> moneda = monedaRepository.findById(id);
        if(moneda.isPresent()){
            return moneda.get();
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public Moneda save(Moneda moneda) {
        return monedaRepository.save(moneda);
    }

    @Override
    public Moneda update(Moneda moneda, Integer id) {
        Optional<Moneda> findmoneda = monedaRepository.findById(id);
        if (findmoneda.isPresent()) {
            moneda.setIdmoneda(id);
            return save(moneda);
        } else {
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Moneda> moneda = monedaRepository.findById(id);
        if(moneda.isPresent()){
            monedaRepository.delete(moneda.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

}
