package mostrarMatrizes;

import java.util.List;

public class StringMatrizes {
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
}
