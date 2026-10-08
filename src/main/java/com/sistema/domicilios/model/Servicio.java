package com.sistema.domicilios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity(name = "EntidadServicio")
@Table(name = "SERVICIO")

public class Servicio {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Column(name = "ID_SERVICIO")
    private Long idServicio;

    @ManyToOne
    @Column(name = "ID_CENTRAL")
    private Long idCentral;

    @ManyToOne
    @Column(name = "ID_DOMICILIARIO")
    private Long idDomiciliario;

    @ManyToOne
    @Column(name = "ID_ESTADO_SERVICIO")
    private Long idEstadoServicio;

    @Column(name = "RECOGIDA", nullable = false, length = 200)
    private String recogida;

    @Column(name = "ENTREGA", nullable = false, length = 200)
    private String entrega;

    public Long getIdServicio() {
        return idServicio;
    }

    public void setIdServicio(Long idServicio) {
        this.idServicio = idServicio;
    }

    public Long getIdCentral() {
        return idCentral;
    }

    public void setIdCentral(Long idCentral) {
        this.idCentral = idCentral;
    }

    public Long getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(Long idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public Long getIdEstadoServicio() {
        return idEstadoServicio;
    }

    public void setIdEstadoServicio(Long idEstadoServicio) {
        this.idEstadoServicio = idEstadoServicio;
    }

    public String getRecogida() {
        return recogida;
    }

    public void setRecogida(String recogida) {
        this.recogida = recogida;
    }

    public String getEntrega() {
        return entrega;
    }

    public void setEntrega(String entrega) {
        this.entrega = entrega;
    }

}
