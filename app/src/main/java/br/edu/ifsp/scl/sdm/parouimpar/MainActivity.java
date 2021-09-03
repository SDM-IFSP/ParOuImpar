package br.edu.ifsp.scl.sdm.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

import br.edu.ifsp.scl.sdm.parouimpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //ref
    private ActivityMainBinding activityMainBinding;

    //private RadioGroup opcaoRg;
    //private Button zeroBt, umBt, doisBt, tresBt, quartroBt, cincoBt;
    //private TextView resultadoTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        setContentView(activityMainBinding.getRoot());

//        activityMainBinding = findViewById(R.id.opcaoRg);
//        activityMainBinding = findViewById(R.id.zeroBt);
//        activityMainBinding = findViewById(R.id.umBt);
//        activityMainBinding = findViewById(R.id.doisBt);
//        activityMainBinding = findViewById(R.id.tresBt);
//        activityMainBinding = findViewById(R.id.quatroBt);
//        activityMainBinding = findViewById(R.id.cincoBt);
//        activityMainBinding = findViewById(R.id.resultadoTv);

//        activityMainBinding.zeroBt.setOnClickListener(this);
//        activityMainBinding.umBt.setOnClickListener(this);
//        activityMainBinding.doisBt.setOnClickListener(this);
//        activityMainBinding.tresBt.setOnClickListener(this);
//        activityMainBinding.quatroBt.setOnClickListener(this);
//        activityMainBinding.cincoBt.setOnClickListener(this);

        activityMainBinding.mostrarOpcao.setOnCheckedChangeListener((__, mostrarOpcoes) -> {
                activityMainBinding.selecionarOp.setVisibility(mostrarOpcoes?View.VISIBLE:View.GONE);
        });

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

        int imageJogadaComputadorId = -1;
        switch (jogadaComputador) {
            case 0:
                imageJogadaComputadorId = R.mipmap.zero;
                break;
            case 1:
                imageJogadaComputadorId = R.mipmap.one;
                break;
            case 2:
                imageJogadaComputadorId = R.mipmap.two;
                break;
            case 3:
                imageJogadaComputadorId = R.mipmap.three;
                break;
            case 4:
                imageJogadaComputadorId = R.mipmap.four;
                break;
            case 5:
                imageJogadaComputadorId = R.mipmap.five;
                break;
            default:
                break;
        }
        activityMainBinding.jogadaComputador.setImageResource((imageJogadaComputadorId));

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append("Sua Jogada: ");
        resultadoSb.append(jogada);

        resultadoSb.append(" , Computador");
        resultadoSb.append(jogadaComputador);

        if (activityMainBinding.opcaoRg.getCheckedRadioButtonId() == R.id.parRb){
            resultadoSb.append( (jogada + jogadaComputador) % 2 == 0? "Você ganhou!" : "Você Perdeu!");
        }
        else {
            resultadoSb.append( (jogada + jogadaComputador) % 2 == 0? "Você perdeu!" : "Você ganhou!");
        }

        activityMainBinding.resultadoTv.setText(resultadoSb.toString());
    }
}