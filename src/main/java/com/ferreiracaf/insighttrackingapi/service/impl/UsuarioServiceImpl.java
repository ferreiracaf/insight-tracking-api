package com.ferreiracaf.insighttrackingapi.service.impl;

import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.model.Usuario;
import com.ferreiracaf.insighttrackingapi.model.Usuario_;
import com.ferreiracaf.insighttrackingapi.repository.AtividadeRepository;
import com.ferreiracaf.insighttrackingapi.repository.UsuarioRepository;
import com.ferreiracaf.insighttrackingapi.repository.filter.AtividadeFilter;
import com.ferreiracaf.insighttrackingapi.service.AtividadeService;
import com.ferreiracaf.insighttrackingapi.service.UsuarioService;
import com.ferreiracaf.insighttrackingapi.service.exception.RecursoInexistenteException;
import com.ferreiracaf.insighttrackingapi.service.exception.UsuarioJaExistenteException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AtividadeService atividadeService;

    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario){
        if (!usuarioRepository.existsByCpf(usuario.getCpf()))
            return usuarioRepository.save(usuario);
        throw new UsuarioJaExistenteException();
    }

    public Usuario buscarUsuarioPorCpf(String cpf){
        Optional<Usuario> byId = usuarioRepository.findByCpf(cpf);
        if (byId.isPresent())
            return byId.get();
        throw new RecursoInexistenteException();
    }

    public Usuario atualizarUsuario(String cpf, Usuario usuario){
        Optional<Usuario> byId = usuarioRepository.findByCpf(cpf);
        if (byId.isPresent()){
            BeanUtils.copyProperties(usuario, byId.get(), Usuario_.CPF);
            return usuarioRepository.save(byId.get());
        }
        throw new RecursoInexistenteException();
    }

    @Transactional
    public void apagarUsuario(String cpf){
        Optional<Usuario> byId = usuarioRepository.findByCpf(cpf);
        if (byId.isPresent()) {
            List<Atividade> atividadesList = atividadeService.getAtividadesList();
            for (Atividade atividade: atividadesList){
                if (atividade.getUsuario().getCpf().equalsIgnoreCase(cpf))
                    atividadeService.removerAtividade(atividade.getId());
            }
            usuarioRepository.deleteByCpf(cpf);
        }
        else throw new EmptyResultDataAccessException(1);
    }
}
