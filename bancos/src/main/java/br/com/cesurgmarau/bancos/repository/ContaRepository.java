package br.com.cesurgmarau.bancos.repository;

import br.com.cesurgmarau.bancos.model.Conta;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ContaRepository {

    private final List<Conta> contas = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    // cria ou atualiza
    public Conta salvar(Conta conta) {
        if (conta.getId() == null || conta.getId() == 0) {
            conta.setId(idCounter.incrementAndGet());
        } else {
            // para remover a conta antiga na atualização
            contas.removeIf(c -> c.getId().equals(conta.getId()));
        }
        contas.add(conta);
        return conta;
    }

    // pra busca por id
    public Optional<Conta> buscarPorId(Long id) {
        return contas.stream()
                .filter(c -> c.getId() != null && c.getId().equals(id))
                .findFirst();
    }

    // lista tudoas
    public List<Conta> listarTodas() {
        return new ArrayList<>(contas);
    }

    }
