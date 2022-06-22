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

import com.example.p2android.model.Funcionario;
import com.example.p2android.table.FuncionarioTB;

public class CadastrarFuncionario extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_funcionario);




    }

    public void confirmarCardastro(View view) {
        Intent intent = new Intent(this, Menu.class);
        EditText usuarioFun;
        EditText nomeFun;
        EditText sobrenomeFun;
        EditText idadeFun;
        EditText senhaFun;
        usuarioFun = findViewById(R.id.entrada_usuarioFuncionario);
        nomeFun = findViewById(R.id.entrada_nomeFuncionario);
        sobrenomeFun = findViewById(R.id.entrada_sobrenomeFuncioario);
        idadeFun = findViewById(R.id.entrada_idadeFuncionario);
        senhaFun = findViewById(R.id.entrada_senhaFuncionario);

        Funcionario funcionario = new Funcionario();

        funcionario.setUsuario(usuarioFun.getText().toString());
        funcionario.setNome(nomeFun.getText().toString());
        funcionario.setSobrenome(sobrenomeFun.getText().toString());
        funcionario.setIdade(Integer.parseInt(idadeFun.getText().toString()));
        funcionario.setSenha(senhaFun.getText().toString());

        SQLiteOpenHelper dbHelper = new FuncionarioTB.HardwareDbHelper(this);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_USUARIO, funcionario.getUsuario());
        values.put(FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_NOME, funcionario.getNome());
        values.put(FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_SOBRENOME, funcionario.getSobrenome());
        values.put(FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_IDADE, funcionario.getIdade());
        values.put(FuncionarioTB.StructureFuncionarioTB.COLUMN_NAME_SENHA, funcionario.getSenha());

        long newRowId = db.insert(FuncionarioTB.StructureFuncionarioTB.TABLE_NAME, null, values);
        Toast.makeText(getApplicationContext(), "Cadastrado com Sucesso:"+newRowId, Toast.LENGTH_LONG).show();
        startActivity(intent);



    }

    public void sairTelaCadastro(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}