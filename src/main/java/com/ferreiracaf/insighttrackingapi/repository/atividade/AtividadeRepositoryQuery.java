package com.ferreiracaf.insighttrackingapi.repository.atividade;

import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.repository.filter.AtividadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AtividadeRepositoryQuery {
    Page<Atividade> filtrar(AtividadeFilter atividadeFilter, Pageable pageable);
}