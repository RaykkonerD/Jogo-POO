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
                nome = "poção comun";
                break;
            case 2:
                nome = "poção ácida";
                break;
            case 3:
                nome = "poção rara";
                break;
            case 4:
                nome = "poção épica";
                break;
            case 5:
                nome = "poção divina";
                break;
        }

        return new Pocao(nome, cura*10);
    }

    Armadura gerarArmadura(){
        int nivel = (int)(Math.random()*5 + 1);
        String nome = null;
        switch(nivel){
            case 1:
                nome = "armadura de couro";
                break;
            case 2:
                nome = "armadura de ferro";
                break;
            case 3:
                nome = "armadura de ouro";
                break;
            case 4:
                nome = "armadura de diamante";
                break;
            case 5:
                nome = "armadura de vibranio";
                break;
        }

        return new Armadura(nome, nivel);
    }

    Arma gerarArma(){
        // Implementar armas que gastam mana e com probabilidade de acerto
        int tipo = (int)(Math.random()*5 + 1);
        String nome = null;
        int dano = 0;
        int manaGasto = 0;
        int probabilidadeDeDano = 100;

        switch(tipo){
            case 1:
                nome = "soco-inglês";
                dano = 3;
                break;
            case 2:
                nome = "faca";
                dano = 5;
                break;
            case 3:
                nome = "espada";
                manaGasto = 3;
                dano = 10;
                break;
            case 4:
                nome = "arco e flecha";
                dano = 15;
                probabilidadeDeDano = 50;
                break;
            case 5:
                nome = "revólver";
                dano = 20;
                manaGasto = 10;
                probabilidadeDeDano = 25;
                break;
        }

        return new Arma(nome, dano, manaGasto, probabilidadeDeDano);
    }

    public void batalhar(){
        Personagem inimigo = new Personagem("Curupira");
        inimigo.setArma(gerarArma());
        Scanner entrada = new Scanner(System.in);
        
        while(inimigo.getVida() > 0 && getJogador().getVida() > 0){ 
            inimigo.atacar(this.jogador);
            System.out.println();
            System.out.print("👊 Atacar (s - sim | o - opcoes | n - sair): ");
            String opcao = entrada.next();
            System.out.println();

            while(!opcao.equals("s") && !opcao.equals("o") && !opcao.equals("n")){
                System.out.println("[ERRO]: Opção inválida!");
                System.out.print("👊 Atacar (s/o/n): ");
                opcao = entrada.next();
                System.out.println();
            }

            if(opcao.equals("s")){
                this.jogador.atacar(inimigo);
            } else if(opcao.equals("o")){
                opcoes();
            } else {
                return;
            }
        }

        if(inimigo.getVida() == 0){ 
            System.out.println("Você o venceu!");
        } else {
            System.out.println("Você perdeu!");
        }
    }

    public void usarItem(int posicao){ 
        if(getJogador().getInventario().get(posicao) instanceof Arma){
            if(getJogador().getArma() != null){
                this.jogador.adicionarAoInventario(getJogador().getArma());
            }

            this.jogador.setArma((Arma)getJogador().getInventario().get(posicao));

            System.out.printf("Você começou a usar %s como arma%n", getJogador().getArma().getNome());
        } else if(getJogador().getInventario().get(posicao) instanceof Armadura){
            if(getJogador().getArmadura() != null){
                this.jogador.adicionarAoInventario(getJogador().getArmadura());
            }

            this.jogador.setArmadura((Armadura)getJogador().getInventario().get(posicao));

            System.out.printf("Você começou a usar uma %s%n", getJogador().getArmadura().getNome());
        } else {
            this.jogador.recuperarVida((Pocao)getJogador().getInventario().get(posicao));
        }

        this.jogador.removerDoInventario(posicao - 1);
    }

    public void iniciar() {
        Scanner entrada = new Scanner(System.in);

        if(jogador == null){ 
            System.out.print("Escolha seu nickname: ");
            String nome = entrada.nextLine(); 
            setJogador(new Personagem(nome));
        } else {
            System.out.printf("=> Bem vindo de volta, %s!%n", this.jogador.getNome());
        }

        System.out.print("👣 Explorar? (s - Sim | o - opções | n - Sair): ");
        String explorando = entrada.next();

        while(!explorando.equals("n")){
            double chances = Math.random()*10;

            if(!explorando.equals("s") && !explorando.equals("o")){
                System.out.println("[ERRO]: Opção inválida!");
            } else if(explorando.equals("o")){
                opcoes();
            } else {
                if(chances < 2){
                    System.out.println("🤺 Você encontrou um inimigo!");
                    batalhar();
                } else if(chances < 5){
                    if(chances < 2.5){
                        Pocao novaPocao = gerarPocao();
                        System.out.printf("🧪 Você encontrou uma poção! %s%n", novaPocao.getNome());

                        this.jogador.adicionarAoInventario(novaPocao);
                        // System.out.printf("Vida recuperada. (Vida: %d)%n", jogador.getVida());
                    } else if(chances < 3.5){
                        Armadura novaArmadura = gerarArmadura();
                        System.out.printf("🛡️ Você encontrou uma armadura! %s%n", novaArmadura.getNome());

                        this.jogador.adicionarAoInventario(novaArmadura);
                    } else {
                        Arma novaArma = gerarArma();
                        System.out.printf("🗡️ Você encontrou uma arma! %s%n", novaArma.getNome());

                        this.jogador.adicionarAoInventario(novaArma);
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
            }

            Arma arma = getJogador().getArma();
            Armadura armadura = getJogador().getArmadura();

            System.out.printf("%nVida: %s%n", getJogador().getVida());
            System.out.printf("Arma: %s%n", arma == null ? "nenhuma" : arma.getNome() + " dano " + arma.getDano() + " acerto " + arma.getProbabilidadeDeDano() + "%");
            System.out.printf("Armadura: %s%n", armadura == null ? "nenhuma" : armadura.getNome() + " nível " + armadura.getNivelDaProtecao());

            System.out.print("👣 Explorar? (s/o/n): ");
            explorando = entrada.next();
        }
    }

    void menuInicial() {
        Scanner entrada = new Scanner(System.in);
        int opcao;

        while(true){ 
            System.out.println();
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
            System.out.println();
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
                        System.out.print("Inventario: "); 
                        getJogador().getInventario().forEach((item) -> System.out.printf(getJogador().getInventario().indexOf(item) == getJogador().getInventario().size()-1 ? "%s%n" : "%s, ", item.getNome()));
                        System.out.print("Usar item? (s/n): ");
                        String resposta = entrada.next();

                        if(resposta.equals("s")){
                            System.out.print("Posição do item: ");
                            int posicao = entrada.nextInt();
                            while(posicao > this.jogador.getInventario().size() || posicao < 1){
                                System.out.println("[ERRO]: Posição inválida!");
                                posicao = entrada.nextInt();
                            }
                            
                            usarItem(posicao-1);
                        }
                    } else {
                        System.out.println("[Inventário vazio]");
                    }
                    break;
                case 2:
                    if(this.jogador != null){
                        System.out.println();
                        System.out.println("=== Perfil ===");
                        System.out.printf("Nome: %s%n", this.jogador.getNome());
                        
                        if(this.jogador.getArma() != null){
                            System.out.printf("Arma: %s dano %d%n", this.jogador.getArma().getNome(), this.jogador.getArma().getDano());
                        } else {
                            System.out.println("Arma: nenhuma");
                        }

                        if(this.jogador.getArmadura() != null){
                            System.out.printf("Armadura: %s nível %d%n", this.jogador.getArmadura().getNome(), this.jogador.getArmadura().getNivelDaProtecao());
                        } else {
                            System.out.println("Armadura: nenhuma");
                        }

                        System.out.println();
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
