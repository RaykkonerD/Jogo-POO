package jogo.poo;

public class Pocao extends Item {
    private int cura;

    public Pocao(String nome, int cura) {
        super(nome);
        this.cura = cura;
    }

    public int getCura() {
        return cura;
    }

    public void setCura(int cura) {
        this.cura = cura;
    }
}
