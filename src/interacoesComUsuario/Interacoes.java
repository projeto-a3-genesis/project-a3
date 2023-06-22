package interacoesComUsuario;

import java.util.Scanner;

public class Interacoes {

    public static int exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMenu de Operações:");
        System.out.println("1. Soma da Matriz");
        System.out.println("2. Subtração da Matriz");
        System.out.println("3. Multiplicação da Matriz");
        System.out.println("4. Determinante da Matriz");
        System.out.println("0. Sair");

        System.out.print("Escolha uma operação (0-4): ");
        int opcao = scanner.nextInt();

        return opcao;
    }

    public static int[][] criarMatriz(int numMatriz) {
        Scanner scanner = new Scanner(System.in);

        System.out.printf("Digite o número de linhas da matriz %d: ", numMatriz);
        int linhas = scanner.nextInt();

        System.out.printf("Digite o número de colunas da matriz %d: ", numMatriz);
        int colunas = scanner.nextInt();

        int[][] matriz = new int[linhas][colunas];

        System.out.printf("Digite os valores da matriz %d: \n", numMatriz);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    public static int quantasMatrizes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de matrizes para fazer a operação: ");
        int quantidade = scanner.nextInt();

        return quantidade;
    }

    public static boolean opcaoDeterminante() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Deseja calcular a determinante do resultado? (s/n): ");
        char option = scanner.next().charAt(0);

        if (option == 's') {
            return true;
        }

        return false;
    }
}
