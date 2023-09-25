package jogo.poo;

public class Arma {
    private String nome;
    private int dano;
    private int probabilidadeDeDano;
    private int manaGasto;

    public Arma(String nome, int dano) {
        this.nome = nome;
        this.dano = dano;
        this.probabilidadeDeDano = 100;
    }

    public Arma(String nome, int dano, int manaGasto) {
        this.nome = nome;
        this.dano = dano;
        this.probabilidadeDeDano = 100;
        this.manaGasto = manaGasto;
    }

    public Arma(String nome, int dano, int manaGasto, int probabilidadeDeDano) {
        this.nome = nome;
        this.dano = dano;
        this.probabilidadeDeDano = probabilidadeDeDano;
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

    public int getProbabilidadeDeDano() {
        return this.probabilidadeDeDano;
    }

    public void setProbabilidadeDeDano(int probabilidadeDeDano) {
        this.probabilidadeDeDano = probabilidadeDeDano;
    }
}