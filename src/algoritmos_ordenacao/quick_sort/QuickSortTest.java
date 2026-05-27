package algoritmos_ordenacao.quick_sort;

import static algoritmos_ordenacao.GeraVetorUtil.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

class QuickSortTest {

    QuickSort quickSort = new QuickSort();

    static int[] v11, v12, v13;
    static int[] v21, v22, v23;
    static int[] v31, v32, v33;

    @BeforeAll
    static void gerarDados() {
        v11 = geraOrdenado(50);
        v12 = geraAleatorio(50);
        v13 = geraInverso(50);

        v21 = geraOrdenado(500);
        v22 = geraAleatorio(500);
        v23 = geraInverso(500);

        v31 = geraOrdenado(50_000);
        v32 = geraAleatorio(50_000);
        v33 = geraInverso(50_000);
    }

//    @Test
//    void testarTamanho50() {
//        long inicio, fim;
//
//        System.out.println("\n=== Tamanho 50 ===");
//
//        inicio = System.currentTimeMillis();
//        quickSort.ordernar(v11);
//        fim = System.currentTimeMillis();
//        System.out.println("50 - ordenado  | " + (fim - inicio) + " ms");
//
//        inicio = System.currentTimeMillis();
//        quickSort.ordernar(v12);
//        fim = System.currentTimeMillis();
//        System.out.println("50 - aleatorio | " + (fim - inicio) + " ms");
//
//        inicio = System.currentTimeMillis();
//        int[] ord = quickSort.ordernar(v13);
//        fim = System.currentTimeMillis();
//        System.out.println("50 - inverso   | " + (fim - inicio) + " ms");
//        for (int i = 0; i < 50; i++) {
//            assertEquals(i, ord[i]);
//        }
//    }

    @Test
    void testarTamanho500() {
        long inicio, fim;

        System.out.println("\n=== Tamanho 500 ===");

        inicio = System.currentTimeMillis();
        quickSort.ordernar(v21);
        fim = System.currentTimeMillis();
        System.out.println("500 - ordenado  | " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        quickSort.ordernar(v22);
        fim = System.currentTimeMillis();
        System.out.println("500 - aleatorio | " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        int[] ord = quickSort.ordernar(v23);
        fim = System.currentTimeMillis();
        System.out.println("500 - inverso   | " + (fim - inicio) + " ms");
        for (int i = 0; i < 500; i++) {
            assertEquals(i, ord[i]);
        }
    }

    @Test
    @Timeout(value = 10, unit = TimeUnit.MINUTES)
    void testarTamanho50000() {
        long inicio, fim;

        System.out.println("\n=== Tamanho 50.000 ===");

        inicio = System.currentTimeMillis();
        quickSort.ordernar(v31);
        fim = System.currentTimeMillis();
        System.out.println("50000 - ordenado  | " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        quickSort.ordernar(v32);
        fim = System.currentTimeMillis();
        System.out.println("50000 - aleatorio | " + (fim - inicio) + " ms");

        inicio = System.currentTimeMillis();
        int[] ord = quickSort.ordernar(v33);
        fim = System.currentTimeMillis();
        System.out.println("50000 - inverso   | " + (fim - inicio) + " ms");
        for (int i = 0; i < 50_000; i++) {
            assertEquals(i, ord[i]);
        }
    }
}