package com.sistema.domicilios.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.domicilios.model.Domiciliario;
import com.sistema.domicilios.service.DomiciliarioService;

@RestController
@RequestMapping("/api/domiciliarios")
@CrossOrigin(origins = "*")
public class DomiciliarioController {

    private final DomiciliarioService domiciliarioService;

    public DomiciliarioController(DomiciliarioService domiciliarioService) {
        this.domiciliarioService = domiciliarioService;
    }

    @GetMapping
    public ResponseEntity<List<Domiciliario>> listarTodos() {
        return ResponseEntity.ok(domiciliarioService.listarTodos());
    }

    @PostMapping
    public ResponseEntity<Domiciliario> crearDomiciliario(
            @RequestParam String nombre,
            @RequestParam String telefono,
            @RequestParam Long idEstado) {
        Domiciliario nuevoDomiciliario = domiciliarioService.crearDomiciliario(nombre, telefono, idEstado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoDomiciliario);
    }

    @PatchMapping("/{id}/estado-operativo")
    public ResponseEntity<Domiciliario> cambiarEstadoOperativo(
            @PathVariable Long id,
            @RequestParam String nuevoEstado) {
        Domiciliario actualizado = domiciliarioService.cambiarEstadoOperativo(id, nuevoEstado);
        return ResponseEntity.ok(actualizado);
    }
}
