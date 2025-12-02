package br.com.cesurgmarau.bancos.controller;

import br.com.cesurgmarau.bancos.model.Conta;
import br.com.cesurgmarau.bancos.model.ContaCorrente;
import br.com.cesurgmarau.bancos.model.ContaCredito;
import br.com.cesurgmarau.bancos.model.ContaPoupanca;
import br.com.cesurgmarau.bancos.service.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contas")
public class ContaController {

    @Autowired
    private ContaService service;


    @PostMapping("/corrente")
    public Conta criarCorrente(@RequestBody ContaCorrente conta) {
        return service.criar(conta);
    }

    @PostMapping("/poupanca")
    public Conta criarPoupanca(@RequestBody ContaPoupanca conta) {
        return service.criar(conta);
    }

    @PostMapping("/credito")
    public Conta criarCredito(@RequestBody ContaCredito conta) {
        return service.criar(conta);
    }


    @GetMapping
    public List<Conta> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Conta> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public Conta atualizar(@PathVariable Long id, @RequestBody Conta conta) {
        conta.setId(id);
        return service.criar(conta);
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}