package com.compraventa.compraventa.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idrol;

    @Size(min = 3, max = 30, message = "El nombre debe tener un minimo de 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @Size(min = 2, max = 100, message = "El codigo del pais es obligatorio")
    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
