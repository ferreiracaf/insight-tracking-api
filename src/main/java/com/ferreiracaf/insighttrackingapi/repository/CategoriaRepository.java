package com.ferreiracaf.insighttrackingapi.repository;

import com.ferreiracaf.insighttrackingapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
