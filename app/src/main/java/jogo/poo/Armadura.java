package jogo.poo;

public class Armadura extends Item {
    private int nivel;

    public Armadura(String nome, int nivel) {
        super(nome);
        this.nivel = nivel;
    }

    public int getNivelDaProtecao() {
        return this.nivel;
    }

    public void setNivelDaProtecao(int nivel) {
        this.nivel = nivel;
    }
}
