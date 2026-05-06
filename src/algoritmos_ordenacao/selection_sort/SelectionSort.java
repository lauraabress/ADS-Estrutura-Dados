package algoritmos_ordenacao.selection_sort;

public class SelectionSort {

    public int[] ordernar(int[] dados) {
        int[] v = dados.clone();
        int n = v.length;

        for (int i = 0; i < n - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < n; j++) {
                if (v[j] < v[indiceMenor]) {
                    indiceMenor = j;
                }
            }
            int temp = v[indiceMenor];
            v[indiceMenor] = v[i];
            v[i] = temp;
        }

        return v;
    }

}