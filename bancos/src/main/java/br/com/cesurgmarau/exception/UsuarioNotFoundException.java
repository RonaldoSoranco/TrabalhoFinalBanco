package br.com.cesurgmarau.exception;

public class UsuarioNotFoundException extends Exception{
    public UsuarioNotFoundException (String mensagem){
        super(mensagem);
        //Regra de negócio para caso tentar procurar um usuario que nao existe
    }
}
