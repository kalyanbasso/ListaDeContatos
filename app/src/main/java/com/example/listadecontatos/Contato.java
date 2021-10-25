package com.example.listadecontatos;

public class Contato {

    int id;
    String nome;
    String telefone;

    public Contato() {

    }

    public Contato(int _id, String _nome, String _telefone) {
        this.id = _id;
        this.nome = _nome;
        this.telefone = _telefone;
    }

    public Contato(String _nome, String _telefone) {
        this.nome = _nome;
        this.telefone = _telefone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
