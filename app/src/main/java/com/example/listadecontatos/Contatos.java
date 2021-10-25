package com.example.listadecontatos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Contatos extends AppCompatActivity {

    Banco db = new Banco(this);
    String id_user = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatos);
        id_user = getIntent().getStringExtra("id_user");

        FloatingActionButton btnAdicionar = findViewById(R.id.btn_adicionar);

        ListView lista = (ListView) findViewById(R.id.lista);
        List<Contato> contatos = todosOsContatos();
        ArrayAdapter<Contato> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, contatos);
        lista.setAdapter(adapter);
        btnAdicionar.setOnClickListener(this::handleAdicionar);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public  void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar.make(view, contatos.get(i).getNome() , Snackbar.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), Detalhes.class);
                intent.putExtra("id_contato", Integer.toString(contatos.get(i).getId()));
                intent.putExtra("id_user", id_user);
                intent.putExtra("nome", contatos.get(i).getNome());
                intent.putExtra("telefone", contatos.get(i).getTelefone());
                startActivity(intent);
            }
        });

    }

    private void handleAdicionar(View view) {
        Intent i = new Intent(getApplicationContext(), NovoContato.class);
        i.putExtra("id_user", id_user);
        startActivity(i);
    }

    private List<Contato> todosOsContatos() {
        return db.getContatos(id_user);
    }
}