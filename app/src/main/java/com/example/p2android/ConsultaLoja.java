package com.example.p2android;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.p2android.table.LojaTB;

import java.util.ArrayList;

public class ConsultaLoja extends AppCompatActivity {
   ListView listView = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_loja);
        setarSqlite();


    }
    private void setarSqlite() {
        LojaTB.HardwareDbHelper lojaTB = new LojaTB.HardwareDbHelper(this);
        SQLiteOpenHelper dbHelper = new LojaTB.HardwareDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String[] selectionArgs = {LojaTB.StructureLojaTB._ID,
                LojaTB.StructureLojaTB.COLUMN_NAME_NOME,
                LojaTB.StructureLojaTB.COLUMN_NAME_ESTADO,
                LojaTB.StructureLojaTB.COLUMN_NAME_CIDADE};

       Cursor consulta = db.query(LojaTB.StructureLojaTB.TABLE_NAME, selectionArgs,  null, null, null, null, null);


       String[] listaNomes = new String[consulta.getCount()];
        int i=0;

        while (consulta.moveToNext()) {
            listaNomes[i] = "Loja "+i +"\n\nID da loja: " + consulta.getString(0) + "\n\nNome: " +consulta.getString(1) + "\n\nEstado: "
                    + consulta.getString(2) + "\n\nCidade: " + consulta.getString(3);

            i++;

        }




        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 ,listaNomes);
        listView = (ListView)findViewById(R.id.text_view_loja);
        listView.setAdapter(arrayAdapter);


    }





    }
