package br.com.cesurgmarau.bancos.controller;

import br.com.cesurgmarau.bancos.model.Usuario;
import br.com.cesurgmarau.bancos.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

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


    @PutMapping("/{id}") // Resolve o erro 404 no PUT
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        return service.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}") // Permite deletar
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}