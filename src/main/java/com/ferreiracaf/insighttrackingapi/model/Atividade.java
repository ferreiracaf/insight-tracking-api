package com.ferreiracaf.insighttrackingapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ferreiracaf.insighttrackingapi.view.Views;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "atividade")
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonView(Views.UsuarioAtividades.class)
    private Long id;

    @NotNull
//    @JsonView(Views.UsuarioAtividades.class)
    private String nome;

//    @JsonView(Views.UsuarioAtividades.class)
    private String descricao;

//    @JsonView(Views.UsuarioAtividades.class)
    private String observacao;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "id_categoria")
//    @JsonView(Views.UsuarioAtividades.class)
    private Categoria categoria;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "cpf_usuario")
    private Usuario usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long codigo) {
        this.id = codigo;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atividade atividade = (Atividade) o;
        return id.equals(atividade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
