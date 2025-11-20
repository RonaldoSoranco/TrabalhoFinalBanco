package br.com.cesurgmarau.bancos.service;

import br.com.cesurgmarau.bancos.model.Usuario;
import br.com.cesurgmarau.bancos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    public Usuario criar(Usuario usuario) {

        if (usuario.getCpf() == null || usuario.getCpf().isEmpty()) {
            throw new IllegalArgumentException("O CPF é obrigatório!");
        }
        if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
            throw new IllegalArgumentException("O Nome é obrigatório!");
        }

        Optional<Usuario> usuarioExistente = repository.buscarPorCpf(usuario.getCpf());

        if (usuarioExistente.isPresent()) {
            throw new IllegalArgumentException("já existe um usuario cadastrado com esse CPF");
        }

        return repository.salvar(usuario);
    }

    public List<Usuario> listar() {
        return repository.listarTodos();
    }
}