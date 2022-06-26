package com.compraventa.compraventa.model;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.time.LocalDateTime;


@Entity
@Table(name = "ordenes")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idorden;

    @Size(min = 8, max = 8, message = "LA FECHA DEBE DE TENER 8 CARACTERES")
    @Column(name = "fechaorden", nullable = false)
    private String fechaOrden;

    @ManyToOne
    @JoinColumn(name = "idcliente", nullable = false,
            foreignKey = @ForeignKey(name = "FK_orden_cliente"))
    private Person persona;

    @ManyToOne
    @JoinColumn(name = "idmoneda", nullable = false,
            foreignKey = @ForeignKey(name = "FK_orden_tipoorden"))
    private Moneda moneda;

    @Positive
    @Column(name = "montocambio", nullable = false)
    private Integer montoCambio;

    @Positive
    @Column(name = "montorecibe", nullable = false)
    private Integer montoRecibe;

    @ManyToOne
    @JoinColumn(name = "tipoorder", nullable = false,
            foreignKey = @ForeignKey(name = "FK_orden_tipoorden"))
    private TipoOrder tipoOrder;

    //GET-SET

    public Integer getIdorden() {
        return idorden;
    }

    public void setIdorden(Integer idorden) {
        this.idorden = idorden;
    }

    public String getFechaOrden() {
        return fechaOrden;
    }

    public void setFechaOrden(String fechaOrden) {
        this.fechaOrden = fechaOrden;
    }

    public Person getPersona() {
        return persona;
    }

    public void setPersona(Person persona) {
        this.persona = persona;
    }

    public Moneda getMoneda() {
        return moneda;
    }

    public void setMoneda(Moneda moneda) {
        this.moneda = moneda;
    }

    public Integer getMontoCambio() {
        return montoCambio;
    }

    public void setMontoCambio(Integer montoCambio) {
        this.montoCambio = montoCambio;
    }

    public Integer getMontoRecibe() {
        return montoRecibe;
    }

    public void setMontoRecibe(Integer montoRecibe) {
        this.montoRecibe = montoRecibe;
    }

    public TipoOrder getTipoOrder() {
        return tipoOrder;
    }

    public void setTipoOrder(TipoOrder tipoOrder) {
        this.tipoOrder = tipoOrder;
    }
}
