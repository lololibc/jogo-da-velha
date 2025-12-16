import java.util.Scanner;

public class JogoDaVelha {
    static char[][] tabuleiro = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static char jogador = 'X';

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        limparTabuleiro();
        
        while (true) {
            exibirTabuleiro();
            realizarJogada(teclado);

            if (verificarVitoria()) {
                exibirTabuleiro();
                System.out.println("Jogador " + jogador + " venceu!");
                break;
            }

            if (verificarEmpate()) {
                exibirTabuleiro();
                System.out.println("Empate!");
                break;
            }

            alternarJogador();
        }

        teclado.close();
    }
    
    static void limparTabuleiro() {
        for (int i = 0; i < tabuleiro.length; i++) {
            for (int j = 0; j < tabuleiro.length; j++) {
                tabuleiro[i][j] = ' '; //tem que ser ' ' e nao " " pois o aspas simples define char e o aspas duplas define String.
            }
        }
    }

    static void exibirTabuleiro() {
        
        // Opção 1 de tabuleiro:
        //cabeçalho do tabuleiro
        System.out.print("   ");
        for (int j = 0; j < tabuleiro.length; j++) {
            System.out.print(j + ":  ");
        }
        System.out.println();

        // Linhas do tabuleiro
        for (int i = 0; i < tabuleiro.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < tabuleiro[i].length; j++) {
                System.out.print(tabuleiro[i][j]);

                if (j < tabuleiro[i].length - 1) {
                    System.out.print(" | ");
                }
            }

            System.out.println();

            // Linha separadora
            if (i < tabuleiro.length - 1) {
                System.out.println("  -----------");
            }
        }

        // Opção 2 de tabuleiro:
        // System.out.println("  0: 1: 2:");
        // System.out.println("0: " + tabuleiro[0][0] + " | " + tabuleiro[0][1] + " | " + tabuleiro[0][2]);
        // System.out.println("  --------");
        // System.out.println("1: " + tabuleiro[1][0] + " | " + tabuleiro[1][1] + " | " + tabuleiro[1][2]);
        // System.out.println("  --------");
        // System.out.println("2: " + tabuleiro[2][0] + " | " + tabuleiro[2][1] + " | " + tabuleiro[2][2]);
    }

    static void realizarJogada(Scanner teclado) {
        boolean digitoInvalido = true;
        while (digitoInvalido) {
            System.out.print(" Digite a linha e a coluna da posição que você deseja realizar a sua jogada: ");
            int linha = teclado.nextInt();
            int coluna = teclado.nextInt();
            if (linha > 2 || linha < 0 || coluna > 2 || coluna < 0) {
                System.out.println("Você digitou uma linha e/ou coluna inválida, digite novamente mas com números entre 0 e 2!");
            } else if (tabuleiro[linha][coluna] != ' '){
                System.out.println("Essa posição já está ocupada, digite outra!");
            }else {
                tabuleiro[linha][coluna] = jogador;
                digitoInvalido = false;
            }
        }
    }

    static void alternarJogador() {
        if (jogador == 'X') {
            jogador = 'O';
        } else {
            jogador = 'X';
        }
    }

    static boolean verificarVitoria() {
        for (int i = 0; i < tabuleiro.length; i++) {
            if (tabuleiro[i][0] == jogador && tabuleiro[i][1] == jogador && tabuleiro[i][2] == jogador) {
                return true;
            }
            if (tabuleiro[0][i] == jogador && tabuleiro[1][i] == jogador && tabuleiro[2][i] == jogador) {
                return true;
            }
        }

        if (tabuleiro[0][0] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][2] == jogador) {
            return true;
        } else if (tabuleiro[0][2] == jogador && tabuleiro[1][1] == jogador && tabuleiro[2][0] == jogador) {
            return true;
        } else {
            return false;
        }
    }

    static boolean verificarEmpate() {
        for (int i = 0; i < tabuleiro.length; i++){
            for (int j = 0; j < tabuleiro.length; j++){
                if (tabuleiro[i][j] == ' ' && !verificarVitoria()){
                    return false;
                }
            }
        }
        return true;
    }
}

