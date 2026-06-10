package com.example.demo.service;

import com.example.demo.model.Usuario;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class UsuarioService {
    private final Map<String, Usuario > usuarios = new ConcurrentHashMap<>();

    public UsuarioService() {

    }

    public void registrar (Usuario usuario){
        usuarios.put(usuario.getCorreo(), usuario);
    }

    public boolean existeUsuario (String correo){
        return usuarios.containsKey(correo);
    }

    public boolean autenticar (String correo, String password){
        Usuario usuario = usuarios.get(correo);
        return usuario != null && usuario.getPassword().equals(password);
    }
}
