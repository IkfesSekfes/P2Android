package com.example.p2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Consultar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);
    }

    public void hardware_consultar(View view) {
        Intent intent = new Intent(this, ConsultarProduto.class);
        startActivity(intent);
    }

    public void loja_consultar(View view) {
        Intent intent = new Intent(this, ConsultaLoja.class);
        startActivity(intent);

    }

    public void voltar_menu(View view) {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }
}