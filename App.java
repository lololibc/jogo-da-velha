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
        
    }

    static void exibirTabuleiro() {

    }

    static void realizarJogada(Scanner teclado) {

    }
    
    static alternarJogador() {
    
    }

    static boolean verificarVitoria() {
        return false;
    }

    static boolean verificarEmpate() {
        return false;
    }
    
}
