package com.compraventa.compraventa.service.implemet;

import com.compraventa.compraventa.DTO.ListPersonDTO;
import com.compraventa.compraventa.exception.ModeloNotFoundException;
import com.compraventa.compraventa.model.Person;
import com.compraventa.compraventa.repository.PersonRepository;
import com.compraventa.compraventa.service.PersonSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements UserDetailsService, PersonSevice {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Person person = personRepository.findOneByEmail(username);

        if(person == null) {
            throw new UsernameNotFoundException(String.format("Usuario no existe", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        person.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        });

        UserDetails ud = new User(person.getEmail(), person.getContraseña(), roles);

        return ud;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public List<Person> findAllByName(String nombre) {
        return personRepository.findAllByNombres(nombre);
    }

    @Override
    public List<ListPersonDTO> listperson() {
        List<ListPersonDTO> persona = new ArrayList<>();

        personRepository.listperson().forEach(p ->{
            ListPersonDTO po = new ListPersonDTO();
            po.setDNI(String.valueOf(p[3]));
            po.setNombre(String.valueOf(p[5]));
            po.setApellido(String.valueOf(p[1]));
            po.setTelefono(String.valueOf(p[6]));
            po.setEmail(String.valueOf(p[4]));
            persona.add(po);
        });

        return persona;
    }

    @Override
    public Person update(Person person, Integer id){
        Optional<Person> findclient = personRepository.findById(id);
        if (findclient.isPresent()) {
            person.setIdpersona(id);
            return save(person);
        } else {
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public ResponseEntity<Object> delete(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            personRepository.delete(person.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
    }

    @Override
    public Person findById(Integer id) {
        Optional<Person> person = personRepository.findById(id);
        if(person.isPresent()){
            return person.get();
        }else{
            throw new ModeloNotFoundException("No se encontraron datos");
        }
        }
    }
