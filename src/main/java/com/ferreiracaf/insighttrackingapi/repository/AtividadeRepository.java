package com.ferreiracaf.insighttrackingapi.repository;

import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.repository.atividade.AtividadeRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>, AtividadeRepositoryQuery {
}
