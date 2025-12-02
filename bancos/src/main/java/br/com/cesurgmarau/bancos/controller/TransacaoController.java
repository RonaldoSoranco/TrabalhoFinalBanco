package br.com.cesurgmarau.bancos.controller;

import br.com.cesurgmarau.bancos.model.Transacao;
import br.com.cesurgmarau.bancos.service.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    private TransacaoService service;


    @PostMapping
    public Transacao transferir(@RequestBody Transacao transacao) {
        return service.realizarTransacao(transacao);
    }


    @GetMapping
    public List<Transacao> listar() {
        return service.listar();
    }
}