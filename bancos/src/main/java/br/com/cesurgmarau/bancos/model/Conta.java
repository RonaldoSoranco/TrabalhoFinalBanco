package br.com.cesurgmarau.bancos.model;

import br.com.cesurgmarau.bancos.exception.SaldoInsuficienteException;

public abstract class Conta {
    private Long id;
    private String agencia;
    private String numero;
    private Long usuarioId;

    protected double saldo;

    public Conta(Long id, String agencia, String numero, Long usuarioId, double saldo) {
        this.id = id;
        this.agencia = agencia;
        this.numero = numero;
        this.usuarioId = usuarioId;
        this.saldo = saldo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    //Regras de negócio dentro do pilar da encapsilacao

    public void creditar(double valor){
        if(valor <=0){throw new IllegalArgumentException("Valor deve ser positivo");}
        this.saldo +=valor;
    }
    public abstract void debitar(double valor)throws SaldoInsuficienteException;
}
