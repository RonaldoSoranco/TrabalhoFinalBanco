package br.com.cesurgmarau.model;

import java.time.LocalDateTime;

public class Transacao {

    private Long id;
    private Long contaOrigemId;
    private Long contaDestinoId;
    private double valor;
    private LocalDateTime dataHora;

    public Transacao(Long id, Long contaOrigemId, Long contaDestinoId, double valor, LocalDateTime dataHora) {
        this.id = id;
        this.contaOrigemId = contaOrigemId;
        this.contaDestinoId = contaDestinoId;
        this.valor = valor;
        this.dataHora = dataHora;
    }
    public Long getId(){return id;}
    public Long getContaOrigemId(){return contaOrigemId;}
    public Long getContaDestinoId(){return contaDestinoId;}
    public double getValor(){return valor;}
    public LocalDateTime getDataHora(){return dataHora;}

}
