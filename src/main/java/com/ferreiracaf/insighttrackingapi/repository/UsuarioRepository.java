package com.ferreiracaf.insighttrackingapi.repository;

import com.ferreiracaf.insighttrackingapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);

    void deleteByCpf(String cpf);

    boolean existsByCpf(String cpf);
}
