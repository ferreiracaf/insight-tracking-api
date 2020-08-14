package com.ferreiracaf.insighttrackingapi.service;

import com.ferreiracaf.insighttrackingapi.model.Usuario;

import java.util.List;

public interface UsuarioService {

    List<Usuario> listarTodos();

    Usuario salvarUsuario(Usuario usuario);

    Usuario buscarUsuarioPorCpf(String cpf);

    Usuario atualizarUsuario(String cpf, Usuario usuario);

    void apagarUsuario(String cpf);
}
