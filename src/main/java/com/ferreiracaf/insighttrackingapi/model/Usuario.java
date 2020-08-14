package com.ferreiracaf.insighttrackingapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "usuario")
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

//    @OneToMany(mappedBy = "usuario")
//    private List<Atividade> atividades;

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
