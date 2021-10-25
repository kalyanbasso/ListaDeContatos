package com.example.listadecontatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Banco  extends SQLiteOpenHelper{

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_AGENDA = "banco_agenda";

    public Banco(Context context) {
        super(context, BANCO_AGENDA, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY = "CREATE TABLE usuario ( id INTEGER PRIMARY KEY AUTOINCREMENT, usuario TEXT, senha TEXT )";
        db.execSQL(QUERY);
        QUERY = "CREATE TABLE contatos (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT, telefone TEXT, id_usar INTEGER)";
        db.execSQL(QUERY);
        QUERY = "INSERT INTO usuario (usuario, senha) VALUES ('kalyan', '123')";
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    void addUsuario(Usuario usuario) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("usuario", usuario.getUsuario());
        values.put("senha", usuario.getSenha());

        db.insert("usuario", null, values);
        db.close();
    }

    Usuario login(String usuario,String  senha) {
        SQLiteDatabase db = this.getReadableDatabase();

        Usuario response = new Usuario();

        String selectQuery = "SELECT id, usuario, senha FROM usuario WHERE usuario = ? AND senha = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[] { usuario, senha });

        if(cursor.moveToFirst()){
            response.setId(cursor.getInt(0));
            response.setUsuario(cursor.getString(1));
            response.setSenha(cursor.getString(2));
        }
        cursor.close();

        return response;
    }

    void criaUsuario(String usuario, String senha) {
        SQLiteDatabase db = this.getReadableDatabase();
        String QUERY = "INSERT INTO usuario (usuario, senha) VALUES (?, ?)";
        db.execSQL(QUERY, new String[] {usuario, senha});

    }

    void criaContato(String nome, String telefone, String id_user) {
        SQLiteDatabase db = this.getReadableDatabase();
        String QUERY = "INSERT INTO usuario (nome, telefone, id_user) VALUES (?, ?, ?)";
        db.execSQL(QUERY, new String[] {nome, telefone, id_user});
    }

}
