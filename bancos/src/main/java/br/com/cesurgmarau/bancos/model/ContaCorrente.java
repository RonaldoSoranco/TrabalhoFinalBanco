package br.com.cesurgmarau.bancos.model;

import java.math.BigDecimal;

public class ContaCorrente extends Conta {

    private BigDecimal limite;

    public ContaCorrente() {
        super();
    }

    // Construtor atualizado para receber BigDecimal e Usuario
    public ContaCorrente(Long id, String numero, BigDecimal saldo, Usuario usuario, BigDecimal limite) {
        super(id, numero, saldo, usuario);
        this.limite = limite;
    }

    // SE VOCÊ TIVER MÉTODOS COM @OVERRIDE, ELES PRECISAM USAR BIGDECIMAL AGORA

    // Exemplo: Se você sobrescrevia o setSaldo, apague ou atualize para:
    /*
    @Override
    public void setSaldo(BigDecimal saldo) {
        super.setSaldo(saldo);
    }
    */

    public BigDecimal getLimite() {
        return limite;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}