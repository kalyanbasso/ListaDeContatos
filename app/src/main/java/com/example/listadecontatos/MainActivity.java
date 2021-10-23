package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText usuario, senha;

    Banco db = new Banco(this);


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
        } else {
            Snackbar.make(view, "TENTANDO LOGAR " + editUsuario + " e " + editSenha, Snackbar.LENGTH_SHORT).show();
            Usuario user = db.login(editUsuario, editSenha);
            Log.d("AAAAA", user.getId() + " " + user.getUsuario() + " " + user.getSenha() + " " );
            Snackbar.make(view, "Ola " + user.getUsuario(), Snackbar.LENGTH_LONG).show();
        }
    }
}