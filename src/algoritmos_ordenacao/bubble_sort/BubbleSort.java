package algoritmos_ordenacao.bubble_sort;

public class BubbleSort {

    public int[] ordernar(int[] dados) {
        int[] v = dados.clone();
        int n = v.length;

        for (int i = 0; i < n - 1; i++) {
            boolean trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }

        return v;
    }

}