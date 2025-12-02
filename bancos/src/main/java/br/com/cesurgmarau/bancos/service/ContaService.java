package br.com.cesurgmarau.bancos.service;

import br.com.cesurgmarau.bancos.exception.UsuarioNotFoundException;
import br.com.cesurgmarau.bancos.model.Conta;
import br.com.cesurgmarau.bancos.model.Usuario;
import br.com.cesurgmarau.bancos.repository.ContaRepository;
import br.com.cesurgmarau.bancos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContaService {

    @Autowired
    private ContaRepository contaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Conta criar(Conta conta) {

        if (conta.getUsuario() == null || conta.getUsuario().getId() == null) {
            throw new IllegalArgumentException("É obrigatório informar o ID do Usuário!");
        }

        Optional<Usuario> usuarioExistente = usuarioRepository.buscarPorId(conta.getUsuario().getId());
        if (usuarioExistente.isEmpty()) {
            throw new UsuarioNotFoundException("Usuário não encontrado!");
        }


        conta.setUsuario(usuarioExistente.get());

        return contaRepository.salvar(conta);
    }

    public List<Conta> listar() {
        return contaRepository.listarTodas();
    }

    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.buscarPorId(id);
    }

    public void deletar(Long id) {
        contaRepository.deletar(id);
    }
}