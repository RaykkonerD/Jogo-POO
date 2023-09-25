package jogo.poo;

public class NivelDaArmaduraException extends Exception {
    public NivelDaArmaduraException() {
        super("A armadura tem que ter um nivel entre 0 e 5");
    }
}
