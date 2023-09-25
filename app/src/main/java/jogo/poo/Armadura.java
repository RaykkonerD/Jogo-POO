package jogo.poo;

public class Armadura {
    int nivel;

    public Armadura(int nivel) {
        this.nivel = nivel;
    }

    public int nivelDaProtecao() throws NivelDaArmaduraException {
        if(this.nivel > 5 || this.nivel < 0) {
            throw new NivelDaArmaduraException();
        } else {
            return this.nivel;
        }
    }
}
