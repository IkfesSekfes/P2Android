package com.example.p2android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 //eu até fiz uma tela de login, mas devido a falta de tempo não implementei, arquivo no readme se ficar curioso
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



   public void login(View view) {


        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }


    public void cadastrar(View view) {
        Intent intent = new Intent(this, CadastrarFuncionario.class);
        startActivity(intent);
    }
}