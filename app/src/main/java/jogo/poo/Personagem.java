package jogo.poo;

public class Personagem {
    private String nome;
    private int vida;
    private int mana;
    private Arma arma;

    public Personagem(String nome) {
        this.nome = nome;
        this.vida = 100;
        this.mana = 100;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public Arma getArma() {
        return arma;
    }

    public void setArma(Arma arma) {
        this.arma = arma;
    }

    public void receberDano(int dano) {
        this.vida -= dano;
        System.out.printf("%s recebeu dano de %d (Vida: %d)%n",
                this.getNome(), dano, this.getVida());
    }

    public void atacar(Personagem outro) {
        if (arma == null) {
            System.out.printf("%s atacou %s com a mão%n",
                    this.getNome(), outro.getNome());
            outro.receberDano(1);
            return;
        }

        System.out.printf("%s atacou %s com %s%n",
                this.getNome(), outro.getNome(), arma.getNome());
        outro.receberDano(arma.getDano());
    }

    public void recuperarVida(Pocao pocao) {
        this.setVida(this.getVida() + pocao.getCura());
        System.out.printf("%s tomou %s e recuperou %d pontos de vida.%n",
                this.getNome(), pocao.getNome(), pocao.getCura());
    }
}