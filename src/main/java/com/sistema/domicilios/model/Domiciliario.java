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

}
