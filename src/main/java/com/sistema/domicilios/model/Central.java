package com.sistema.domicilios.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;

@Entity(name = "EntidadCentral")
@Table(name = "CENTRAL")
public class Central {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CENTRAL")
    private Long idCdentral;

    @Column(name = "ID_USUARIO", nullable = false)
    private Long idUsuario;

    public Long getIdCdentral() {
        return idCdentral;
    }

    public void setIdCdentral(Long idCdentral) {
        this.idCdentral = idCdentral;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

}
