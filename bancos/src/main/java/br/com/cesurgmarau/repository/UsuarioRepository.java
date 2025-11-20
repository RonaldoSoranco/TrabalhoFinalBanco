package br.com.cesurgmarau.repository;
// Altere este pacote para o seu pacote correto (ex: br.com.cesurgmarau.bancos.repository)

// IMPORTAÇÕES NECESSÁRIAS
import br.com.cesurgmarau.model.Usuario; // Seu modelo de dados
// Importação CORRIGIDA para a anotação @Repository
import org.springframework.stereotype.Repository;

// Imports padrão do Java
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
// Removido o import de UsuarioNotFoundException e Collectors, pois não foram usados no código final.

/**
 * Repositório em Memória (Não Persistente) para a entidade Usuario.
 */
@Repository // Resolve o erro "Cannot resolve symbol 'Repository'"
public class UsuarioRepository {

    // Lista que SIMULA o banco de dados em memória
    private final List<Usuario> usuarios = new ArrayList<>();

    // Gerador de ID para simular o auto-incremento
    private final AtomicLong idCounter = new AtomicLong(0);

    // // CREATE - salvar (Usuario usuario)
    public Usuario salvar(Usuario usuario) {
        if (usuario.getId() == null || usuario.getId() == 0) {
            usuario.setId(idCounter.incrementAndGet());
        } else {
            // Se já tem ID, remove o antigo para simular um update (put)
            usuarios.removeIf(u -> u.getId().equals(usuario.getId()));
        }
        usuarios.add(usuario);
        return usuario;
    }

    // // READ - buscar por ID
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst();
    }

    // // READ - buscar por CPF
    public Optional<Usuario> buscarPorCpf(String cpf) {
        return usuarios.stream()
                .filter(u -> u.getCpf() != null && u.getCpf().equals(cpf))
                .findFirst();
    }

    // // LIST - listarTodos
    public List<Usuario> listarTodos() {
        return new ArrayList<>(usuarios);
    }

    // FECHAMENTO DA CLASSE
} // A chave de fechamento FINAL está aqui, corrigindo o erro "Unexpected token" na linha 44