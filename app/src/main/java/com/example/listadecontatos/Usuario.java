package com.example.listadecontatos;

public class Usuario {

    int id;
    String usuario;
    String senha;

    public Usuario() {

    }

    public Usuario(int _id, String _usuario, String _senha) {
        this.id = _id;
        this.usuario = _usuario;
        this.senha = _senha;
    }

    public Usuario(String _usuario, String _senha) {
        this.usuario = _usuario;
        this.senha = _senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
