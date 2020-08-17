package com.ferreiracaf.insighttrackingapi.repository;

import com.ferreiracaf.insighttrackingapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCpf(String cpf);

    void deleteByCpf(String cpf);

    boolean existsByCpf(String cpf);

//    @Query("select u from Usuario u where u.nome like %:nome%")
//    Usuario buscarUsuarioPorNome(@Param("nome") String nome);
//    Usuario findByNomeContaining(String nome);

}
