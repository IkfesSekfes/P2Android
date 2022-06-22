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

import com.example.p2android.model.ProdutoHardware;
import com.example.p2android.table.HardwareTB;


public class CadastrarProduto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_produto);
    }


    public void cadastrarHardware(View view) {
        Intent intent = new Intent(this, ConsultarProduto.class);
        EditText nomePro;
        EditText tipoPro;
        EditText marcaPro;
        EditText precoPro;
        nomePro= findViewById(R.id.entrada_nomeProduto);
        tipoPro = findViewById(R.id.entrada_tipoProduto);
        marcaPro = findViewById(R.id.entrada_marcaProduto);
        precoPro = findViewById(R.id.entrada_precoProduto);

        ProdutoHardware produtoHardware = new ProdutoHardware();

        produtoHardware.setNomeProduto(nomePro.getText().toString());
        produtoHardware.setTipoProduto(tipoPro.getText().toString());
        produtoHardware.setMarcaProduto(marcaPro.getText().toString());
        produtoHardware.setPrecoProduto(Double.parseDouble(precoPro.getText().toString()));



        SQLiteOpenHelper dbHelper = new HardwareTB.HardwareDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(HardwareTB.StructureHardwareTB.COLUMN_NAME_NOMEPRODUTO, produtoHardware.getNomeProduto());
        values.put(HardwareTB.StructureHardwareTB.COLUMN_NAME_MARCA, produtoHardware.getMarcaProduto());
        values.put(HardwareTB.StructureHardwareTB.COLUMN_NAME_TIPO, produtoHardware.getTipoProduto());
        values.put(HardwareTB.StructureHardwareTB.COLUMN_NAME_PRECO, produtoHardware.getPrecoProduto());

        long newRowId = db.insert(HardwareTB.StructureHardwareTB.TABLE_NAME, null, values);
        Toast.makeText(getApplicationContext(), "Cadastrado com Sucesso:"+newRowId, Toast.LENGTH_LONG).show();
        startActivity(intent);

    }
}