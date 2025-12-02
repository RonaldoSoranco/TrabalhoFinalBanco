package br.com.cesurgmarau.bancos.model;

import java.math.BigDecimal;

public class ContaCredito extends Conta {

    private BigDecimal limiteCredito;

    public ContaCredito() {
        super();
    }

    public ContaCredito(Long id, String numero, BigDecimal saldo, Usuario usuario, BigDecimal limiteCredito) {
        super(id, numero, saldo, usuario);
        this.limiteCredito = limiteCredito;
    }

    public BigDecimal getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(BigDecimal limiteCredito) {
        this.limiteCredito = limiteCredito;
    }
}