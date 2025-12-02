package br.com.cesurgmarau.bancos.model;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    private BigDecimal limite;

    public ContaCorrente() {
        super();
    }

    public ContaCorrente(Long id, String numero, BigDecimal saldo, Usuario usuario, BigDecimal limite) {
        super(id, numero, saldo, usuario);
        this.limite = limite;
    }


    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}