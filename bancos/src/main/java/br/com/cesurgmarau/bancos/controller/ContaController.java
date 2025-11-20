package br.com.cesurgmarau.bancos.controller;

import br.com.cesurgmarau.bancos.model.Conta;
import br.com.cesurgmarau.bancos.model.ContaCorrente;
import br.com.cesurgmarau.bancos.model.ContaCredito;
import br.com.cesurgmarau.bancos.model.ContaPoupanca;
import br.com.cesurgmarau.bancos.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService service;

    // --- ESSES SÃO OS NOVOS ENDEREÇOS QUE FALTAM ---

    @PostMapping("/corrente") // http://localhost:8080/contas/corrente
    public Conta criarCorrente(@RequestBody ContaCorrente conta) {
        return service.criar(conta);
    }

    @PostMapping("/poupanca") // http://localhost:8080/contas/poupanca
    public Conta criarPoupanca(@RequestBody ContaPoupanca conta) {
        return service.criar(conta);
    }

    @PostMapping("/credito") // http://localhost:8080/contas/credito
    public Conta criarCredito(@RequestBody ContaCredito conta) {
        return service.criar(conta);
    }

    // Listar todas
    @GetMapping
    public List<Conta> listar() {
        return service.listar();
    }
}