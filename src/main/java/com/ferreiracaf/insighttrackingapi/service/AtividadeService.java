package com.ferreiracaf.insighttrackingapi.service;

import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.repository.filter.AtividadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface AtividadeService {

    Page<Atividade> listarTodos(AtividadeFilter atividadeFilter, Pageable pageable);

    List<Atividade> getAtividadesList();

    Atividade buscarPorCodigo(Long id);

    Atividade criarAtividade(Atividade atividade);

    Atividade atualizarAtividade(Long id, Atividade atividade);

    void removerAtividade(Long id);
}
