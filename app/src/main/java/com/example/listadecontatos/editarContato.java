package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;

public class editarContato extends AppCompatActivity {

    Banco db = new Banco(this);

    private EditText nome, telefone;

    String id_user = "0";
    String _nome = "";
    String _telefone = "";
    String _id_contato = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_contato);

        nome = findViewById(R.id.editNome);
        telefone = findViewById(R.id.editTelefone);
        Button btnCancelar = findViewById(R.id.bt_cancelar);
        Button btnSalvar = findViewById(R.id.bt_salvar);

        id_user = getIntent().getStringExtra("id_user");
        _nome = getIntent().getStringExtra("nome");
        _telefone = getIntent().getStringExtra("telefone");
        _id_contato = getIntent().getStringExtra("id_contato");


        nome.setText(_nome);
        telefone.setText(_telefone);
        btnSalvar.setOnClickListener(this::handleEditar);

        btnCancelar.setOnClickListener(this::voltar);

    }

    private void voltar(View view) {
        Intent i = new Intent(getApplicationContext(), Contatos.class);
        i.putExtra("id_user", id_user);
        startActivity(i);
    }

    private void handleEditar(View view) {
        Snackbar.make(view, "nome = " + _nome + "tel = " + _telefone + "id_contat = " + _id_contato, Snackbar.LENGTH_SHORT).show();
        String editNome = nome.getText().toString();
        String editTelefone = telefone.getText().toString();
        if(editNome.isEmpty() || editTelefone.isEmpty()){
            Snackbar.make(view, "Nome ou Telefone está vazio", Snackbar.LENGTH_SHORT).show();
        }  else {
            db.atualizaContato(_id_contato, editNome, editTelefone);
            Snackbar.make(view, "SALVADO", Snackbar.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), Contatos.class);
            i.putExtra("id_user", id_user);
            startActivity(i);
        }
    }
}