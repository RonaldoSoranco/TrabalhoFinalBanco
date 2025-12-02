package br.com.cesurgmarau.bancos.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Compra {
    private Long id;
    private String descricao;
    private BigDecimal valor;
    private String tipoPagamento;
    private LocalDateTime dataHora;
    private Long contaId;


    public Compra(Long id, String descricao, BigDecimal valor, String tipoPagamento, Long contaId) {
        this.id = id;
        this.descricao = descricao;
        this.valor = valor;
        this.tipoPagamento = tipoPagamento;
        this.contaId = contaId;
        this.dataHora = LocalDateTime.now();
    }


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }
    public String getTipoPagamento() { return tipoPagamento; }
    public void setTipoPagamento(String tipoPagamento) { this.tipoPagamento = tipoPagamento; }
    public LocalDateTime getDataHora() { return dataHora; }
    public Long getContaId() { return contaId; }
    public void setContaId(Long contaId) { this.contaId = contaId; }
}