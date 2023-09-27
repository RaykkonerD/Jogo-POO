package jogo.poo;

public class Arma extends Item {
    private int dano;
    private int probabilidadeDeDano;
    private int manaGasto;

    public Arma(String nome, int dano) {
        super(nome);
        this.dano = dano;
        this.probabilidadeDeDano = 100;
    }

    public Arma(String nome, int dano, int manaGasto) {
        super(nome);
        this.dano = dano;
        this.probabilidadeDeDano = 100;
        this.manaGasto = manaGasto;
    }

    public Arma(String nome, int dano, int manaGasto, int probabilidadeDeDano) {
        super(nome);
        this.dano = dano;
        this.probabilidadeDeDano = probabilidadeDeDano;
        this.manaGasto = manaGasto;
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