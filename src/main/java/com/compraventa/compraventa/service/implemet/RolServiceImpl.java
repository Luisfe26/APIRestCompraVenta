package com.compraventa.compraventa.service.implemet;

import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.Rol;
import com.compraventa.compraventa.repository.RolRepository;
import com.compraventa.compraventa.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServiceImpl implements RolService {

    private final RolRepository rolRepository;

    @Autowired
    public RolServiceImpl(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

    @Override
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Integer id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if(rol.isPresent()){
            return rol.get();
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public Rol update(Rol rol, Integer id) {
        Optional<Rol> findrol = rolRepository.findById(id);
        if (findrol.isPresent()) {
            rol.setIdrol(id);
            return save(rol);
        } else {
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Rol> rol = rolRepository.findById(id);
        if(rol.isPresent()){
            rolRepository.delete(rol.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }
}
