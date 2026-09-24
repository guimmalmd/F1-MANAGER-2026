package br.com.fiap.f1.tests;

import br.com.fiap.f1.dao.PilotoDAO;

public class TesteExcluirPiloto {
    public static void main(String[] args) {
        PilotoDAO dao = new PilotoDAO();

        dao.excluir(11);

        System.out.println("Piloto excluído com sucesso!");
    }
}
