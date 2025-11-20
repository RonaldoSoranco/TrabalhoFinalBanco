package br.com.cesurgmarau.bancos.service;

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
    private UsuarioRepository usuarioRepository; // Precisamos disso para validar o dono

    public Conta criar(Conta conta) {
        // --- VALIDAÇÃO 1: Verifica se mandaram o usuário ---
        if (conta.getUsuario() == null || conta.getUsuario().getId() == null) {
            throw new IllegalArgumentException("Para criar uma conta, é obrigatório informar o ID do Usuário!");
        }

        // --- VALIDAÇÃO 2: Verifica se o usuário existe no banco ---
        Optional<Usuario> usuarioExistente = usuarioRepository.buscarPorId(conta.getUsuario().getId());

        if (usuarioExistente.isEmpty()) {
            throw new IllegalArgumentException("Usuário não encontrado! Não é possível criar conta para um ID inexistente.");
        }

        // --- REGRA DE NEGÓCIO: Atualiza com os dados reais do usuário ---
        // Isso garante que a conta fique vinculada ao objeto certo na memória
        conta.setUsuario(usuarioExistente.get());

        // Salva a conta
        return contaRepository.salvar(conta);
    }

    public List<Conta> listar() {
        return contaRepository.listarTodas();
    }

    // Se precisar buscar conta por ID
    public Optional<Conta> buscarPorId(Long id) {
        return contaRepository.buscarPorId(id);
    }
}