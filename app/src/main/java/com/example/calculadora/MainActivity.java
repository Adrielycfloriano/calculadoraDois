package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView text;
    TextView edt1;
    TextView edt2;
    Button btn0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;
    Button btnvir;
    Button dividir;
    Button multiplicacao;
    Button menos;
    Button mais;
    Button clear;
    Button next;
    String preenche = "";
    String apagar = "";
    float resultado;
    boolean proximo;
    boolean bloquear;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        text = findViewById(R.id.text);
        edt1 = findViewById(R.id.edt1);
        edt2 = findViewById(R.id.edt2);
        btn0 = findViewById(R.id.btn0);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btnvir = findViewById(R.id.btnvir);
        dividir = findViewById(R.id.dividir);
        multiplicacao = findViewById(R.id.multiplicacao);
        mais = findViewById(R.id.mais);
        menos = findViewById(R.id.menos);
        clear = findViewById(R.id.clear);
        next = findViewById(R.id.next);
        estadoBotao(false);

        btnvir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            CharSequence virgula = btnvir.getText();
            preencheCalculadora(virgula);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                proximo = true;
                preenche = "";
                estadoBotao(true);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetar();


            }
        });
        mais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacaoSoma();

            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacaoSubtracao();
            }
        });
        multiplicacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacaoMultiplicacao();
            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacaoDivisao();
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence zero = btn0.getText();
                preencheCalculadora(zero);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence um = btn1.getText();
                preencheCalculadora(um);


            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence dois = btn2.getText();
                preencheCalculadora(dois);

            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence tres = btn3.getText();
                preencheCalculadora(tres);

            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence quatro = btn4.getText();
                preencheCalculadora(quatro);

            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence cinco = btn5.getText();
                preencheCalculadora(cinco);

            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence seis = btn6.getText();
                preencheCalculadora(seis);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence sete = btn7.getText();
                preencheCalculadora(sete);

            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence oito = btn8.getText();
                preencheCalculadora(oito);

            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence nove = btn9.getText();
                preencheCalculadora(nove);
            }
        });
    }

    private void operacaoSoma() {
        resultado = 0;
        text.setText("0.0");
        resultado = Float.parseFloat(edt1.getText().toString()) + Float.parseFloat(edt2.getText().toString());
        text.setText(String.valueOf(resultado));
    }

    private void resetar() {
        apagar = "";
        preenche = "";
        proximo = false;
        edt1.setText(apagar);
        edt2.setText(apagar);
        text.setText(apagar);
    }

    private void operacaoSubtracao() {
        resultado = 0;
        vibrar();
        text.setText("0.0");
        resultado = Float.parseFloat(edt2.getText().toString()) - Float.parseFloat(edt1.getText().toString());
        text.setText(String.valueOf(resultado));
    }

    private void operacaoMultiplicacao() {
        resultado = 0;
        vibrar();
        text.setText("0.0");
        resultado = Float.parseFloat(edt2.getText().toString()) * Float.parseFloat(edt1.getText().toString());
        text.setText(String.valueOf(resultado));
    }

    private void operacaoDivisao() {
        resultado = 0;
        vibrar();
        text.setText("0.0");
        resultado = Float.parseFloat(edt2.getText().toString()) / Float.parseFloat(edt1.getText().toString());
        text.setText(String.valueOf(resultado));
    }

    private void preencheCalculadora(CharSequence texto) {
        preenche = preenche + texto;
        vibrar();
        if(!proximo){
            edt1.setText(preenche);
        }else{
            edt2.setText(preenche);
        }

    }
    private void vibrar (){
        Vibrator rr = (Vibrator)  getSystemService(Context.VIBRATOR_SERVICE);
        long duration = 80;
        if (rr != null) {
            rr.vibrate (duration);
        }
    }
    private void estadoBotao (boolean estado){
        mais.setEnabled(estado);
        menos.setEnabled(estado);
        dividir.setEnabled(estado);
        multiplicacao.setEnabled(estado);

    }

}