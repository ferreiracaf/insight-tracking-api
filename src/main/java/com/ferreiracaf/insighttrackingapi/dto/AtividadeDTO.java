package com.ferreiracaf.insighttrackingapi.dto;

import com.ferreiracaf.insighttrackingapi.model.Atividade;
import com.ferreiracaf.insighttrackingapi.model.Categoria;
import com.ferreiracaf.insighttrackingapi.utils.NullProperties;
import org.springframework.beans.BeanUtils;

public class AtividadeDTO {

    public Long id;
    public String nome;
    public String descricao;
    public String observacao;
    public Categoria categoria;
    public String cpf_usuario;

    public AtividadeDTO(Atividade atividade) {
        this.id = atividade.getId();
        this.nome = atividade.getNome();
        this.descricao = atividade.getDescricao();
        this.observacao = atividade.getObservacao();
        this.categoria = atividade.getCategoria();
        this.cpf_usuario = atividade.getUsuario().getCpf();
    }

    private String[] checkNullProperties(String[] nullProperties){
        if (nullProperties.length == 0){
            return new String[]{"usuario"};
        }
        else {
            nullProperties[nullProperties.length] = " usuario";
            return nullProperties;
        }
    }

    public String getCpf_usuario() {
        return cpf_usuario;
    }

    public void setCpf_usuario(String cpf_usuario) {
        this.cpf_usuario = cpf_usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
