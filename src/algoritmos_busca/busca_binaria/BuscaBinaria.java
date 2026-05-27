package algoritmos_busca.busca_binaria;

public class BuscaBinaria {

    public static int passadas = 0;

    public static int buscar(int[] vetor, int valor) {

        passadas = 0;

        int inicio = 0;
        int fim = vetor.length - 1;

        while (inicio <= fim) {

            passadas++;

            int meio = (inicio + fim) / 2;

            if (vetor[meio] == valor) {
                return meio;
            }

            if (valor < vetor[meio]) {
                fim = meio - 1;
            } else {
                inicio = meio + 1;
            }
        }

        return -1;
    }
}
