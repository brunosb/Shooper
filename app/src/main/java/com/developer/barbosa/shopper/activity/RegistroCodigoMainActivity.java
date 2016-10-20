package com.developer.barbosa.shopper.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.developer.barbosa.shopper.R;

public class RegistroCodigoMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_codigo);

        Button btnVerificar = (Button) findViewById(R.id.btnVerificar);

        final EditText txtCodigo = (EditText) findViewById(R.id.txtCodigo);

        btnVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ShopperCadastroActivity.class);
                intent.putExtra("codigo",txtCodigo.getText().toString());
                startActivity(intent);
            }
        });

    }

}
