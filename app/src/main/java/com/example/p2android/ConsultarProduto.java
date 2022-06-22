package com.example.p2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.p2android.table.HardwareTB;


//Produto é o hardware, afinal uma loja de hardware, sendo o app para funcioinário

public class ConsultarProduto extends AppCompatActivity {
    ListView listView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_produto);
        setarSqlite();
    }
    private void setarSqlite() {
        HardwareTB.HardwareDbHelper hardwareTB = new HardwareTB.HardwareDbHelper(this);
        SQLiteOpenHelper dbHelper = new HardwareTB.HardwareDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] selectionArgs = {HardwareTB.StructureHardwareTB._ID,
                HardwareTB.StructureHardwareTB.COLUMN_NAME_NOMEPRODUTO,
                HardwareTB.StructureHardwareTB.COLUMN_NAME_TIPO,
                HardwareTB.StructureHardwareTB.COLUMN_NAME_MARCA,
                HardwareTB.StructureHardwareTB.COLUMN_NAME_PRECO};

        Cursor consulta = db.query(HardwareTB.StructureHardwareTB.TABLE_NAME, selectionArgs,  null, null, null, null, null);

        String[] listaProdutos = new String[consulta.getCount()];
        int i=0;

        while (consulta.moveToNext()) {
            listaProdutos[i] = "Produto "+i+"\n\nID do Produto: " + consulta.getString(0) + "\n\nNome do Produto: " + consulta.getString(1) +
                    "\n\nTipo do Produto: " + consulta.getString(2) +"\n\nMarca do Produto: " + consulta.getString(3) + "\n\nPreço do Produto: " + consulta.getString(4) ;

            i++;

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,listaProdutos);
        listView = (ListView)findViewById(R.id.text_view_produto);
        listView.setAdapter(arrayAdapter);


    }

        public void sair_produto(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}

