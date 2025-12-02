package br.com.cesurgmarau.bancos.controller;

import br.com.cesurgmarau.bancos.dto.CompraDTO;
import br.com.cesurgmarau.bancos.model.Compra;
import br.com.cesurgmarau.bancos.service.CompraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraService service;

    @PostMapping
    public ResponseEntity<String> realizarCompra(@RequestBody CompraDTO compra) {
        try {
            String resultado = service.processarCompra(compra);
            return ResponseEntity.ok(resultado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public List<Compra> listarHistorico() {
        return service.listarCompras();
    }
}