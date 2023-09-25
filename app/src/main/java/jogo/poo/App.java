package jogo.poo;

import java.util.Scanner;

public class App {
    void iniciar() {
        double chances = Math.random()*10;

        if(chances < 3){
            System.out.println("Você encontrou um inimigo!");
            // Batalhar();
        } else if(chances < 5){
            System.out.println("Você encontrou um item!");
            // PegarItem();
        } else if(chances < 7){
            System.out.println("Você encontrou uma bifurcação!");
            // Escolher caminhon 1 ou 2
        } else {
            System.out.println("Nada encontrado. Continuar? (s - Sim | n - Não)");
            // Escolha se continuar ou não
        }
    }

    int menuInicial() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Menu ===");
        System.out.println("1 - Iniciar");
        System.out.println("2 - opções");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");

        return entrada.nextInt();
    }

    public static void main(String[] args) {
        Personagem raimundo = new Personagem("Raimundo Nonato");
        Personagem madruga = new Personagem("Seu Madruga");
        Arma peixeira = new Arma("Peixeira", 20);
        Arma chinela = new Arma("Chinela havaiana", 5);
        Pocao corote = new Pocao("Corote", 5);
        Armadura netherite = new Armadura("netherite", 5);

        raimundo.setArma(peixeira);
        madruga.setArma(chinela);
        madruga.setArmadura(netherite);

        raimundo.atacar(madruga);
        madruga.recuperarVida(corote);
        madruga.atacar(raimundo);

        App jogo = new App();
        int opcaoEscolhida = jogo.menuInicial();

        while (opcaoEscolhida != 3) {
            switch (opcaoEscolhida) {
                case 1:
                    jogo.iniciar();
                    break;
                case 2:
                    System.out.println("=== Opções ===");
                    System.out.println("1 - Ver inventário");
                    System.out.println("2 - Perfil");
                    System.out.println("3 - Sair");
                    break;
                default:
                    System.out.println("[ERRO]: Opção inválida!");
                    break;
            }
            opcaoEscolhida = jogo.menuInicial();
        }
    }
}
