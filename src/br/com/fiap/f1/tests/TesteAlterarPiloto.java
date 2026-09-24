package br.com.fiap.f1.tests;

import br.com.fiap.f1.dao.PilotoDAO;
import br.com.fiap.f1.models.Piloto;

public class TesteAlterarPiloto {

    public static void main(String[] args) {

        Piloto piloto = new Piloto();

        piloto.setNome("Kimi Antonelli");
        piloto.setNumero(12);
        piloto.setEquipe("Mercedes");
        piloto.setNacionalidade("Italiano");
        piloto.setPontos(300);

        PilotoDAO dao = new PilotoDAO();

        dao.alterar(piloto);

        System.out.println("Piloto alterado com sucesso!");
    }
}