package com.example.alexandre.exemplocalculadora;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intent = getIntent();
        String media = intent.getStringExtra("media");
        String mediana = intent.getStringExtra("mediana");
        String vetor = intent.getStringExtra("vetor");

        // VAMOS CASTEAR OS VALORES
        TextView lblMedia = (TextView) findViewById(R.id.lblMedia);
        TextView lblMediana = (TextView) findViewById(R.id.lblMediana);
        TextView lblVetor = (TextView) findViewById(R.id.lblVetorResultado);

        lblMedia.setText(media);
        lblMediana.setText(mediana);
        lblVetor.setText(vetor);
    }
}
