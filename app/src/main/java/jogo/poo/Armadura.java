package jogo.poo;

public class Armadura {
    String nome;
    int nivel;

    public Armadura(String nome, int nivel) {
        this.nivel = nivel;
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getNivelDaProtecao() {
        return this.nivel;
    }

    public void setNivelDaProtecao(int nivel) {
        this.nivel = nivel;
    }
}
