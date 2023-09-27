package jogo.poo;

public abstract class Item {
    private String nome;

    public Item(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
}
