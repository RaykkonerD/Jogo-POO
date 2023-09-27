package jogo.poo;

import java.util.Scanner;

public class App {
    private Personagem jogador;

    public void setJogador(Personagem jogador) {
        this.jogador = jogador;
    }

    public Personagem getJogador() {
        return jogador;
    }

    Pocao gerarPocao(){
        int cura = (int)(Math.random()*5 + 1);
        String nome = null;
        switch(cura){
            case 1:
                nome = "comun";
                break;
            case 2:
                nome = "ácida";
                break;
            case 3:
                nome = "rara";
                break;
            case 4:
                nome = "épica";
                break;
            case 5:
                nome = "divina";
                break;
        }

        return new Pocao(nome, cura);
    }

    Armadura gerarArmadura(){
        int nivel = (int)(Math.random()*5 + 1);
        String nomeDaArmadura = null;
        switch(nivel){
            case 1:
                nomeDaArmadura = "couro";
                break;
            case 2:
                nomeDaArmadura = "ferro";
                break;
            case 3:
                nomeDaArmadura = "ouro";
                break;
            case 4:
                nomeDaArmadura = "diamante";
                break;
            case 5:
                nomeDaArmadura = "vibranio";
                break;
        }

        return new Armadura(nomeDaArmadura, nivel);
    }

    void iniciar() {
        Scanner entrada = new Scanner(System.in);
        System.out.print("Escolha seu nickname: ");
        String nome = entrada.nextLine();


        setJogador(new Personagem(nome));

        System.out.print("Explorar? (s - Sim | n - Sair): ");
        String explorando = entrada.next();

        while(!explorando.equals("n")){
            double chances = Math.random()*10;

            if(!explorando.equals("s")){
                System.out.println("[ERRO]: Opção inválida!");
            } else {
                if(chances < 2){
                    System.out.println("Você encontrou um inimigo!");
                    // Batalhar();
                } else if(chances < 5){
                    if(chances < 2.5){
                        System.out.println("Você encontrou uma poção!");

                        jogador.recuperarVida(gerarPocao());
                        System.out.printf("Vida recuperada. (Vida: %d)%n", jogador.getVida());
                    } else if(chances < 3.5){
                        System.out.println("Você encontrou uma armadura!");

                        jogador.setArmadura(gerarArmadura());
                        System.out.printf("Você começou a usar uma armadura de %s%n", jogador.getArmadura().getNome());
                    } else {
                        System.out.println("Você encontrou uma arma!");
                    }
                } else if(chances < 7){
                    System.out.println("Você encontrou uma bifurcação! (d - Direita | e - Esquerda): ");
                    String lado = entrada.next();
                    if(!lado.equals("e") || !lado.equals("d")){
                        System.out.println("Opção inválida");
                    } else if(lado.equals("e")){
                        System.out.println("Você virou para a esquerda.");
                    } else {
                        System.out.println("Você virou para a direita.");
                    }
                } else {
                    System.out.println("Nada encontrado.");
                }
            }

            System.out.printf("%nVida: %s%n", getJogador().getVida());
            System.out.printf("Arma: %s%n", getJogador().getArma() == null ? "nenhuma" : jogador.getArma().getNome());

            System.out.print("Explorar? (s - Sim | n - Sair): ");
            explorando = entrada.next();
        }
    }

    int menuInicial() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("=== Menu ===");
        System.out.println("1 - Iniciar");
        System.out.println("2 - opções");
        System.out.println("3 - Sair");
        System.out.print("Opção: ");

        int opcao = entrada.nextInt();
        System.out.println();

        return opcao;
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
