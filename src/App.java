import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int opcao, quantidade;
        List<int[][]> listaMatrizes;
        String stringMatriz;
        int[][] resultado;

        opcao = exibirMenu();
        listaMatrizes = new ArrayList<>();

        switch (opcao) {
            case 1:
                quantidade = quantasMatrizes();
                for (int i = 0; i < quantidade; i++) {
                    int[][] matriz = criarMatriz(i + 1);
                    listaMatrizes.add(matriz);
                }

                stringMatriz = imprimirMatrizesCriadas(listaMatrizes, "+");
                System.out.println(stringMatriz);

                resultado = obterMatrizSoma(listaMatrizes);

                if (resultado.length == 0) {
                    System.out.println(
                            "A soma não pode ser executada adequadamente pois as dimensões das matrizes não são iguais");
                } else {
                    String resultadoString = obterStringMatriz(resultado);
                    System.out.printf("O resultado da soma das matrizes é:\n%s", resultadoString);
                }

                break;
            case 2:
                quantidade = quantasMatrizes();
                for (int i = 0; i < quantidade; i++) {
                    int[][] matriz = criarMatriz(i + 1);
                    listaMatrizes.add(matriz);
                }

                stringMatriz = imprimirMatrizesCriadas(listaMatrizes, "-");
                System.out.println(stringMatriz);

                resultado = obterMatrizSubtracao(listaMatrizes);

                if (resultado.length == 0) {
                    System.out.println(
                            "A subtração não pode ser executada adequadamente pois as dimensões das matrizes não são iguais");
                } else {
                    String resultadoString = obterStringMatriz(resultado);
                    System.out.printf("O resultado da subtração das matrizes é:\n%s", resultadoString);
                }

                break;
            case 3:
                System.out.println("Usuário escolheu número 3");
                quantidade = quantasMatrizes();
                for (int i = 0; i < quantidade; i++) {
                    int[][] matriz = criarMatriz(i + 1);
                    listaMatrizes.add(matriz);
                }

                stringMatriz = imprimirMatrizesCriadas(listaMatrizes, "x");
                System.out.println(stringMatriz);

                resultado = obterMatrizMultiplicacao(listaMatrizes);

                if (resultado.length == 0) {
                    System.out.println(
                            "A multiplicação não pode ser executada adequadamente pois o número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz");
                } else {
                    String resultadoString = obterStringMatriz(resultado);
                    System.out.printf("O resultado da multiplicação das matrizes é:\n%s", resultadoString);
                }
                break;
            case 4:
                System.out.println("Usuário escolheu número 4");
                int[][] matriz = criarMatriz(1);
                listaMatrizes.add(matriz);
                stringMatriz = imprimirMatrizesCriadas(listaMatrizes, "");
                System.out.println(stringMatriz);
                int determinante = calcularDeterminante(matriz);
                System.out.printf("O determinante da matriz é:\n%d", determinante);
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

    public static String imprimirMatrizesCriadas(List<int[][]> lista, String separador) {
        StringBuilder sb = new StringBuilder();

        int tamanhoLista = lista.size();
        for (int i = 0; i < tamanhoLista; i++) {
            int[][] matriz = lista.get(i);
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz[j].length; k++) {
                    sb.append(matriz[j][k]).append(" ");
                }
                sb.append("\n");
            }
            if (i < tamanhoLista - 1) {
                sb.append(separador).append("\n");
            }
        }

        return sb.toString();
    }

    public static String obterStringMatriz(int[][] matriz) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                sb.append(matriz[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    public static int[][] obterMatrizSoma(List<int[][]> lista) {
        if (lista.isEmpty()) {
            // Retorna uma matriz vazia ou lança uma exceção, dependendo do seu requisito
        }

        int[][] matrizSoma = lista.get(0); // Inicializa a matriz soma com o primeiro elemento da lista

        // Percorre os elementos da lista a partir do segundo elemento
        for (int i = 1; i < lista.size(); i++) {
            int[][] matrizAtual = lista.get(i);

            // Verifica se as dimensões das matrizes são compatíveis
            if (matrizSoma.length != matrizAtual.length || matrizSoma[0].length != matrizAtual[0].length) {
                int[][] matrizVazia = new int[0][0];
                return matrizVazia;
            }

            // Realiza a soma das matrizes
            for (int j = 0; j < matrizSoma.length; j++) {
                for (int k = 0; k < matrizSoma[j].length; k++) {
                    matrizSoma[j][k] += matrizAtual[j][k];
                }
            }
        }

        return matrizSoma;
    }

    public static int[][] obterMatrizSubtracao(List<int[][]> lista) {
        if (lista.isEmpty()) {
            // Retorna uma matriz vazia ou lança uma exceção, dependendo do seu requisito
        }

        int[][] matrizSubtracao = lista.get(0); // Inicializa a matriz subtração com o primeiro elemento da lista

        // Percorre os elementos da lista a partir do segundo elemento
        for (int i = 1; i < lista.size(); i++) {
            int[][] matrizAtual = lista.get(i);

            // Verifica se as dimensões das matrizes são compatíveis
            if (matrizSubtracao.length != matrizAtual.length || matrizSubtracao[0].length != matrizAtual[0].length) {
                int[][] matrizVazia = new int[0][0];
                return matrizVazia;
            }

            // Realiza a subtração das matrizes
            for (int j = 0; j < matrizSubtracao.length; j++) {
                for (int k = 0; k < matrizSubtracao[j].length; k++) {
                    matrizSubtracao[j][k] -= matrizAtual[j][k];
                }
            }
        }

        return matrizSubtracao;
    }

    public static int[][] obterMatrizMultiplicacao(List<int[][]> lista) {
        if (lista.isEmpty()) {
            // Retorna uma matriz vazia ou lança uma exceção, dependendo do seu requisito
        }

        int[][] matrizResultado = lista.get(0); // Inicializa a matriz resultado com o primeiro elemento da lista

        // Percorre os elementos da lista a partir do segundo elemento
        for (int i = 1; i < lista.size(); i++) {
            int[][] matrizAtual = lista.get(i);

            // Verifica se as dimensões das matrizes são compatíveis
            if (matrizResultado[0].length != matrizAtual.length) {
                int[][] matrizVazia = new int[0][0];
                return matrizVazia;
            }

            // Cria uma nova matriz para armazenar o resultado da multiplicação
            int[][] novaMatriz = new int[matrizResultado.length][matrizAtual[0].length];

            // Realiza a multiplicação das matrizes
            for (int j = 0; j < matrizResultado.length; j++) {
                for (int k = 0; k < matrizAtual[0].length; k++) {
                    for (int l = 0; l < matrizResultado[0].length; l++) {
                        novaMatriz[j][k] += matrizResultado[j][l] * matrizAtual[l][k];
                    }
                }
            }

            matrizResultado = novaMatriz; // Atualiza a matriz resultado com o resultado da multiplicação atual
        }

        return matrizResultado;
    }

    public static int calcularDeterminante(int[][] matriz) {
        int dimensao = matriz.length;

        if (dimensao == 1) {
            // Caso base: matriz de dimensão 1, o determinante é o próprio elemento
            return matriz[0][0];
        } else if (dimensao == 2) {
            // Caso base: matriz de dimensão 2, o determinante é calculado diretamente
            return (matriz[0][0] * matriz[1][1]) - (matriz[0][1] * matriz[1][0]);
        } else {
            int determinante = 0;

            for (int i = 0; i < dimensao; i++) {
                int[][] submatriz = obterSubmatriz(matriz, 0, i);
                int cofator = matriz[0][i] * calcularDeterminante(submatriz);

                if (i % 2 == 0) {
                    determinante += cofator;
                } else {
                    determinante -= cofator;
                }
            }

            return determinante;
        }
    }

    // Função auxiliar para obter a submatriz removendo a linha 'linha' e a coluna
    // 'coluna'
    private static int[][] obterSubmatriz(int[][] matriz, int linha, int coluna) {
        int dimensao = matriz.length;
        int[][] submatriz = new int[dimensao - 1][dimensao - 1];

        int linhaSubmatriz = 0;
        int colunaSubmatriz;

        for (int i = 0; i < dimensao; i++) {
            if (i != linha) {
                colunaSubmatriz = 0;

                for (int j = 0; j < dimensao; j++) {
                    if (j != coluna) {
                        submatriz[linhaSubmatriz][colunaSubmatriz] = matriz[i][j];
                        colunaSubmatriz++;
                    }
                }

                linhaSubmatriz++;
            }
        }

        return submatriz;
    }
}
