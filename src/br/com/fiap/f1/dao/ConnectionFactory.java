package br.com.fiap.f1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    //METODO
    public static Connection obterConexao() { //Retorna uma conexão pronta para outras classes usarem

        Connection conexao = null;

        try {
            conexao = DriverManager.getConnection( //Fala para o Java abrir uma conexão com o banco utilizando esses dados inseridos.
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    "RM571713",
                    "250807"
            );

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conexao;
    }
}
