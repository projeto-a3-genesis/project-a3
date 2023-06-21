import java.util.ArrayList;
import java.util.List;
import interacoesComUsuario.Interacoes;
import operacoes.Operacoes;

public class App {
    public static void main(String[] args) {
        int opcao, quantidade;
        List<int[][]> listaMatrizes;
        String stringMatriz;
        int[][] resultado;

        opcao = Interacoes.exibirMenu();
        listaMatrizes = new ArrayList<>();

        switch (opcao) {
            case 1: // soma
                quantidade = Interacoes.quantasMatrizes();
                for (int i = 0; i < quantidade; i++) {
                    int[][] matriz = Interacoes.criarMatriz(i + 1);
                    listaMatrizes.add(matriz);
                }

                stringMatriz = imprimirMatrizesCriadas(listaMatrizes, "+");
                System.out.println(stringMatriz);

                resultado = Operacoes.obterMatrizSoma(listaMatrizes);

                if (resultado.length == 0) {
                    System.out.println(
                            "A soma não pode ser executada adequadamente pois as dimensões das matrizes não são iguais");
                } else {
                    String resultadoString = obterStringMatriz(resultado);
                    System.out.printf("O resultado da soma das matrizes é:\n%s", resultadoString);
                }

                break;
            case 2: // subtração
                quantidade = Interacoes.quantasMatrizes();
                for (int i = 0; i < quantidade; i++) {
                    int[][] matriz = Interacoes.criarMatriz(i + 1);
                    listaMatrizes.add(matriz);
                }

                stringMatriz = imprimirMatrizesCriadas(listaMatrizes, "-");
                System.out.println(stringMatriz);

                resultado = Operacoes.obterMatrizSubtracao(listaMatrizes);

                if (resultado.length == 0) {
                    System.out.println(
                            "A subtração não pode ser executada adequadamente pois as dimensões das matrizes não são iguais");
                } else {
                    String resultadoString = obterStringMatriz(resultado);
                    System.out.printf("O resultado da subtração das matrizes é:\n%s", resultadoString);
                }

                break;
            case 3: // multiplicação
                System.out.println("Usuário escolheu número 3");
                quantidade = Interacoes.quantasMatrizes();
                for (int i = 0; i < quantidade; i++) {
                    int[][] matriz = Interacoes.criarMatriz(i + 1);
                    listaMatrizes.add(matriz);
                }

                stringMatriz = imprimirMatrizesCriadas(listaMatrizes, "x");
                System.out.println(stringMatriz);

                resultado = Operacoes.obterMatrizMultiplicacao(listaMatrizes);

                if (resultado.length == 0) {
                    System.out.println(
                            "A multiplicação não pode ser executada adequadamente pois o número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz");
                } else {
                    String resultadoString = obterStringMatriz(resultado);
                    System.out.printf("O resultado da multiplicação das matrizes é:\n%s", resultadoString);
                }
                break;
            case 4: // determinante
                System.out.println("Usuário escolheu número 4");
                int[][] matriz = Interacoes.criarMatriz(1);
                listaMatrizes.add(matriz);
                stringMatriz = imprimirMatrizesCriadas(listaMatrizes, "");
                System.out.println(stringMatriz);
                int determinante = Operacoes.calcularDeterminante(matriz);
                System.out.printf("O determinante da matriz é:\n|%d|", determinante);
                break;
            case 0: // sair
                System.out.println("Usuário escolheu número 0");
                break;
            default: // opcao inválida
                System.out.println("\nOpção inválida. Encerrando o programa.");
                break;
        }

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

}
