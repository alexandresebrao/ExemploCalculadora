package com.example.alexandre.exemplocalculadora;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by xandizitxu on 29/09/16.
 */

public class Calculadora {
    private ArrayList<Integer> numeros;
    private int tamanho;
    private float media;

    public Calculadora(){
        numeros = new ArrayList<Integer>();
        tamanho = 0;
    }

    public void addNumero(Integer numero) {
        numeros.add(numero);
        tamanho = tamanho + 1;
        Collections.sort(numeros);
        calcularMedia();
    }

    public boolean removeNumero(Integer numero){
        if (numeros.remove(numero)) {
            tamanho = tamanho -1;
            return true;
        }
        else
        {
            return false;
        }
    }

    public float getMedia()
    {
        return media;
    }

    public Integer getMediana() {
        return numeros.get(tamanho/2);
    }

    public boolean temNumeros() {
        if (tamanho > 0) {
            return true;
        } else {
            return false;
        }
    }

    public void limparVetor() {
        numeros = new ArrayList<Integer>();
    }


    public String vetorString() {
        StringBuilder resposta = new StringBuilder();
        for (Integer valor : numeros) {
            resposta.append(valor.toString()).append(" ");
        }
        return resposta.toString();
    }

    private void calcularMedia() {
        media = 0;
        for (Integer valor : numeros) {
            media += valor;
        }
        media = media/tamanho;
    }
}
