package com.developer.barbosa.shopper.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.developer.barbosa.shopper.R;
import com.developer.barbosa.shopper.Utils.Pergunta;
import com.developer.barbosa.shopper.Utils.PerguntaAdapter;

import java.util.ArrayList;
import java.util.List;

public class PerguntasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perguntas);

        //Provisório - pergunta pra todos os modulos diferenciar com if else pegando pelo intent o id do moduloOk
        final List<Pergunta> perguntas = new ArrayList<>();
        perguntas.add(new Pergunta(1,"Quem veio primeiro, o ovo ou a galinha?","Ovo","Galinha","Ambos","Nenhum"));
        perguntas.add(new Pergunta(2,"Quem veio primeiro, o ovo ou a galinha?","Ovo","Galinha","Ambos","Nenhum"));
        perguntas.add(new Pergunta(3,"Quem veio primeiro, o ovo ou a galinha?","Ovo","Galinha","Ambos","Nenhum"));

        ListView lista = (ListView) findViewById(R.id.lvPerguntas);
        PerguntaAdapter adapter = new PerguntaAdapter(this,perguntas);

        lista.setAdapter(adapter);

    }

    private RadioButton module = null;

    public void enviar(){
        //Recuperar moduloOk
        Bundle modulo = getIntent().getExtras();
        int idModulo = (int) modulo.get("moduloOk");
        module = (RadioButton) findViewById(idModulo);
        //Recuperar dados do varejo
        String nome = (String) modulo.get("nomeVarejo");
        //Mostrar popup
        showPopup(nome,module.getText().toString());
    }

    private void showPopup(String varejo, String pontuacao) {

        String texto ="Nós do(a) "+varejo+" agradecemos suas respostas.\n\n\nVocê acaba de ganhar "+pontuacao+" para trocar por descontos ou produtos.";

        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.agradecimento_modulo,null);

        final PopupWindow popupWindow = new PopupWindow(popupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        popupWindow.setTouchable(false);
        popupWindow.setFocusable(true);

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);

        TextView agradecimento = (TextView) popupView.findViewById(R.id.txtAgredecimento);
        agradecimento.setText(texto);

        Button btnOk = (Button) popupView.findViewById(R.id.btnAgradecimentoOK);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Faz alteração da imagem do moduloOk
                module.setCompoundDrawablesWithIntrinsicBounds(null,getResources().getDrawable(R.drawable.ic_btn_trocar),null,null);
                //Redireciona para a tela de modulos
                Intent intent = new Intent(Intent.ACTION_VIEW);
                //fecha a janela
                popupWindow.dismiss();

                startActivity(intent);
            }
        });
    }

}
