import java.util.Scanner;

public class Main {

    public static void imprimirCadeiras(char[][] cadeiras) {
        System.out.println("Mapa de Cadeiras:");
        for (int i = 0; i < cadeiras.length; i++) {
            for (int j = 0; j < cadeiras[i].length; j++) {
                System.out.print(cadeiras[i][j] + " "); // Exibe os lugares
            }
            System.out.println();
        }
    }

    public static boolean verificarCadeira(int i, int j, char[][] cadeira){
        return cadeira[i][j] == 'L';

    }

    public static void main(String[] args) {

        int linhas = 5;
        int colunas = 5;

        char[][] cadeiras = new char[linhas][colunas];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < linhas; i++) {
            for (int j = 0; j < colunas; j++) {
                cadeiras[i][j] = 'L';
            }
        }


        int opcao = 0;
        do {
            System.out.print("Digite 1 para escolher sua cadeira e 2 para sair: ");
            opcao = sc.nextInt();
            switch (opcao){
                case 1:
                    imprimirCadeiras(cadeiras);

                    System.out.print("Digite a linha da cadeira (0-" + (linhas - 1) + "): ");
                    int linha = sc.nextInt();
                    System.out.print("Digite a coluna da cadeira (0-" + (colunas - 1) + "): ");
                    int coluna = sc.nextInt();

                    // Verifica se os valores estão dentro dos limites da matriz
                    if (linha >= 0 && linha < linhas && coluna >= 0 && coluna < colunas) {
                        if (verificarCadeira(linha, coluna, cadeiras)) {
                            cadeiras[linha][coluna] = 'X'; // Marca como ocupada
                            System.out.println("Cadeira reservada com sucesso!\n");
                        } else {
                            System.out.println("Essa cadeira já está ocupada! Escolha outra.\n");
                        }
                    } else {
                        System.out.println("Posição inválida! Escolha uma posição dentro do mapa.\n");
                    }

                    imprimirCadeiras(cadeiras);
                    break;
            }
        } while (opcao != 2);
        sc.close();

    }
}