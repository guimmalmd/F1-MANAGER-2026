package br.com.fiap.f1.tests;

import br.com.fiap.f1.dao.PilotoDAO;
import br.com.fiap.f1.models.Piloto;

import java.util.List;

public class TesteListarPilotos {
    public static void main(String[] args) {
        PilotoDAO dao = new PilotoDAO();

        List<Piloto> pilotos = dao.listar(); //Busca todos no banco

        pilotos.forEach(System.out::println); //Imprime cada piloto
    }
}
