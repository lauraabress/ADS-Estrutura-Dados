package algoritmos_busca.busca_sequencial;

public class BuscaSequencial {

    public static int passadas = 0;

    public int buscar(int[] vetor, int valor) {

        passadas = 0;

        for (int i = 0; i < vetor.length; i++) {

            passadas++;

            if (vetor[i] == valor) {
                return i;
            }
        }

        return -1;
    }
}
