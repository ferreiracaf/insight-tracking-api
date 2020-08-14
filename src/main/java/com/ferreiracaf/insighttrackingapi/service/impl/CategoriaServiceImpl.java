package com.ferreiracaf.insighttrackingapi.service.impl;

import com.ferreiracaf.insighttrackingapi.model.Categoria;
import com.ferreiracaf.insighttrackingapi.model.Categoria_;
import com.ferreiracaf.insighttrackingapi.repository.CategoriaRepository;
import com.ferreiracaf.insighttrackingapi.service.CategoriaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> listarTodos() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria buscarPorCodigo(Long id) {
        Optional<Categoria> byId =categoriaRepository.findById(id);
        if (byId.isPresent())
            return byId.get();
        throw new EmptyResultDataAccessException(1);
    }

    @Override
    public Categoria criarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public Categoria atualizarCategoria(Long id, Categoria categoria) {
        Optional<Categoria> byId = categoriaRepository.findById(id);
        if (byId.isPresent()){
            BeanUtils.copyProperties(categoria, byId.get(), Categoria_.ID);
            return categoriaRepository.save(byId.get());
        }
        throw new EmptyResultDataAccessException(1);
    }

    @Override
    public void removerCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }
}
