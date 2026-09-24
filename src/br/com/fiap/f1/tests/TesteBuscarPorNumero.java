package br.com.fiap.f1.tests;

import br.com.fiap.f1.dao.PilotoDAO;
import br.com.fiap.f1.models.Piloto;

public class TesteBuscarPorNumero {
    public static void main(String[] args) {

        PilotoDAO dao = new PilotoDAO();

        Piloto piloto = dao.buscarPorNumero(12);

        System.out.println(piloto);
    }
}
