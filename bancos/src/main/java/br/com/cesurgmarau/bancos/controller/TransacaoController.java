package br.com.cesurgmarau.bancos.controller;

import br.com.cesurgmarau.bancos.model.Transacao;
import br.com.cesurgmarau.bancos.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes") // URL: http://localhost:8080/transacoes
public class TransacaoController {

    @Autowired
    private TransacaoService service;

    // Fazer uma transferência (POST)
    @PostMapping
    public Transacao transferir(@RequestBody Transacao transacao) {
        return service.realizarTransacao(transacao);
    }

    // Ver o histórico de transações (GET)
    @GetMapping
    public List<Transacao> listar() {
        return service.listar();
    }
}