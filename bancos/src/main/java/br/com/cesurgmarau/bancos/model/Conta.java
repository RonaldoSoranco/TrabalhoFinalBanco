package br.com.cesurgmarau.bancos.model;

import java.math.BigDecimal;


public abstract class Conta {

    private Long id;
    private String numero;
    private BigDecimal saldo;
    private Usuario usuario;

    public Conta() {
    }

    public Conta(Long id, String numero, BigDecimal saldo, Usuario usuario) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}