import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int opcao, quantidade;
        List<int[][]> listaMatrizes;

        opcao = exibirMenu();
        listaMatrizes = new ArrayList<>();

        switch (opcao) {
            case 1:
                System.out.println("Usuário escolheu número 1");
                quantidade = quantasMatrizes();
                System.out.printf("Usuário escolheu %d matriz(es)\n", quantidade);
                for (int i = 0; i < quantidade; i++) {
                    int[][] matriz = criarMatriz(i + 1);
                    listaMatrizes.add(matriz);
                    String stringMatriz = imprimirMatriz(matriz);
                    System.out.println(stringMatriz);
                }

                break;
            case 2:
                System.out.println("Usuário escolheu número 2");
                quantidade = quantasMatrizes();
                break;
            case 3:
                System.out.println("Usuário escolheu número 3");
                quantidade = quantasMatrizes();
                break;
            case 4:
                System.out.println("Usuário escolheu número 4");
                quantidade = quantasMatrizes();
                break;
            case 0:
                System.out.println("Usuário escolheu número 0");
                break;
            default:
                System.out.println("\nOpção inválida. Encerrando o programa.");
                break;
        }

    }

    public static int exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nBem-vindo ao solucionador de matrizes e determinantes!");
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

    public static int quantasMatrizes() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de matrizes para fazer a operação: ");
        int quantidade = scanner.nextInt();

        return quantidade;
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

    public static String imprimirMatriz(int[][] matriz) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n");

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sb.append(matriz[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static int[][] realizarSoma(int[][] matriz) {
        // Lógica para a soma da matriz
        // Retorne a matriz resultante
        return matriz;
    }

    public static int[][] realizarSubtracao(int[][] matriz) {
        // Lógica para a subtração da matriz
        // Retorne a matriz resultante
        return matriz;
    }

    public static int[][] realizarMultiplicacao(int[][] matriz) {
        // Lógica para a multiplicação da matriz
        // Retorne a matriz resultante
        return matriz;
    }

    public static int calcularDeterminante(int[][] matriz) {
        // Lógica para o cálculo do determinante da matriz
        // Retorne o determinante
        return 0;
    }
}
