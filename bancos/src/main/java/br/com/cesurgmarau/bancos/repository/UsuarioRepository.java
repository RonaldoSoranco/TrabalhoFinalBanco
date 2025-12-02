package br.com.cesurgmarau.bancos.repository;

import br.com.cesurgmarau.bancos.model.Usuario;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null || usuario.getId() == 0) {
            usuario.setId(idCounter.incrementAndGet());
        } else {

            usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
        }
        usuarios.add(usuario);
        return usuario;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream().filter(u -> u.getId().equals(id)).findFirst();
    }

    public Optional<Usuario> buscarPorCpf(String cpf) {
        return usuarios.stream().filter(u -> u.getCpf().equals(cpf)).findFirst();
    }

    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }


    public void deletar(Long id) {
        usuarios.removeIf(u -> u.getId().equals(id));
    }
}