package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AutnController {

    private final UsuarioService usuarioService;

    public AutnController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/Login")
    public Usuario login(@RequestBody Usuario usuario) {

        return usuarioService.login(
                usuario.getEmail(),
                usuario.getPassword()
        ).orElseThrow(() ->
                new RuntimeException("Credenciales incorrectas")
        );
    }


    @PostMapping("/registrar")
    public Usuario registrar(@RequestBody Usuario usuario){
        return usuarioService.registrar(usuario);
    }

    // Para probar si el back responde
    @GetMapping("/test")
    public String test(){
        return "Backend OK";
    }
}