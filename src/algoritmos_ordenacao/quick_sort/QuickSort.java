package algoritmos_ordenacao.quick_sort;

import java.util.Random;

public class QuickSort {

    private final Random random = new Random();

    public int[] ordernar(int[] dados) {
        int[] v = dados.clone();
        quickSortRecursivo(v, 0, v.length - 1);
        return v;
    }

    private void quickSortRecursivo(int[] v, int baixo, int alto) {
        if (baixo < alto) {
            int indicePivo = particionar(v, baixo, alto);
            quickSortRecursivo(v, baixo, indicePivo - 1);
            quickSortRecursivo(v, indicePivo + 1, alto);
        }
    }

    private int particionar(int[] v, int baixo, int alto) {
        int indiceAleatorio = baixo + random.nextInt(alto - baixo + 1);
        int temp = v[indiceAleatorio]; v[indiceAleatorio] = v[alto]; v[alto] = temp;

        int pivo = v[alto];
        int i = baixo - 1;

        for (int j = baixo; j < alto; j++) {
            if (v[j] <= pivo) {
                i++;
                temp = v[i]; v[i] = v[j]; v[j] = temp;
            }
        }
        temp = v[i + 1]; v[i + 1] = v[alto]; v[alto] = temp;
        return i + 1;
    }

}