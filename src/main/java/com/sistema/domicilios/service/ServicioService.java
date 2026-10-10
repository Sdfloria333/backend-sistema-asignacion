package com.sistema.domicilios.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.domicilios.model.Central;
import com.sistema.domicilios.model.Domiciliario;
import com.sistema.domicilios.model.EstadoServicio;
import com.sistema.domicilios.model.Servicio;
import com.sistema.domicilios.repository.CentralRepository;
import com.sistema.domicilios.repository.DomiciliarioRepository;
import com.sistema.domicilios.repository.EstadoServicioRepository;
import com.sistema.domicilios.repository.ServicioRepository;

@Service
public class ServicioService {

    private final ServicioRepository servicioRepository;
    private final CentralRepository centralRepository;
    private final DomiciliarioRepository domiciliarioRepository;
    private final EstadoServicioRepository estadoServicioRepository;

    public ServicioService(ServicioRepository servicioRepository,
            CentralRepository centralRepository,
            DomiciliarioRepository domiciliarioRepository,
            EstadoServicioRepository estadoServicioRepository) {
        this.servicioRepository = servicioRepository;
        this.centralRepository = centralRepository;
        this.domiciliarioRepository = domiciliarioRepository;
        this.estadoServicioRepository = estadoServicioRepository;
    }

    public List<Servicio> listarTodos() {
        return servicioRepository.findAll();
    }

    // 1. La Central crea el domicilio
    @Transactional
    public Servicio crearServicio(Long idCentral, String recogida, String entrega) {
        Central central = centralRepository.findById(idCentral)
                .orElseThrow(() -> new RuntimeException("Central no encontrada"));

        EstadoServicio estadoCreado = estadoServicioRepository.findById(1L)
                .orElseThrow(() -> new RuntimeException("Estado CREADO no encontrado"));

        Servicio servicio = new Servicio();
        servicio.setCentral(central);
        servicio.setRecogida(recogida);
        servicio.setEntrega(entrega);
        servicio.setEstadoServicio(estadoCreado);

        return servicioRepository.save(servicio);
    }

    // 2. Se le asigna un Domiciliario
    @Transactional
    public Servicio asignarDomiciliario(Long idServicio, Long idDomiciliario) {
        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        if (servicio.getDomiciliario() != null) {
            throw new RuntimeException("El servicio ya fue tomado por otro domiciliario");
        }

        Domiciliario domiciliario = domiciliarioRepository.findById(idDomiciliario)
                .orElseThrow(() -> new RuntimeException("Domiciliario no encontrado"));

        if (!"DISPONIBLE".equals(domiciliario.getEstadoOperativo())) {
            throw new RuntimeException("El domiciliario no está disponible");
        }

        EstadoServicio estadoAsignado = estadoServicioRepository.findById(2L)
                .orElseThrow(() -> new RuntimeException("Estado ASIGNADO no encontrado"));

        servicio.setDomiciliario(domiciliario);
        servicio.setEstadoServicio(estadoAsignado);
        return servicioRepository.save(servicio);
    }

    // 3. Avance de estados (EN_RUTA, ENTREGADO, CANCELADO)
    @Transactional
    public Servicio cambiarEstadoServicio(Long idServicio, Long idNuevoEstado) {
        Servicio servicio = servicioRepository.findById(idServicio)
                .orElseThrow(() -> new RuntimeException("Servicio no encontrado"));

        EstadoServicio nuevoEstado = estadoServicioRepository.findById(idNuevoEstado)
                .orElseThrow(() -> new RuntimeException("Estado de servicio no encontrado"));

        servicio.setEstadoServicio(nuevoEstado);
        return servicioRepository.save(servicio);
    }
}
