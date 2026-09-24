package br.com.fiap.f1.dao;

import br.com.fiap.f1.models.Piloto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PilotoDAO {

    private Connection conexao;

    //METODOS | O CRUD ACONTECE AQUI

    //Cadastrar
    public void cadastrar(Piloto piloto) {

        conexao = ConnectionFactory.obterConexao();

        PreparedStatement comandoSql = null;

        try {

            String sql = """
                    INSERT INTO TBL_PILOTO_F1
                    (NOME, NUMERO, EQUIPE, NACIONALIDADE, PONTOS)
                    VALUES (?, ?, ?, ?, ?)
                    """;

            comandoSql = conexao.prepareStatement(sql);

            comandoSql.setString(1, piloto.getNome());
            comandoSql.setInt(2, piloto.getNumero());
            comandoSql.setString(3, piloto.getEquipe());
            comandoSql.setString(4, piloto.getNacionalidade());
            comandoSql.setDouble(5, piloto.getPontos());

            comandoSql.executeUpdate();

            comandoSql.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Buscar
    public Piloto buscarPorNumero(int numero) {

        conexao = ConnectionFactory.obterConexao();

        PreparedStatement comandoSql = null;
        Piloto piloto = new Piloto();

        try {

            String sql = """
                    SELECT * FROM TBL_PILOTO_F1
                    WHERE NUMERO = ?
                    """;

            comandoSql = conexao.prepareStatement(sql);

            comandoSql.setInt(1, numero);

            ResultSet resultado = comandoSql.executeQuery();

            if (resultado.next()) {

                piloto.setNome(resultado.getString("NOME"));
                piloto.setNumero(resultado.getInt("NUMERO"));
                piloto.setEquipe(resultado.getString("EQUIPE"));
                piloto.setNacionalidade(resultado.getString("NACIONALIDADE"));
                piloto.setPontos(resultado.getDouble("PONTOS"));
            }

            resultado.close();
            comandoSql.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return piloto;
    }

    //Listar
    public List<Piloto> listar() {

        conexao = ConnectionFactory.obterConexao();

        PreparedStatement comandoSql = null;
        List<Piloto> pilotos = new ArrayList<>(); //Cria lista que pode guardar vários pilotos

        try {

            String sql = "SELECT * FROM TBL_PILOTO_F1";

            comandoSql = conexao.prepareStatement(sql);

            ResultSet resultado = comandoSql.executeQuery();

            while (resultado.next()) {

                Piloto piloto = new Piloto();

                piloto.setNome(resultado.getString("NOME"));
                piloto.setNumero(resultado.getInt("NUMERO"));
                piloto.setEquipe(resultado.getString("EQUIPE"));
                piloto.setNacionalidade(resultado.getString("NACIONALIDADE"));
                piloto.setPontos(resultado.getDouble("PONTOS"));

                pilotos.add(piloto);
            }

            resultado.close();
            comandoSql.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return pilotos;
    }

    //Alterar
    public void alterar(Piloto piloto) {

        conexao = ConnectionFactory.obterConexao();

        PreparedStatement comandoSql = null;

        try {

            String sql = """
                UPDATE TBL_PILOTO_F1
                SET NOME = ?,
                    EQUIPE = ?,
                    NACIONALIDADE = ?,
                    PONTOS = ?
                WHERE NUMERO = ?
                """;

            comandoSql = conexao.prepareStatement(sql);

            comandoSql.setString(1, piloto.getNome());
            comandoSql.setString(2, piloto.getEquipe());
            comandoSql.setString(3, piloto.getNacionalidade());
            comandoSql.setDouble(4, piloto.getPontos());
            comandoSql.setInt(5, piloto.getNumero());

            comandoSql.executeUpdate();

            comandoSql.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Excluir
    public void excluir(int numero) {

        conexao = ConnectionFactory.obterConexao();

        PreparedStatement comandoSql = null;

        try {

            String sql = """
                DELETE FROM TBL_PILOTO_F1
                WHERE NUMERO = ?
                """;

            comandoSql = conexao.prepareStatement(sql);

            comandoSql.setInt(1, numero);

            comandoSql.executeUpdate();

            comandoSql.close();
            conexao.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}