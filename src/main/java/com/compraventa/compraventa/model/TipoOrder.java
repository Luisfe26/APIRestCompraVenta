package com.compraventa.compraventa.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tipoorder")
public class TipoOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idtipoorden;

    @Size(min = 3, max = 30, message = "El nombre debe tener un minimo de 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    public Integer getIdtipoorden() {
        return idtipoorden;
    }

    public void setIdtipoorden(Integer idtipoorden) {
        this.idtipoorden = idtipoorden;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
