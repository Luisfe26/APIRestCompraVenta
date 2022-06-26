package com.compraventa.compraventa.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name = "moneda")
public class Moneda {

    @Id
    @ApiModelProperty(notes = "El id es un correlativo y se genera de forma automatica")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idmoneda;

    @ApiModelProperty(notes = "El nombre debe tener como minimo 3 caracteres y maximo 30")
    @Size(min = 3, max = 30, message = "El nombre debe tener un minimo de 3 caracteres")
    @Column(name = "nombremoneda", nullable = false, length = 30)
    private String nombremoneda;

    @ApiModelProperty(notes = "El codmoneda debe tener como minimo 3 caracteres y maximo 3")
    @Size(min = 3, max = 3, message = "El codigo del pais es obligatorio")
    @Column(name = "codmoneda", nullable = false, length = 3)
    private String codmoneda;

    @ApiModelProperty(notes = "El tipocambio venta debe ser un entero")
    @Positive
    @Column(name = "tipocambioventa", nullable = false)
    private Integer tipocambioventa;

    @ApiModelProperty(notes = "El tipocambio compra debe ser un entero")
    @Positive
    @Column(name = "tipocambiocompra", nullable = false)
    private Integer tipocambiocompra;

    //GET-SET

    public Integer getIdmoneda() {
        return idmoneda;
    }

    public void setIdmoneda(Integer idmoneda) {
        this.idmoneda = idmoneda;
    }

    public String getNombremoneda() {
        return nombremoneda;
    }

    public void setNombremoneda(String nombremoneda) {
        this.nombremoneda = nombremoneda;
    }

    public String getCodmoneda() {
        return codmoneda;
    }

    public void setCodmoneda(String codmoneda) {
        this.codmoneda = codmoneda;
    }

    public Integer getTipocambioventa() {
        return tipocambioventa;
    }

    public void setTipocambioventa(Integer tipocambioventa) {
        this.tipocambioventa = tipocambioventa;
    }

    public Integer getTipocambiocompra() {
        return tipocambiocompra;
    }

    public void setTipocambiocompra(Integer tipocambiocompra) {
        this.tipocambiocompra = tipocambiocompra;
    }
}
