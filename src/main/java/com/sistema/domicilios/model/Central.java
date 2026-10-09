package com.sistema.domicilios.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity(name = "EntidadCentral")
@Table(name = "CENTRAL")
public class Central {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_CENTRAL")
    private Long idCdentral;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO", nullable = false, unique = true)
    @Column(name = "ID_USUARIO", nullable = false)
    private Usuario usuario;

    public Long getIdCdentral() {
        return idCdentral;
    }

    public void setIdCdentral(Long idCdentral) {
        this.idCdentral = idCdentral;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
