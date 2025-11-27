package br.com.cesurgmarau.bancos.dto;

public class ContaRequest {

    private String numero;
    private long UsuarioId;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public long getUsuarioId() {
        return UsuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        UsuarioId = usuarioId;
    }
}
