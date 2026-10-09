package com.sistema.domicilios.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.domicilios.model.Servicio;
import com.sistema.domicilios.service.ServicioService;

@RestController
@RequestMapping("/api/servicios")
@CrossOrigin(origins = "*")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public ResponseEntity<List<Servicio>> listarTodos() {
        return ResponseEntity.ok(servicioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Servicio> crearServicio(
            @RequestParam Long idCentral,
            @RequestParam String recogida,
            @RequestParam String entrega) {
        Servicio nuevoServicio = servicioService.crearServicio(idCentral, recogida, entrega);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoServicio);
    }

    @PutMapping("/{id}/asignar")
    public ResponseEntity<Servicio> asignarDomiciliario(
            @PathVariable Long id,
            @RequestParam Long idDomiciliario) {
        Servicio actualizado = servicioService.asignarDomiciliario(id, idDomiciliario);
        return ResponseEntity.ok(actualizado);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Servicio> cambiarEstado(
            @PathVariable Long id,
            @RequestParam Long idNuevoEstado) {
        Servicio actualizado = servicioService.cambiarEstadoServicio(id, idNuevoEstado);
        return ResponseEntity.ok(actualizado);
    }
}
