package com.sistema.domicilios.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.domicilios.model.Domiciliario;
import com.sistema.domicilios.model.EstadoUsuario;
import com.sistema.domicilios.model.Usuario;
import com.sistema.domicilios.repository.DomiciliarioRepository;
import com.sistema.domicilios.repository.EstadoUsuarioRepository;
import com.sistema.domicilios.repository.UsuarioRepository;

@Service
public class DomiciliarioService {

    private final DomiciliarioRepository domiciliarioRepository;
    private final UsuarioRepository usuarioRepository;
    private final EstadoUsuarioRepository estadoUsuarioRepository;

    public DomiciliarioService(DomiciliarioRepository domiciliarioRepository,
            UsuarioRepository usuarioRepository,
            EstadoUsuarioRepository estadoUsuarioRepository) {
        this.domiciliarioRepository = domiciliarioRepository;
        this.usuarioRepository = usuarioRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;
    }

    public List<Domiciliario> listarTodos() {
        return domiciliarioRepository.findAll();
    }

    @Transactional
    public Domiciliario crearDomiciliario(String nombre, String telefono, Long idEstado) {
        EstadoUsuario estado = estadoUsuarioRepository.findById(idEstado)
                .orElseThrow(() -> new RuntimeException("Estado de usuario no encontrado"));

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setTelefono(telefono);
        usuario.setRol("DOMICILIARIO");
        usuario.setEstado(estado);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        Domiciliario domiciliario = new Domiciliario();
        domiciliario.setUsuario(usuarioGuardado);
        domiciliario.setEstadoOperativo("DISPONIBLE");

        return domiciliarioRepository.save(domiciliario);
    }

    @Transactional
    public Domiciliario cambiarEstadoOperativo(Long idDomiciliario, String nuevoEstado) {
        Domiciliario domiciliario = domiciliarioRepository.findById(idDomiciliario)
                .orElseThrow(() -> new RuntimeException("Domiciliario no encontrado"));

        domiciliario.setEstadoOperativo(nuevoEstado);
        return domiciliarioRepository.save(domiciliario);
    }
}
