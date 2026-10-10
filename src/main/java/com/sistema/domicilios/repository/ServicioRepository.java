package com.sistema.domicilios.repository;

import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sistema.domicilios.model.Servicio;

import jakarta.persistence.LockModeType;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select s from EntidadServicio s where s.idServicio = :id")
    Optional<Servicio> findByIdForUpdate(@Param("id") Long id);

}
