package com.example.p2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void consultarMenu(View view) {
        Intent intent = new Intent(this, Consultar.class);
        startActivity(intent);
    }

    public void cadastrar_loja(View view) {
        Intent intent = new Intent(this, CadastrarLoja.class);
        startActivity(intent);
    }

    public void cadastrar_produto(View view) {
        Intent intent = new Intent(this, CadastrarProduto.class);
        startActivity(intent);
    }

    public void sairMenu(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}