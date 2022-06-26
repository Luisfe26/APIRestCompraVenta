package com.compraventa.compraventa.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "pais")
public class Country {

    @Id
    @ApiModelProperty(notes = "El id es un correlativo y se genera de forma automatica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpais;

    @ApiModelProperty(notes = "El nombre debe tener como minimo 7 caracteres y maximo 30")
    @Size(min = 3, max = 30, message = "El nombre debe tener un minimo de 3 caracteres")
    @Column(name = "nombre", nullable = false, length = 30)
    private String nombre;

    @ApiModelProperty(notes = "El codpais debe tener como minimo 2 caracteres y maximo 2")
    @Size(min = 2, max = 2, message = "El codigo del pais es obligatorio")
    @Column(name = "codpais", nullable = false, length = 2)
    private String codpais;

    public Integer getIdpais() {
        return idpais;
    }

    public void setIdpais(Integer idpais) {
        this.idpais = idpais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodpais() {
        return codpais;
    }

    public void setCodpais(String codpais) {
        this.codpais = codpais;
    }
}
