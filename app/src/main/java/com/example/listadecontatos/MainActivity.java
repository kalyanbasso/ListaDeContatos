package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        Button btnRegistrar = findViewById(R.id.bt_registrar);
        usuario = findViewById(R.id.editUsuario);
        senha = findViewById(R.id.editSenha);

        btnLogin.setOnClickListener(this::handleLogin);
        btnRegistrar.setOnClickListener(this::handleRegistrar);
    }

    private void handleRegistrar(View view) {
        Intent i = new Intent(getApplicationContext(), Registrar.class);
        startActivity(i);
    }

    private void handleLogin(View view) {
        String editUsuario = usuario.getText().toString();
        String editSenha = senha.getText().toString();
        if(editUsuario.isEmpty() || editSenha.isEmpty()){
            Snackbar.make(view, "Usuário ou Senha vazio", Snackbar.LENGTH_SHORT).show();
        } else {
            Usuario user = db.login(editUsuario, editSenha);
            Snackbar.make(view, "Ola " + user.getUsuario() + " " + user.getId() , Snackbar.LENGTH_LONG).show();

            if(user.getId() != 0){
                Intent i = new Intent(getApplicationContext(), Contatos.class);
                i.putExtra("id_user", Integer.toString(user.getId()));
                Snackbar.make(view, "saindo " +  user.getId(), Snackbar.LENGTH_LONG).show();
                startActivity(i);
            } else {
                Snackbar.make(view, "Usuário ou senha incorretos" , Snackbar.LENGTH_LONG).show();
            }

        }
    }
}