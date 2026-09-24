package br.com.fiap.f1.models;

public class Piloto {

    //ATRIUTOS
    private String nome;
    private int numero;
    private String equipe;
    private String nacionalidade;
    private double pontos;


    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEquipe() {
        return equipe;
    }

    public void setEquipe(String equipe) {
        this.equipe = equipe;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public double getPontos() {
        return pontos;
    }

    public void setPontos(double pontos) {
        this.pontos = pontos;
    }

    @Override
    public String toString() {
        return "Piloto: " + nome +
                " | Nº " + numero +
                " | Equipe: " + equipe +
                " | Nacionalidade: " + nacionalidade +
                " | Pontos: " + pontos;
    }
}