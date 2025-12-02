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
        if (usuario.getCpf() == null) throw new IllegalArgumentException("CPF obrigatório");

        if (usuario.getId() == null) {
            Optional<Usuario> existe = repository.buscarPorCpf(usuario.getCpf());
            if (existe.isPresent()) throw new IllegalArgumentException("CPF já existe");
        }

        return repository.salvar(usuario);
    }

    public List<Usuario> listar() {
        return repository.listarTodos();
    }


    public Usuario atualizar(Long id, Usuario usuario) {
        usuario.setId(id);
        return repository.salvar(usuario);
    }

    public void deletar(Long id) {
        repository.deletar(id);
    }
}