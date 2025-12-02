package br.com.cesurgmarau.bancos.exception;

public class SaldoInsuficienteException extends RuntimeException {
    public SaldoInsuficienteException (String mensagem){
        super (mensagem);
    }
}
