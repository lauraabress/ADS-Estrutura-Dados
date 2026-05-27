package algoritmos_busca;

import java.util.Random;

public class GeraVetorUtil {

    public static int[] geraOrdenado(int tamanho) {
        int[] v = new int[tamanho];
        for (int i = 0; i < tamanho; i++) v[i] = i + 1;
        return v;
    }

    public static int[] geraAleatorio(int tamanho) {
        int[] v = new int[tamanho];
        Random rnd = new Random();

        for (int i = 0; i < tamanho; i++) {
            v[i] = rnd.nextInt(50_001);
        }

        return v;
    }

}