package com.developer.barbosa.shopper.Utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.TextView;

import com.developer.barbosa.shopper.R;

import java.util.List;

/**
 * Created by Bruno Barbosa on 19/10/2016.
 */

public class PerguntaAdapter extends ArrayAdapter<Pergunta> {

    public PerguntaAdapter(Context context, List<Pergunta> lista) {
        super(context, 0, lista);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View perguntaView = convertView;
        if (perguntaView == null){
            perguntaView = LayoutInflater.from(getContext()).inflate(R.layout.pergunta,parent,false);
        }

        Pergunta pergunta = getItem(position);

        TextView numeroQuestao = (TextView) perguntaView.findViewById(R.id.txtNumeroQuestao);
        numeroQuestao.setText(pergunta.getNumero());

        TextView questao = (TextView) perguntaView.findViewById(R.id.txtQuestao);
        questao.setText(pergunta.getPergunta());

        RadioButton r1 = (RadioButton) perguntaView.findViewById(R.id.rbR1);
        r1.setText(pergunta.getResposta1());
        RadioButton r2 = (RadioButton) perguntaView.findViewById(R.id.rbR2);
        r2.setText(pergunta.getResposta2());
        RadioButton r3 = (RadioButton) perguntaView.findViewById(R.id.rbR3);
        r3.setText(pergunta.getResposta3());
        RadioButton r4 = (RadioButton) perguntaView.findViewById(R.id.rbR4);
        r4.setText(pergunta.getResposta4());

        return perguntaView;
    }
}
