package br.com.fiap.f1.tests;

import br.com.fiap.f1.dao.ConnectionFactory;

public class TesteConexao {
    public static void main(String[] args) {
        System.out.println("Testando conexão com o banco...");

        if (ConnectionFactory.obterConexao() == null) {
            System.out.println("Erro na conexão.");
        } else {
            System.out.println("Conexão realizada com sucesso!");
        }
    }
}
