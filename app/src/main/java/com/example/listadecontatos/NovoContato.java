package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class NovoContato extends AppCompatActivity {

    private EditText nome, telefone;

    Banco db = new Banco(this);

    String id_user = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novo_contato);

        nome = findViewById(R.id.editNome);
        telefone = findViewById(R.id.editTelefone);
        Button btnCancelar = findViewById(R.id.bt_cancelar);
        Button btnSalvar = findViewById(R.id.bt_salvar);


        id_user = getIntent().getStringExtra("id_user");
        nome.setText(id_user);
        btnCancelar.setOnClickListener(this::voltar);
        btnCancelar.setOnClickListener(this::handleSalvar);
    }

    private void voltar(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }

    private void handleSalvar(View view) {
        String editNome = nome.getText().toString();
        String editTelefone = telefone.getText().toString();
        if(editNome.isEmpty() || editTelefone.isEmpty()){
            Snackbar.make(view, "Nome ou Telefone está vazio", Snackbar.LENGTH_SHORT).show();
        }  else {
            db.criaContato(editNome, editTelefone, id_user);
        }
    }
}