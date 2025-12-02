package br.com.cesurgmarau.bancos.repository;

import br.com.cesurgmarau.bancos.model.Compra;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class CompraRepository {
    private final List<Compra> compras = new ArrayList<>();
    private final AtomicLong idCounter = new AtomicLong(0);

    public void salvar(Compra compra) {
        compra.setId(idCounter.incrementAndGet());
        compras.add(compra);
    }

    public List<Compra> listarTodas() {
        return new ArrayList<>(compras);
    }
}