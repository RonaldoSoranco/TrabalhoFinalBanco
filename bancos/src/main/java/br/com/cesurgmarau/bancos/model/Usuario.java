package br.com.cesurgmarau.bancos.model;

public class Usuario {

    private Long id;
    private String nome;
    private String sobrenome; // Mantive seu sobrenome
    private String cpf;
    private String email; // <--- ADICIONADO (Faltava isso para o erro do setEmail sumir)

    // --- 1. CONSTRUTOR VAZIO (ESSENCIAL) ---
    // Resolve o erro: "Expected 4 arguments but found 0"
    public Usuario() {
    }

    // --- 2. CONSTRUTOR COMPLETO (Opcional, mas bom ter) ---
    public Usuario(Long id, String nome, String sobrenome, String cpf, String email) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
    }

    // --- GETTERS E SETTERS ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSobrenome() { return sobrenome; }
    public void setSobrenome(String sobrenome) { this.sobrenome = sobrenome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    // Getters e Setters do Email (Necessários para o erro sumir)
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}