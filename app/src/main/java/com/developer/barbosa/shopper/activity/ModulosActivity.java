package com.developer.barbosa.shopper.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;

import com.developer.barbosa.shopper.R;

public class ModulosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modulos);

        final Button responder = (Button) findViewById(R.id.btnResponder);
        responder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rgModulos);

                int modulo = radioGroup.getCheckedRadioButtonId();

                Intent intent = new Intent(ModulosActivity.this, PerguntasActivity.class);
                intent.putExtras(getIntent().getExtras());
                intent.putExtra("moduloOk", modulo);
                startActivity(intent);
            }
        });
    }
}

