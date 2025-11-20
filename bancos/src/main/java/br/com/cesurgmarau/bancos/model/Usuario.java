package br.com.cesurgmarau.bancos.model;

public class Usuario {

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;//CPF deve ser unico para cada usuario.

    public Usuario(Long id, String nome, String sobrenome, String cpf){
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        //construtores para poder sobreescrever os atributos de cada usuario
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
