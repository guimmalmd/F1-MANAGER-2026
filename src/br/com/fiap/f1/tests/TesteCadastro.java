package br.com.fiap.f1.tests;

import br.com.fiap.f1.dao.PilotoDAO;
import br.com.fiap.f1.models.Piloto;

public class TesteCadastro {
    public static void main(String[] args) {

        Piloto piloto = new Piloto();

        piloto.setNome("Sergio Perez");
        piloto.setNumero(11);
        piloto.setEquipe("Cadillac");
        piloto.setNacionalidade("Mexicano");
        piloto.setPontos(0);

        PilotoDAO dao = new PilotoDAO();

        dao.cadastrar(piloto);

        System.out.println("Piloto cadastrado com sucesso!");
    }
}
