package operacoes;
import java.util.List;

public class Operacoes {
    public static int[][] obterMatrizSoma(List<int[][]> lista) {
        if (lista.isEmpty()) {
            int[][] matrizVazia = new int[0][0];
            return matrizVazia;
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
            int[][] matrizVazia = new int[0][0];
            return matrizVazia;
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
            int[][] matrizVazia = new int[0][0];
            return matrizVazia;
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