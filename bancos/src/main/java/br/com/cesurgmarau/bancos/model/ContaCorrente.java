package br.com.cesurgmarau.bancos.model;

import br.com.cesurgmarau.bancos.exception.SaldoInsuficienteException;

public class ContaCorrente extends Conta{
    private double limite;

    public ContaCorrente(Long id,String agencia, String numero, Long usuarioId,double saldoInicial, double limite){
        super(id,agencia,numero,usuarioId,saldoInicial);
        this.limite = limite;
    }
    public double getLimite(){
        return limite;
    }
    @Override
    public void debitar(double valor)throws SaldoInsuficienteException{
        if(valor <=0)throw new IllegalArgumentException("O valor deve ser positivo!");
        if(saldo + limite <valor){
            throw new SaldoInsuficienteException("Saldo + limite insuficiente!!");
        }
        this.saldo-=valor;
    }
}
