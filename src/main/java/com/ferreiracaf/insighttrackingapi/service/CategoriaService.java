package com.ferreiracaf.insighttrackingapi.service;

import com.ferreiracaf.insighttrackingapi.model.Categoria;

import java.util.List;

public interface CategoriaService {

    List<Categoria> listarTodos();

    Categoria buscarPorCodigo(Long id);

    Categoria criarCategoria(Categoria categoria);

    Categoria atualizarCategoria(Long id, Categoria categoria);

    void removerCategoria(Long id);
}
