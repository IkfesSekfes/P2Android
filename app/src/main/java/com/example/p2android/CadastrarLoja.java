package com.example.p2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.p2android.model.Loja;
import com.example.p2android.table.LojaTB;


public class CadastrarLoja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_loja);

    }

    public void cadastrarLoja(View view) {
        Intent intent = new Intent(this, ConsultaLoja.class);
        EditText nomeLoja;
        EditText estadoLoja;
        EditText cidadeLoja;
        nomeLoja= findViewById(R.id.entrada_nomeLoja);
        estadoLoja = findViewById(R.id.entrada_nomeEstado);
        cidadeLoja = findViewById(R.id.entrada_nomeCidade);

        Loja loja = new Loja();
        loja.setNomeLoja(nomeLoja.getText().toString());
        loja.setEstado(estadoLoja.getText().toString());
        loja.setCidade(cidadeLoja.getText().toString());


        SQLiteOpenHelper dbHelper = new LojaTB.HardwareDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(LojaTB.StructureLojaTB.COLUMN_NAME_NOME, loja.getNomeLoja());
        values.put(LojaTB.StructureLojaTB.COLUMN_NAME_ESTADO, loja.getEstado());
        values.put(LojaTB.StructureLojaTB.COLUMN_NAME_CIDADE, loja.getCidade());

        long newRowId = db.insert(LojaTB.StructureLojaTB.TABLE_NAME, null, values);
        Toast.makeText(getApplicationContext(), "Cadastrado com Sucesso:"+newRowId, Toast.LENGTH_LONG).show();
        startActivity(intent);


    }
}