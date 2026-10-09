package com.sistema.domicilios.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sistema.domicilios.model.Central;
import com.sistema.domicilios.service.CentralService;

@RestController
@RequestMapping("/api/centrales")
@CrossOrigin(origins = "*") // Permite peticiones desde tu frontend web
public class CentralController {

    private final CentralService centralService;

    public CentralController(CentralService centralService) {
        this.centralService = centralService;
    }

    @GetMapping
    public ResponseEntity<List<Central>> listarTodas() {
        return ResponseEntity.ok(centralService.listarTodas());
    }

    @PostMapping
    public ResponseEntity<Central> crearCentral(
            @RequestParam String nombre,
            @RequestParam String telefono,
            @RequestParam Long idEstado) {
        Central nuevaCentral = centralService.crearCentral(nombre, telefono, idEstado);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaCentral);
    }
}
