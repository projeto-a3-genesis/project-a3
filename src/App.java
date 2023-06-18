import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int opcao = exibirMenu();

        switch (opcao) {
            case 1:
                int[][] matrizA = criarMatriz();
                int[][] matrizB = criarMatriz();
                int[][] matrizSoma = criarMatriz();
                System.out.println("\nResultado da Soma:");
                imprimirMatriz(matrizSoma);
                break;
            case 2:
                int[][] matrizSubtracao = realizarSubtracao();
                System.out.println("\nResultado da Subtração:");
                imprimirMatriz(matrizSubtracao);
                break;
            case 3:
                int[][] matrizMultiplicacao = realizarMultiplicacao();
                System.out.println("\nResultado da Multiplicação:");
                imprimirMatriz(matrizMultiplicacao);
                break;
            case 4:
                int determinante = calcularDeterminante(matriz);
                System.out.println("\nDeterminante da Matriz: " + determinante);
                break;
            case 0:
                System.out.println("\nEncerrando o programa.");
                break;
            default:
                System.out.println("\nOpção inválida. Encerrando o programa.");
                break;
        }
    }

    public static int[][] criarMatriz() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o número de linhas da matriz: ");
        int linhas = scanner.nextInt();

        System.out.print("Digite o número de colunas da matriz: ");
        int colunas = scanner.nextInt();

        int[][] matriz = new int[linhas][colunas];

        System.out.println("Digite os valores da matriz:");

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                System.out.print("Valor para a posição [" + i + "][" + j + "]: ");
                matriz[i][j] = scanner.nextInt();
            }
        }

        return matriz;
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int exibirMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nMenu de Operações:");
        System.out.println("1. Soma da Matriz");
        System.out.println("2. Subtração da Matriz");
        System.out.println("3. Multiplicação da Matriz");
        System.out.println("4. Determinante da Matriz");
        System.out.println("0. Sair");

        System.out.print("Escolha uma operação (0-4): ");
        scanner.nextLine();
        int opcao = scanner.nextInt();

        return opcao;
    }

    public static int[][] criarMatriz(int[][] matriz) {
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
