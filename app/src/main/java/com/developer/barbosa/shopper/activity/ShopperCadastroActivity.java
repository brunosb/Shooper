package com.developer.barbosa.shopper.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.developer.barbosa.shopper.R;

public class ShopperCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopper_cadastro);

    }

    public void cadastrar(View view){
        String nome = ((EditText)findViewById(R.id.etNome)).getText().toString();
        String endereco = ((EditText)findViewById(R.id.etEndereco)).getText().toString();
        String numero = ((EditText)findViewById(R.id.etNumeroEndereco)).getText().toString();
        String cep = ((EditText)findViewById(R.id.etCep)).getText().toString();
        String rg = ((EditText)findViewById(R.id.etRg)).getText().toString();
        String cpf = ((EditText)findViewById(R.id.etCpf)).getText().toString();

        if(!nome.equals("") || !endereco.equals("")){
            Toast toast = Toast.makeText(this,"Cadastrado com sucesso",Toast.LENGTH_SHORT);
            toast.show();
            Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
            intent.putExtra("codigo",getIntent().getStringExtra("codigo"));
            intent.putExtra("nomeVarejo",nome);
            intent.putExtra("endereco",endereco);
            intent.putExtra("numeroEndereco",numero);
            intent.putExtra("cep",cep);
            intent.putExtra("rg",rg);
            intent.putExtra("cpf",cpf);
            startActivity(intent);
        }else{
            Toast toast = Toast.makeText(this,"Não foi possivel realizar o cadastro",Toast.LENGTH_SHORT);
            toast.show();
        }
    }
}