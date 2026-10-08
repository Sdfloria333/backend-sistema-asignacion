// EstadoUsuarioRepository.java
package com.sistema.domicilios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.domicilios.model.EstadoUsuario;

public interface EstadoUsuarioRepository extends JpaRepository<EstadoUsuario, Long> {
}