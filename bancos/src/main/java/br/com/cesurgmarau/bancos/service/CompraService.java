package br.com.cesurgmarau.bancos.service;

import br.com.cesurgmarau.bancos.dto.CompraDTO;
import br.com.cesurgmarau.bancos.exception.CountNotFoundException;
import br.com.cesurgmarau.bancos.exception.SaldoInsuficienteException;
import br.com.cesurgmarau.bancos.model.Compra;
import br.com.cesurgmarau.bancos.model.Conta;
import br.com.cesurgmarau.bancos.model.ContaCredito;
import br.com.cesurgmarau.bancos.repository.CompraRepository;
import br.com.cesurgmarau.bancos.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompraService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private CompraRepository compraRepository;

    public String processarCompra(CompraDTO dto) {
        Optional<Conta> contaOpt = contaRepository.buscarPorId(dto.getContaId());
        if (contaOpt.isEmpty()) {
            throw new CountNotFoundException("Conta não encontrada!");
        }
        Conta conta = contaOpt.get();

        if ("DEBITO".equalsIgnoreCase(dto.getTipoPagamento())) {
            if (conta.getSaldo().compareTo(dto.getValor()) < 0) {
                throw new SaldoInsuficienteException("Saldo insuficiente!");
            }
            conta.setSaldo(conta.getSaldo().subtract(dto.getValor()));
            contaRepository.salvar(conta);
        }

        else if ("CREDITO".equalsIgnoreCase(dto.getTipoPagamento())) {
            if (!(conta instanceof ContaCredito)) {
                throw new IllegalArgumentException("Conta não aceita crédito!");
            }
            ContaCredito cartao = (ContaCredito) conta;


            if (cartao.getLimiteCredito().compareTo(dto.getValor()) < 0) {
                throw new IllegalArgumentException("Limite insuficiente!");
            }


            cartao.setLimiteCredito(cartao.getLimiteCredito().subtract(dto.getValor()));
            contaRepository.salvar(cartao);
        } else {
            throw new IllegalArgumentException("Tipo inválido!");
        }


        Compra novaCompra = new Compra(
                null,
                dto.getDescricao(),
                dto.getValor(),
                dto.getTipoPagamento(),
                dto.getContaId()
        );
        compraRepository.salvar(novaCompra);

        return "Compra realizada com sucesso!";
    }

    public List<Compra> listarCompras() {
        return compraRepository.listarTodas();
    }
}