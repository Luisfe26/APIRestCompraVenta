package com.compraventa.compraventa.service.implemet;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.TipoOrder;
import com.compraventa.compraventa.repository.TipoOrdersRepository;
import com.compraventa.compraventa.service.TipoOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TipoOrdersServiceImpl implements TipoOrdersService {

    private final TipoOrdersRepository tipoOrdersRepository;

    @Autowired
    public TipoOrdersServiceImpl(TipoOrdersRepository tipoOrdersRepository) {
        this.tipoOrdersRepository = tipoOrdersRepository;
    }

    @Override
    public List<TipoOrder> findAll() {
        return tipoOrdersRepository.findAll();
    }

    @Override
    public TipoOrder findById(Integer id) {
        Optional<TipoOrder> tipoOrder = tipoOrdersRepository.findById(id);
        if (tipoOrder.isPresent()) {
            return tipoOrder.get();
        } else {
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public TipoOrder save(TipoOrder tipoOrder) {
        return tipoOrdersRepository.save(tipoOrder);
    }

    @Override
    public TipoOrder update(TipoOrder rol, Integer id) {
        Optional<TipoOrder> findtipoOrder = tipoOrdersRepository.findById(id);
        if (findtipoOrder.isPresent()) {
            rol.setIdtipoorden(id);
            return save(rol);
        } else {
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<TipoOrder> tipoOrder = tipoOrdersRepository.findById(id);
        if (tipoOrder.isPresent()) {
            tipoOrdersRepository.delete(tipoOrder.get());
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }
}
