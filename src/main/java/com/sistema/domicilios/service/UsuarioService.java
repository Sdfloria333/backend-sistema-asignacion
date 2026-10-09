package com.sistema.domicilios.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sistema.domicilios.model.EstadoUsuario;
import com.sistema.domicilios.model.Usuario;
import com.sistema.domicilios.repository.EstadoUsuarioRepository;
import com.sistema.domicilios.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final EstadoUsuarioRepository estadoUsuarioRepository;

    // Inyección de dependencias por constructor
    public UsuarioService(UsuarioRepository usuarioRepository, EstadoUsuarioRepository estadoUsuarioRepository) {
        this.usuarioRepository = usuarioRepository;
        this.estadoUsuarioRepository = estadoUsuarioRepository;
    }

    // Método para listar todos los usuarios
    public List<Usuario> obtenerTodos() {
        return usuarioRepository.findAll();
    }

    // Lógica para crear un nuevo usuario
    public Usuario crearUsuario(String nombre, String telefono, String rol, Long idEstado) {
        // 1. Regla de negocio: verificar que el estado exista
        EstadoUsuario estado = estadoUsuarioRepository.findById(idEstado)
                .orElseThrow(() -> new RuntimeException("El estado de usuario no existe"));

        // 2. Armar el objeto
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setTelefono(telefono);
        usuario.setRol(rol);
        usuario.setEstado(estado);

        // 3. Guardar en BD usando el repositorio
        return usuarioRepository.save(usuario);
    }
}
