package br.com.cesurgmarau.bancos.model;

import br.com.cesurgmarau.bancos.exception.SaldoInsuficienteException;

public class ContaPoupanca extends Conta {
    private double taxadeJuros;

    public ContaPoupanca (Long id, String agencia, String numero,Long usuarioId, double saldoInicial, double taxadeJuros){
        super(id,agencia,numero,usuarioId,saldoInicial);
        this.taxadeJuros = taxadeJuros;
    }

    public double getTaxadeJuros(){
        return taxadeJuros;
    }

    @Override
    public void debitar (double valor)throws SaldoInsuficienteException {
        if (valor <= 0) throw new IllegalArgumentException("Valor deve ser positivo");
        if (saldo < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente na poupanca.");
        }

        saldo -=valor;
        }

}
