package br.com.cesurgmarau.bancos.exception;

public class CountNotFoundException extends Exception{
    public CountNotFoundException (String mensagem){
            super (mensagem);
        }
        //Regra de negocio para conseguir realizar a operacao somente se a conta existir senoa vai dar erro
    }

