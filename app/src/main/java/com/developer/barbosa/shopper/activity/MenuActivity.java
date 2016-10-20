package com.developer.barbosa.shopper.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.developer.barbosa.shopper.R;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void responderPerguntas(View view){
        Intent intent = new Intent(this,ModulosActivity.class);
        intent.putExtras(getIntent().getExtras());
        startActivity(intent);
    }

    public void trocarPontos(View view){
        Intent intent = new Intent(this,TrocaPontosActivity.class);
        intent.putExtras(getIntent().getExtras());
        startActivity(intent);
    }
}
