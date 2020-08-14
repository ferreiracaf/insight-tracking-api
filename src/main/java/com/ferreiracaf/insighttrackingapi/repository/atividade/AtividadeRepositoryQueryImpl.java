package com.ferreiracaf.insighttrackingapi.repository.atividade;

import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.model.Atividade_;
import com.ferreiracaf.insighttrackingapi.repository.filter.AtividadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class AtividadeRepositoryQueryImpl implements AtividadeRepositoryQuery{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Atividade> filtrar(AtividadeFilter atividadeFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Atividade> criteria = builder.createQuery(Atividade.class);
        Root<Atividade> root = criteria.from(Atividade.class);

        //criar as restrições
        Predicate[] predicates = criarRestricoes(atividadeFilter, builder, root);
        criteria.where(predicates);

        TypedQuery<Atividade> query = manager.createQuery(criteria);

        adicionarRestricaoDePaginacao(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(atividadeFilter));
    }

    private Predicate[] criarRestricoes(AtividadeFilter atividadeFilter, CriteriaBuilder builder, Root<Atividade> root) {
        List<Predicate> predicates = new ArrayList<>();
        if (!StringUtils.isEmpty(atividadeFilter.getNome())){
            predicates.add(builder.like(
                    builder.lower(root.get(Atividade_.NOME)), "%" + atividadeFilter.getNome().toLowerCase() + "%"
            ));
        }
        if (!StringUtils.isEmpty(atividadeFilter.getDescricao())) {
            predicates.add(builder.like(
                    builder.lower(root.get(Atividade_.DESCRICAO)), "%" + atividadeFilter.getDescricao().toLowerCase() + "%"
            ));
        }
        return predicates.toArray(new Predicate[predicates.size()]);
    }

    private void adicionarRestricaoDePaginacao(TypedQuery<Atividade> query, Pageable pageable) {
        int paginaAtual = pageable.getPageNumber();
        int totalRegistrosPorPagina = pageable.getPageSize();
        int primeiroRegistroPagina = paginaAtual * totalRegistrosPorPagina;

        query.setFirstResult(primeiroRegistroPagina);
        query.setMaxResults(totalRegistrosPorPagina);
    }

    private Long total(AtividadeFilter atividadeFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();
        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
        Root<Atividade> root = criteria.from(Atividade.class);

        Predicate[] predicates = criarRestricoes(atividadeFilter, builder, root);
        criteria.where(predicates);

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }
}
