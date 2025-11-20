package br.com.cesurgmarau.repository;
// Ajuste o pacote conforme a sua estrutura

import br.com.cesurgmarau.model.Usuario;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository // Agora deve ser resolvido após a sincronização
public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    // CREATE & UPDATE - salvar(Usuario usuario)
    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null || usuario.getId() == 0) {
            usuario.setId(idCounter.incrementAndGet());
        } else {
            // Simula o update
            usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
        }
        usuarios.add(usuario);
        return usuario;
    }

    // READ - buscarPorId(Long id)
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream()
                .filter(u -> u.getId() != null && u.getId().equals(id))
                .findFirst();
    }

    // READ - buscarPorCpf(String cpf)
    public Optional<Usuario> buscarPorCpf(String cpf) {
        return usuarios.stream()
                .filter(u -> u.getCpf() != null && u.getCpf().equals(cpf))
                .findFirst();
    }

    // READ - listarTodos()
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}