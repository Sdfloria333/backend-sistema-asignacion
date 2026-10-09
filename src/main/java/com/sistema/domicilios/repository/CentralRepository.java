package com.sistema.domicilios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.domicilios.model.Central;

public interface CentralRepository extends JpaRepository<Central, Long> {
}
