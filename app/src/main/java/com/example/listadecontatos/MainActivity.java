package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, senha;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = findViewById(R.id.bt_login);
        usuario = findViewById(R.id.editUsuario);
        senha = findViewById(R.id.editSenha);

        btnLogin.setOnClickListener(this::handleLogin);
    }

    private void handleLogin(View view) {
        String editUsuario = usuario.getText().toString();
        String editSenha = senha.getText().toString();
        if(editUsuario.isEmpty() || editSenha.isEmpty()){
            Snackbar.make(view, "Usuário ou Senha vazio", Snackbar.LENGTH_SHORT).show();
        }
    }
}