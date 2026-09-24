package br.com.fiap.f1.tests;

import br.com.fiap.f1.models.Piloto;

public class TestePiloto {

    public static void main(String[] args) {

        Piloto piloto = new Piloto();

        piloto.setNome("Kimi Antonelli");
        piloto.setNumero(12);
        piloto.setEquipe("Mercedes");
        piloto.setNacionalidade("Italiano");
        piloto.setPontos(292);

        System.out.println(piloto);
    }
}