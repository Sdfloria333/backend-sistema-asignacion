package com.sistema.domicilios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
    @JoinColumn(name = "ID_CENTRAL")
    private Central central;

    @ManyToOne
    @JoinColumn(name = "ID_DOMICILIARIO")
    private Domiciliario domiciliario;

    @ManyToOne
    @JoinColumn(name = "ID_ESTADO_SERVICIO")
    private EstadoServicio estadoServicio;

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

    public Central getCentral() {
        return central;
    }

    public void setCentral(Central central) {
        this.central = central;
    }

    public Domiciliario getDomiciliario() {
        return domiciliario;
    }

    public void setDomiciliario(Domiciliario domiciliario) {
        this.domiciliario = domiciliario;
    }

    public EstadoServicio getEstadoServicio() {
        return estadoServicio;
    }

    public void setEstadoServicio(EstadoServicio estadoServicio) {
        this.estadoServicio = estadoServicio;
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
