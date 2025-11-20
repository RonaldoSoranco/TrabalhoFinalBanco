package br.com.cesurgmarau.bancos.controller; // <--- O segredo está aqui: .bancos.controller

import br.com.cesurgmarau.bancos.model.Usuario; // Talvez precise ajustar o import do model também
import br.com.cesurgmarau.bancos.service.UsuarioService; // E do service
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    // ... resto do código igual ...
    @Autowired
    private UsuarioService service;

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        return service.criar(usuario);
    }

    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }
}