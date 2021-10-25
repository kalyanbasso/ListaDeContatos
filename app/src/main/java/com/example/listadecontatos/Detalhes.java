package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

public class Detalhes extends AppCompatActivity {

    Banco db = new Banco(this);

    private TextView nome, telefone;

    String _nome = "";
    String _telefone = "";
    String _id_user = "";
    String _id_contato = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        nome = findViewById(R.id.textNome);
        telefone = findViewById(R.id.textTelefone);

        _id_user = getIntent().getStringExtra("id_user");
        _nome = getIntent().getStringExtra("nome");
        _telefone = getIntent().getStringExtra("telefone");
        _id_contato = getIntent().getStringExtra("id_contato");

        nome.setText(_nome);
        telefone.setText(_telefone);

        Button btnVoltar = findViewById(R.id.bt_voltar);
        Button btnEditar = findViewById(R.id.bt_editar);
        Button btnExcluir = findViewById(R.id.bt_exluir);

        btnVoltar.setOnClickListener(this::voltar);
        btnEditar.setOnClickListener(this::handleEditar);
        btnExcluir.setOnClickListener(this::handleDelete);
    }

    private void voltar(View view) {
        Intent i = new Intent(getApplicationContext(), Contatos.class);
        i.putExtra("id_user", _id_user);
        startActivity(i);
    }

    private void handleEditar(View view) {
        Snackbar.make(view, "handleEditar" , Snackbar.LENGTH_LONG).show();
        Intent i = new Intent(getApplicationContext(), editarContato.class);
        i.putExtra("nome", _nome);
        i.putExtra("telefone", _telefone);
        i.putExtra("id_contato", _id_contato);
        i.putExtra("id_user", _id_user);
        startActivity(i);
    }

    private void handleDelete(View view) {
        Snackbar.make(view, "handleDelete" , Snackbar.LENGTH_LONG).show();
        db.deleteContato(_id_contato);
        Intent i = new Intent(getApplicationContext(), Contatos.class);
        i.putExtra("id_user", _id_user);
        startActivity(i);
    }
}