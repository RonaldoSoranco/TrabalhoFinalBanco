package br.com.cesurgmarau.bancos.repository;

import br.com.cesurgmarau.bancos.model.Transacao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TransacaoRepository {

    private final List<Transacao> transacoes = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public Transacao salvar(Transacao transacao) {
        // Gera um ID novo para a transação
        transacao.setId(idCounter.incrementAndGet());
        transacoes.add(transacao);
        return transacao;
    }

    public List<Transacao> listarTodas() {
        return new ArrayList<>(transacoes);
    }
}