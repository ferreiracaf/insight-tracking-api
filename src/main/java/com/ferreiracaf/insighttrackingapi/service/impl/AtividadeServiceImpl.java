package com.ferreiracaf.insighttrackingapi.service.impl;

import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.model.Atividade_;
import com.ferreiracaf.insighttrackingapi.repository.AtividadeRepository;
import com.ferreiracaf.insighttrackingapi.repository.filter.AtividadeFilter;
import com.ferreiracaf.insighttrackingapi.service.AtividadeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AtividadeServiceImpl implements AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Override
    public Page<Atividade> listarTodos(AtividadeFilter atividadeFilter, Pageable pageable) {
        return atividadeRepository.filtrar(atividadeFilter, pageable);
    }

    public List<Atividade> getAtividadesList(){
        return atividadeRepository.findAll();
    }

    @Override
    public Atividade buscarPorCodigo(Long id) {
        Optional<Atividade> byId = atividadeRepository.findById(id);
        if (byId.isPresent())
            return byId.get();
        throw new EmptyResultDataAccessException(1);
    }

    @Override
    public Atividade criarAtividade(Atividade atividade) {
        return atividadeRepository.save(atividade);
    }

    @Override
    public Atividade atualizarAtividade(Long id, Atividade atividade) {
        Optional<Atividade> byId = atividadeRepository.findById(id);
        if (byId.isPresent()){
            BeanUtils.copyProperties(atividade, byId.get(), Atividade_.ID);
            return atividadeRepository.save(byId.get());
        }
        throw new EmptyResultDataAccessException(1);
    }

    @Override
    public void removerAtividade(Long id) {
        atividadeRepository.deleteById(id);
    }
}
