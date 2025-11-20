package br.com.cesurgmarau.bancos.repository;

import br.com.cesurgmarau.bancos.model.Usuario;
import org.springframework.stereotype.Repository; // Import necessário

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository // Isso diz ao Spring: "Gerencie esta classe e mantenha os dados na memória"
public class UsuarioRepository {

    private final List<Usuario> usuarios = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    // CREATE & UPDATE
    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null || usuario.getId() == 0) {
            usuario.setId(idCounter.incrementAndGet());
        } else {
            // Remove o antigo para atualizar (simulação de update)
            usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
        }
        usuarios.add(usuario);
        return usuario;
    }

    // READ - Por ID
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream()
                .filter(u -> u.getId() != null && u.getId().equals(id))
                .findFirst();
    }

    // READ - Por CPF
    public Optional<Usuario> buscarPorCpf(String cpf) {
        return usuarios.stream()
                .filter(u -> u.getCpf() != null && u.getCpf().equals(cpf))
                .findFirst();
    }

    // READ - Todos
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }
}