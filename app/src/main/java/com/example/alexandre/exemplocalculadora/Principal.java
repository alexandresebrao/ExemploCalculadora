package com.example.alexandre.exemplocalculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    public Calculadora calculadora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculadora = new Calculadora();
        setContentView(R.layout.activity_principal);
    }

    public void adicionarNumero(View v) {
        EditText txtNumero = (EditText) findViewById(R.id.txtNumero);
        Integer numero = Integer.parseInt(txtNumero.getText().toString());
        calculadora.addNumero(numero);
        String resposta = "Numero " + numero.toString() + " adicionado com sucesso";
        Toast mensagem = Toast.makeText(this,resposta, Toast.LENGTH_LONG);
        mensagem.show();
        atualizaVetor();
    }

    public void removerNumero(View v) {
        EditText txtNumero = (EditText) findViewById(R.id.txtNumero);
        Integer numero = Integer.parseInt(txtNumero.getText().toString());
        String resposta;
        if  (calculadora.removeNumero(numero)) {
            resposta = "Numero " + numero.toString() + " removido com sucesso";
        }
        else
        {
            resposta = "Não temos este numero";
        }
        Toast mensagem = Toast.makeText(this,resposta, Toast.LENGTH_LONG);
        mensagem.show();
        atualizaVetor();
    }

    public void limpaVetor(View v) {
        calculadora.limparVetor();
        Toast mensagem = Toast.makeText(this, "Vetor limpo",Toast.LENGTH_SHORT);
        mensagem.show();
    }

    public void Resultado(View v) {
        if (calculadora.temNumeros()) {
            Intent intent = new Intent(this, Resultado.class);
            intent.putExtra("media", String.valueOf(calculadora.getMedia()));
            intent.putExtra("mediana", calculadora.getMediana().toString());
            intent.putExtra("vetor", calculadora.vetorString());
            startActivity(intent);
        }
        else {
            Toast mensagem = Toast.makeText(this, "Não temos nada em nosso vetor :(",Toast.LENGTH_SHORT);
            mensagem.show();
        }
    }

    private void atualizaVetor() {
        TextView vetor = (TextView) findViewById(R.id.lblVetor);
        vetor.setText(calculadora.vetorString());
    }
}
