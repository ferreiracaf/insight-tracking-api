package com.ferreiracaf.insighttrackingapi.dto;

import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.model.Endereco;
import com.ferreiracaf.insighttrackingapi.model.Usuario;
import com.ferreiracaf.insighttrackingapi.utils.NullProperties;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsuarioDTO {

    public String cpf;
    public String nome;
    public Endereco endereco;
    public String email;
    public String telefone;
    public List<AtividadeDTO> atividades;

    public UsuarioDTO(Usuario usuario) {
        this.cpf = usuario.getCpf();
        this.nome = usuario.getNome();
        this.endereco = usuario.getEndereco();
        this.email = usuario.getEmail();
        this.telefone = usuario.getTelefone();
        this.atividades = new ArrayList<>();
        usuario.getAtividades().stream().filter(atividade -> atividade.getDescricao().length() >= 10).forEach(atividade -> {
            this.atividades.add(new AtividadeDTO(atividade));
        });
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<AtividadeDTO> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<AtividadeDTO> atividades) {
        this.atividades = atividades;
    }
}
