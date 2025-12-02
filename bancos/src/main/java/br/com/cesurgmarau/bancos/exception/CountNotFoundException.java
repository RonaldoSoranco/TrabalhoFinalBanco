package br.com.cesurgmarau.bancos.exception;

public class CountNotFoundException extends RuntimeException{
    public CountNotFoundException (String mensagem){
            super (mensagem);
        }
    }

