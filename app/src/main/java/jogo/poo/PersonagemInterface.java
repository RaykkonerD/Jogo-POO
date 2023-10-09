package jogo.poo;

import java.util.ArrayList;

public interface PersonagemInterface {
    String getNome();
    void setNome(String nome);
    int getVida();
    void setVida(int vida);
    int getMana();
    void setMana(int mana);
    Arma getArma();
    void setArma(Arma arma);
    Armadura getArmadura();
    void setArmadura(Armadura armadura);
    ArrayList<Item> getInventario();
    void adicionarAoInventario(Item item);
    void removerDoInventario(int index);
    void receberDano(int dano);
    void atacar(Personagem outro);
    void recuperarVida(Pocao pocao);
}
