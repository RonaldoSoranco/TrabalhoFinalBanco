package br.com.cesurgmarau.bancos.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransacaoResponse {

    private Long id;

    private BigDecimal valor;

    private LocalDateTime data;

    private String contaOrigemNumero;

    private String contaDestinoNumero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getContaOrigemNumero() {
        return contaOrigemNumero;
    }

    public void setContaOrigemNumero(String contaOrigemNumero) {
        this.contaOrigemNumero = contaOrigemNumero;
    }

    public String getContaDestinoNumero() {
        return contaDestinoNumero;
    }

    public void setContaDestinoNumero(String contaDestinoNumero) {
        this.contaDestinoNumero = contaDestinoNumero;
    }
}
