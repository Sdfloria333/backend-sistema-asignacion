package com.sistema.domicilios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.domicilios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
