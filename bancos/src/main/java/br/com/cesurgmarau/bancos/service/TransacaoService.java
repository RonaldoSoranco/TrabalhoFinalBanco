package br.com.cesurgmarau.bancos.service;

import br.com.cesurgmarau.bancos.model.Conta;
import br.com.cesurgmarau.bancos.model.Transacao;
import br.com.cesurgmarau.bancos.repository.ContaRepository;
import br.com.cesurgmarau.bancos.repository.TransacaoRepository; // Você precisará criar este arquivo se não tiver
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransacaoService {

    @Autowired
    private TransacaoRepository transacaoRepository;

    @Autowired
    private ContaRepository contaRepository;

    public Transacao realizarTransacao(Transacao transacao) {
        // 1. Validar valor positivo
        if (transacao.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero!");
        }

        // 2. Buscar as contas no banco de dados (Memória)
        Optional<Conta> origemOpt = contaRepository.buscarPorId(transacao.getContaOrigem().getId());
        Optional<Conta> destinoOpt = contaRepository.buscarPorId(transacao.getContaDestino().getId());

        if (origemOpt.isEmpty() || destinoOpt.isEmpty()) {
            throw new IllegalArgumentException("Conta de origem ou destino não encontrada!");
        }

        Conta origem = origemOpt.get();
        Conta destino = destinoOpt.get();

        // 3. Validar Saldo da Origem
        // Se (Saldo < Valor)
        if (origem.getSaldo().compareTo(transacao.getValor()) < 0) {
            throw new IllegalArgumentException("Saldo insuficiente para realizar a transação!");
        }

        // 4. A MÁGICA: Debitar de um e Creditar no outro
        // origem = saldo - valor
        origem.setSaldo(origem.getSaldo().subtract(transacao.getValor()));
        // destino = saldo + valor
        destino.setSaldo(destino.getSaldo().add(transacao.getValor()));

        // 5. Atualizar as contas no banco
        contaRepository.salvar(origem);
        contaRepository.salvar(destino);

        // 6. Finalizar a transação (Registrar data e salvar histórico)
        transacao.setData(LocalDateTime.now());
        // Garantir que o objeto transação tenha os dados completos das contas
        transacao.setContaOrigem(origem);
        transacao.setContaDestino(destino);

        return transacaoRepository.salvar(transacao);
    }

    public List<Transacao> listar() {
        return transacaoRepository.listarTodas();
    }
}