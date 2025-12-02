package br.com.cesurgmarau.bancos.exception;

public class UsuarioNotFoundException extends RuntimeException{
    public UsuarioNotFoundException (String mensagem){
        super(mensagem);
    }
}
