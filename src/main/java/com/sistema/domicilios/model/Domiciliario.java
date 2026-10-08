package com.sistema.domicilios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "EntidadDomiciliario")
@Table(name = "DOMICILIARIO")
public class Domiciliario {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.AUTO)
    @Column(name = "ID_DOMICILIARIO")
    private Long idDomiciliario;

    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @Column(name = "ESTADO_OPERATIVO", nullable = false, length = 30)
    private String estadoOperativo;

    public Long getIdDomiciliario() {
        return idDomiciliario;
    }

    public void setIdDomiciliario(Long idDomiciliario) {
        this.idDomiciliario = idDomiciliario;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEstadoOperativo() {
        return estadoOperativo;
    }

    public void setEstadoOperativo(String estadoOperativo) {
        this.estadoOperativo = estadoOperativo;
    }

    

}
