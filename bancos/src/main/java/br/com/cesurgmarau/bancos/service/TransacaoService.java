package br.com.cesurgmarau.bancos.service;

import br.com.cesurgmarau.bancos.exception.CountNotFoundException;
import br.com.cesurgmarau.bancos.exception.SaldoInsuficienteException;
import br.com.cesurgmarau.bancos.model.Conta;
import br.com.cesurgmarau.bancos.model.Transacao;
import br.com.cesurgmarau.bancos.repository.ContaRepository;
import br.com.cesurgmarau.bancos.repository.TransacaoRepository;
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

        if (transacao.getValor().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("O valor da transação deve ser maior que zero!");
        }


        Optional<Conta> origemOpt = contaRepository.buscarPorId(transacao.getContaOrigem().getId());
        Optional<Conta> destinoOpt = contaRepository.buscarPorId(transacao.getContaDestino().getId());

        if (origemOpt.isEmpty() || destinoOpt.isEmpty()) {
            throw new CountNotFoundException("Conta de origem ou destino não encontrada!");
        }

        Conta origem = origemOpt.get();
        Conta destino = destinoOpt.get();


        if (origem.getSaldo().compareTo(transacao.getValor()) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar a transação!");
        }



        origem.setSaldo(origem.getSaldo().subtract(transacao.getValor()));

        destino.setSaldo(destino.getSaldo().add(transacao.getValor()));


        contaRepository.salvar(origem);
        contaRepository.salvar(destino);


        transacao.setData(LocalDateTime.now());

        transacao.setContaOrigem(origem);
        transacao.setContaDestino(destino);

        return transacaoRepository.salvar(transacao);
    }

    public List<Transacao> listar() {
        return transacaoRepository.listarTodas();
    }
}