package algoritmos_ordenacao.heap_sort;

public class HeapSort {

    public int[] ordernar(int[] dados) {
        int[] v = dados.clone();
        int n = v.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(v, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = v[0]; v[0] = v[i]; v[i] = temp;
            heapify(v, i, 0);
        }

        return v;
    }

    private void heapify(int[] v, int n, int i) {
        int maior = i;
        int esquerda = 2 * i + 1;
        int direita  = 2 * i + 2;

        if (esquerda < n && v[esquerda] > v[maior]) maior = esquerda;
        if (direita  < n && v[direita]  > v[maior]) maior = direita;

        if (maior != i) {
            int temp = v[i]; v[i] = v[maior]; v[maior] = temp;
            heapify(v, n, maior);
        }
    }

}