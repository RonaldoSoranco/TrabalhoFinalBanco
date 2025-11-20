package br.com.cesurgmarau.bancos.model;

import java.math.BigDecimal;

public class ContaPoupanca extends Conta {

    private BigDecimal taxaRendimento;

    // Construtor Vazio
    public ContaPoupanca() {
        super();
    }

    // Construtor Completo
    public ContaPoupanca(Long id, String numero, BigDecimal saldo, Usuario usuario, BigDecimal taxaRendimento) {
        super(id, numero, saldo, usuario);
        this.taxaRendimento = taxaRendimento;
    }

    // Getters e Setters
    public BigDecimal getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(BigDecimal taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}