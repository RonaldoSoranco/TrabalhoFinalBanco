package br.com.cesurgmarau.bancos.model;

import br.com.cesurgmarau.bancos.exception.SaldoInsuficienteException;

public class ContaCredito extends Conta{
    private double limiteCredito;
    private double fatura;

    public ContaCredito(Long id,String agencia,String numero, Long usuarioId,double limiteCredito){
        super(id,agencia,numero,usuarioId,0);
        this.limiteCredito = limiteCredito;
        this.fatura = 0;
    }
    public double getLimiteCredito(){
        return  limiteCredito;
    }
    public double getFatura(){
        return fatura;
    }
    public void registrarCompra(double valor)throws SaldoInsuficienteException{
        if(valor <=0)throw new IllegalArgumentException("É necessário ter o valor positivo");
        if(fatura + valor > limiteCredito)
            throw new SaldoInsuficienteException("O limite de crédito foi excedido");

        fatura += valor;
    }
    @Override
    public void debitar(double valor) {
        throw new UnsupportedOperationException("Sua conta de crédito não permite débito direto");
    }
}
