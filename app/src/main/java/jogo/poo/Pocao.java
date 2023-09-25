package jogo.poo;

public class Pocao {
    private String nome;
    private int cura;

    public Pocao(String nome, int cura) {
        this.nome = nome;
        this.cura = cura;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }
}
