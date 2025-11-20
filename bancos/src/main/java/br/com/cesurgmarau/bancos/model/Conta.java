package br.com.cesurgmarau.bancos.model;

import java.math.BigDecimal;

public class Conta {

    private Long id;
    private String numero;
    private BigDecimal saldo;
    private Usuario usuario;

    // 1. Construtor Vazio (Obrigatório)
    public Conta() {
    }

    // 2. Construtor Novo (O Jeito Certo)
    public Conta(Long id, String numero, BigDecimal saldo, Usuario usuario) {
        this.id = id;
        this.numero = numero;
        this.saldo = saldo;
        this.usuario = usuario;
    }

    // 3. CONSTRUTOR DE COMPATIBILIDADE (CORRIGE O SEU ERRO)
    // Este construtor aceita os 5 parâmetros antigos e converte para o novo formato
    public Conta(Long id, String numero, String tipoIgnorado, Long idUsuario, double saldoDouble) {
        this.id = id;
        this.numero = numero;
        // Converte o double antigo para BigDecimal
        this.saldo = BigDecimal.valueOf(saldoDouble);

        // Cria um usuário temporário só com o ID para não dar erro
        this.usuario = new Usuario();
        this.usuario.setId(idUsuario);
    }

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    public Usuario getUsuario() { return usuario; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
}