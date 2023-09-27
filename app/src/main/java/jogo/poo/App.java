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

        if(jogador == null){ 
            System.out.print("Escolha seu nickname: ");
            String nome = entrada.nextLine(); 
            setJogador(new Personagem(nome));
        } else {
            System.out.printf("=> Bem vindo de volta, %s!%n", this.jogador.getNome());
        }

        System.out.print("👣 Explorar? (s - Sim | n - Sair): ");
        String explorando = entrada.next();

        while(!explorando.equals("n")){
            double chances = Math.random()*10;

            if(!explorando.equals("s")){
                System.out.println("[ERRO]: Opção inválida!");
            } else {
                if(chances < 2){
                    System.out.println("🤺 Você encontrou um inimigo!");
                    // Batalhar();
                } else if(chances < 5){
                    if(chances < 2.5){
                        System.out.println("🧪 Você encontrou uma poção!");

                        this.jogador.adicionarAoInventario(gerarPocao());
                        // System.out.printf("Vida recuperada. (Vida: %d)%n", jogador.getVida());
                    } else if(chances < 3.5){
                        System.out.println("🛡️ Você encontrou uma armadura!");

                        this.jogador.adicionarAoInventario(gerarArmadura());
                        // System.out.printf("Você começou a usar uma armadura de %s%n", jogador.getArmadura().getNome());
                    } else {
                        System.out.println("🗡️ Você encontrou uma arma!");
                    } 
                } else if(chances < 7){
                    System.out.println("Você encontrou uma bifurcação! (d - Direita | e - Esquerda): ");
                    String lado = entrada.next();
                    if(!lado.equals("e") && !lado.equals("d")){
                        System.out.println("Opção inválida");
                    } else if(lado.equals("e")){
                        System.out.println("☚ Você virou para a esquerda.");
                    } else {
                        System.out.println("☛ Você virou para a direita.");
                    }
                } else {
                    System.out.println("Nada encontrado.");
                }

                // Teste
                if(this.jogador.getInventario() != null){

                    for(Item item : this.jogador.getInventario()){
                        System.out.println(item.getNome());
                    }
                }
            }

            System.out.printf("%nVida: %s%n", getJogador().getVida());
            System.out.printf("Arma: %s%n", getJogador().getArma() == null ? "nenhuma" : jogador.getArma().getNome());

            System.out.print("Explorar? (s - Sim | n - Sair): ");
            explorando = entrada.next();
        }
    }

    void menuInicial() {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        while(true){
            System.out.println("=== Menu ===");
            System.out.println("1 - Iniciar");
            System.out.println("2 - opções");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");

            opcao = entrada.nextInt();
            System.out.println();
 
            switch(opcao){
                case 1:
                    iniciar();
                    break;
                case 2:
                    opcoes();
                    break;
                case 3:
                    System.out.println("[FIM DE JOGO]");
                    return;
                default: 
                    System.out.println("[ERRO]: Opção inválida!");
                    menuInicial();
                    break;
            }
        }
    }

    public void opcoes(){
        Scanner entrada = new Scanner(System.in);
        int opcao;

        while(true){
            System.out.println("=== Opções ===");
            System.out.println("1 - Ver inventário");
            System.out.println("2 - Perfil");
            System.out.println("3 - Sair");
            System.out.print("Opção: ");

            opcao = entrada.nextInt();
            System.out.println();

            switch(opcao){
                case 1:
                    if(this.jogador != null && this.jogador.getInventario() != null){
                        System.out.println("Inventario: " + this.jogador.getInventario());
                    } else {
                        System.out.println("[Inventário vazio]");
                    }
                    break;
                case 2:
                    if(this.jogador != null){
                        System.out.println("Nome: " + this.jogador.getNome());
                        System.out.println("Arma: " + this.jogador.getArma() != null ? this.jogador.getArma().getNome() + " dano " + this.jogador.getArma().getDano() : "nenhuma");
                        System.out.println("Armadura: " + this.jogador.getArmadura() != null ? this.jogador.getArmadura().getNome() + " nível " + this.jogador.getArmadura().getNivelDaProtecao() : "nenhuma");
                    } else {
                        System.out.println("[Jogador não definido]");
                    }
                    break;
                case 3:
                    return;
                default:
                    System.out.println("[ERRO]: Opção inválida!");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        App jogo = new App();
        jogo.menuInicial();
    }
}
