package br.edu.ifsp.scl.sdm.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //ref
    private RadioGroup opcaoRg;
    private Button zeroBt, umBt, doisBt, tresBt, quartroBt, cincoBt;
    private TextView resultadoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcaoRg = findViewById(R.id.opcaoRg);
        zeroBt = findViewById(R.id.zeroBt);
        umBt = findViewById(R.id.umBt);
        doisBt = findViewById(R.id.doisBt);
        tresBt = findViewById(R.id.tresBt);
        quartroBt = findViewById(R.id.quatroBt);
        cincoBt = findViewById(R.id.cincoBt);
        resultadoTv = findViewById(R.id.resultadoTv);

        zeroBt.setOnClickListener(this);
        umBt.setOnClickListener(this);
        doisBt.setOnClickListener(this);
        tresBt.setOnClickListener(this);
        quartroBt.setOnClickListener(this);
        cincoBt.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int jogada = -1;
        switch (view.getId()) {
            case R.id.zeroBt:
                jogada = 0;
                break;
            case R.id.umBt:
                jogada = 1;
                break;
            case R.id.doisBt:
                jogada = 2;
                break;
            case R.id.tresBt:
                jogada = 3;
                break;
            case R.id.quatroBt:
                jogada = 4;
                break;
            case R.id.cincoBt:
                jogada = 5;
                break;
        }
        jogarParOuImpar(jogada);
    }
    private void jogarParOuImpar(int jogada){
        Random random = new Random((System.currentTimeMillis()));
        int jogadaComputador = random.nextInt(6);

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append("Sua Jogada: ");
        resultadoSb.append(jogada);

        resultadoSb.append(" , Computador");
        resultadoSb.append(jogadaComputador);

        if (opcaoRg.getCheckedRadioButtonId() == R.id.parRb){
            resultadoSb.append( (jogada + jogadaComputador) % 2 == 0? "Você ganhou!" : "Você Perdeu!");
        }
        else {
            resultadoSb.append( (jogada + jogadaComputador) % 2 == 0? "Você perdeu!" : "Você ganhou!");
        }

        resultadoTv.setText(resultadoSb.toString());
    }
}