import java.util.ArrayList;
import java.util.List;
import interacoesComUsuario.Interacoes;
import mostrarMatrizes.StringMatrizes;
import operacoes.Operacoes;

public class App {
    public static void main(String[] args) {
        int opcao, quantidade;
        List<int[][]> listaMatrizes;
        String stringMatriz;
        int[][] resultado;
        boolean sair, calcularDeterminante;

        sair = false;

        System.out.println("\nBem-vindo ao solucionador de matrizes e determinantes!");

        while (!sair) {
            opcao = Interacoes.exibirMenu();
            listaMatrizes = new ArrayList<>();
            switch (opcao) {
                case 1: // soma
                    quantidade = Interacoes.quantasMatrizes();
                    for (int i = 0; i < quantidade; i++) {
                        int[][] matriz = Interacoes.criarMatriz(i + 1);
                        listaMatrizes.add(matriz);
                    }

                    stringMatriz = StringMatrizes.imprimirMatrizesCriadas(listaMatrizes, "+");
                    System.out.println(stringMatriz);

                    resultado = Operacoes.obterMatrizSoma(listaMatrizes);

                    if (resultado.length == 0) {
                        System.out.println(
                                "A soma não pode ser executada adequadamente pois as dimensões das matrizes não são iguais");
                    } else {
                        String resultadoString = StringMatrizes.obterStringMatriz(resultado);
                        System.out.printf("O resultado da soma das matrizes é:\n%s", resultadoString);
                    }

                    calcularDeterminante = Interacoes.opcaoDeterminante();

                    if (calcularDeterminante) {
                        int determinante = Operacoes.calcularDeterminante(resultado);
                        System.out.printf("O determinante da matriz é:\n|%d|", determinante);
                    }

                    break;
                case 2: // subtração
                    quantidade = Interacoes.quantasMatrizes();
                    for (int i = 0; i < quantidade; i++) {
                        int[][] matriz = Interacoes.criarMatriz(i + 1);
                        listaMatrizes.add(matriz);
                    }

                    stringMatriz = StringMatrizes.imprimirMatrizesCriadas(listaMatrizes, "-");
                    System.out.println(stringMatriz);

                    resultado = Operacoes.obterMatrizSubtracao(listaMatrizes);

                    if (resultado.length == 0) {
                        System.out.println(
                                "A subtração não pode ser executada adequadamente pois as dimensões das matrizes não são iguais");
                    } else {
                        String resultadoString = StringMatrizes.obterStringMatriz(resultado);
                        System.out.printf("O resultado da subtração das matrizes é:\n%s", resultadoString);
                    }

                    calcularDeterminante = Interacoes.opcaoDeterminante();

                    if (calcularDeterminante) {
                        int determinante = Operacoes.calcularDeterminante(resultado);
                        System.out.printf("O determinante da matriz é:\n|%d|", determinante);
                    }

                    break;
                case 3: // multiplicação
                    System.out.println("Usuário escolheu número 3");
                    quantidade = Interacoes.quantasMatrizes();
                    for (int i = 0; i < quantidade; i++) {
                        int[][] matriz = Interacoes.criarMatriz(i + 1);
                        listaMatrizes.add(matriz);
                    }

                    stringMatriz = StringMatrizes.imprimirMatrizesCriadas(listaMatrizes, "x");
                    System.out.println(stringMatriz);

                    resultado = Operacoes.obterMatrizMultiplicacao(listaMatrizes);

                    if (resultado.length == 0) {
                        System.out.println(
                                "A multiplicação não pode ser executada adequadamente pois o número de colunas da primeira matriz deve ser igual ao número de linhas da segunda matriz");
                    } else {
                        String resultadoString = StringMatrizes.obterStringMatriz(resultado);
                        System.out.printf("O resultado da multiplicação das matrizes é:\n%s", resultadoString);
                    }

                    calcularDeterminante = Interacoes.opcaoDeterminante();

                    if (calcularDeterminante) {
                        int determinante = Operacoes.calcularDeterminante(resultado);
                        System.out.printf("O determinante da matriz é:\n|%d|", determinante);
                    }

                    break;
                case 4: // determinante
                    System.out.println("Usuário escolheu número 4");
                    int[][] matriz = Interacoes.criarMatriz(1);
                    listaMatrizes.add(matriz);
                    stringMatriz = StringMatrizes.imprimirMatrizesCriadas(listaMatrizes, "");
                    System.out.println(stringMatriz);
                    int determinante = Operacoes.calcularDeterminante(matriz);
                    System.out.printf("O determinante da matriz é:\n|%d|", determinante);
                    break;
                case 0: // sair
                    System.out.println("Obrigado por utilizar nosso programa");
                    sair = true;
                    break;
                default: // opcao inválida
                    System.out.println("\nOpção inválida. Encerrando o programa.");
                    break;
            }
        }

    }

}
