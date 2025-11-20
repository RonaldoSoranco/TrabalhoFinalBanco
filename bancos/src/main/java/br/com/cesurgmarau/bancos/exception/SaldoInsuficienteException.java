package br.com.cesurgmarau.bancos.exception;

public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException (String mensagem){
        super (mensagem);
        //regra de negocio que vai ser aplicada quando o usuario tentar debitar um valor maior
        //de que o saldo que ele tiver em conta.(mensagem de erro)
    }
}
