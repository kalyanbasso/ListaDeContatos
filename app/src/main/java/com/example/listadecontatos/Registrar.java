package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class Registrar extends AppCompatActivity {

    private EditText usuario, senha, confirmaSenha;

    Banco db = new Banco(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        Button btnCancelar = findViewById(R.id.bt_cancelar);
        Button btnSalvar = findViewById(R.id.bt_salvar);
        usuario = findViewById(R.id.editUsuario);
        senha = findViewById(R.id.editSenha);
        confirmaSenha = findViewById(R.id.editConfirmSenha);

        btnCancelar.setOnClickListener(this::voltar);
        btnSalvar.setOnClickListener(this::handleRegistrar);
    }

    private void voltar(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    private void handleRegistrar(View view) {
        String editUsuario = usuario.getText().toString();
        String editSenha = senha.getText().toString();
        String editConfirmSenha = confirmaSenha.getText().toString();
        if(editUsuario.isEmpty() || editSenha.isEmpty() || editConfirmSenha.isEmpty()){
            Snackbar.make(view, "Usuário ou Senha ou Confirma está vazio", Snackbar.LENGTH_SHORT).show();
        } else if (!editSenha.equals(editConfirmSenha)) {
            Snackbar.make(view, "As senhas são diferentes " + editSenha + " " + editConfirmSenha, Snackbar.LENGTH_SHORT).show();
        } else {
            db.criaUsuario(editUsuario, editSenha);
            Snackbar.make(view, "Ola " + editUsuario, Snackbar.LENGTH_LONG).show();
        }
    }
}