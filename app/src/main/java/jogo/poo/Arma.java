package jogo.poo;

public class Arma {
    private String nome;
    private int dano;
    private int manaGasto;

    public Arma(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
    }
    public Arma(String nome, int dano, int manaGasto) {
        this.nome = nome;
        this.dano = dano;
        this.manaGasto = manaGasto;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDano() {
        return this.dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    public int getManaGasto() {
        return this.manaGasto;
    }

    public void setManaGasto(int manaGasto) {
        this.manaGasto = manaGasto;
    }
}