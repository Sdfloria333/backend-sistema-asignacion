package com.sistema.domicilios.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sistema.domicilios.model.Central;
import com.sistema.domicilios.model.EstadoUsuario;
import com.sistema.domicilios.model.Usuario;
import com.sistema.domicilios.repository.CentralRepository;
import com.sistema.domicilios.repository.EstadoUsuarioRepository;
import com.sistema.domicilios.repository.UsuarioRepository;

@Service
public class CentralService {

    private final CentralRepository centralRepository;
    private final UsuarioRepository usuarioRepository;
    private final EstadoUsuarioRepository estadoUsuarioRepository;

    public CentralService(CentralRepository centralRepository,
            UsuarioRepository usuarioRepository,
            EstadoUsuarioRepository estadoUsuarioRepository) {
        this.centralRepository = centralRepository;
        this.usuarioRepository = usuarioRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;
    }

    public List<Central> listarTodas() {
        return centralRepository.findAll();
    }

    @Transactional
    public Central crearCentral(String nombre, String telefono, Long idEstado) {
        EstadoUsuario estado = estadoUsuarioRepository.findById(idEstado)
                .orElseThrow(() -> new RuntimeException("Estado de usuario no encontrado"));

        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setTelefono(telefono);
        usuario.setRol("CENTRAL");
        usuario.setEstado(estado);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);

        Central central = new Central();
        central.setUsuario(usuarioGuardado);

        return centralRepository.save(central);
    }
}
