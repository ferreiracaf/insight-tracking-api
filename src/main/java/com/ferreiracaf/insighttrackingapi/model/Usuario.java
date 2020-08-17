package com.ferreiracaf.insighttrackingapi.model;

import com.fasterxml.jackson.annotation.JsonView;
import com.ferreiracaf.insighttrackingapi.view.Views;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "usuario")
@JsonView(Views.UsuarioAtividades.class)
public class Usuario {

    @Id
    @NotNull
    private String cpf;
    @NotNull
    private String nome;
    @Embedded
    private Endereco endereco;
    @NotNull
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.EAGER)
    private List<Atividade> atividades;

    public Usuario() {
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

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return cpf.equals(usuario.cpf) &&
                nome.equals(usuario.nome) &&
                Objects.equals(endereco, usuario.endereco) &&
                email.equals(usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, nome, endereco, email);
    }
}
