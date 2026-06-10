package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainControl {
    private final UsuarioService usuarioService;

    public MainControl(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping({"/index", "/index.html"})
    public String index() {
        return "index";
    }

    @GetMapping({"/", "/iniciar-sesion", "/iniciar-sesion.html"})
    public String iniciarSesion() {
        return "iniciar-sesion";
    }

    @GetMapping({"/registro", "/registro.html"})
    public String registro() {
        return "registro";
    }

    @PostMapping("/crear-cuenta")
    public String crearCuenta(@ModelAttribute Usuario usuario) {
        if (usuarioService.existeUsuario(usuario.getCorreo())) {
            return "redirect /error";
        }

        usuarioService.registrar(usuario);

        return "redirect:/iniciar-sesion";

    }

    @PostMapping("/autentication")
    public String autenticacion(@RequestParam ("email") String email, @RequestParam("password") String password) {
        if (usuarioService.existeUsuario(email)) {
            return  "redirect:/index";
        }

        return "redirect:/error";
    }
}
