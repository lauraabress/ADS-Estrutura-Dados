package algoritmos_ordenacao.merge_sort;

public class MergeSort {

    public int[] ordernar(int[] dados) {
        int[] v = dados.clone();
        mergeSortRecursivo(v, 0, v.length - 1);
        return v;
    }

    private void mergeSortRecursivo(int[] v, int esquerda, int direita) {
        if (esquerda < direita) {
            int meio = (esquerda + direita) / 2;
            mergeSortRecursivo(v, esquerda, meio);
            mergeSortRecursivo(v, meio + 1, direita);
            mesclar(v, esquerda, meio, direita);
        }
    }

    private void mesclar(int[] v, int esquerda, int meio, int direita) {
        int n1 = meio - esquerda + 1;
        int n2 = direita - meio;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = v[esquerda + i];
        for (int j = 0; j < n2; j++) R[j] = v[meio + 1 + j];

        int i = 0, j = 0, k = esquerda;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) v[k++] = L[i++];
            else               v[k++] = R[j++];
        }
        while (i < n1) v[k++] = L[i++];
        while (j < n2) v[k++] = R[j++];
    }

}