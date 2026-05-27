package algoritmos_busca.busca_binaria;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static algoritmos_busca.GeraVetorUtil.geraOrdenado;
import static org.junit.jupiter.api.Assertions.*;

class BuscaBinariaTest {


    BuscaBinaria buscaBinaria = new BuscaBinaria();

    static int[] vetorOrdenado;

    @BeforeAll
    static void gerarDados() {

        vetorOrdenado = geraOrdenado(50_000);
    }

    @Test
    void testarBuscaBinaria() {

        Random rnd = new Random();

        long inicio, fim;

        long totalTempo = 0;
        long totalPassadas = 0;

        System.out.println("\n=== BUSCA BINÁRIA ===");

        for (int i = 1; i <= 10; i++) {

            int valorBusca = rnd.nextInt(50_000) + 1;

            inicio = System.nanoTime();

            int posicao = buscaBinaria.buscar(vetorOrdenado, valorBusca);

            fim = System.nanoTime();

            long tempo = fim - inicio;

            totalTempo += tempo;
            totalPassadas += BuscaBinaria.passadas;

            System.out.println(
                    "Busca " + i +
                            " | Valor: " + valorBusca +
                            " | Posição: " + posicao +
                            " | Passadas: " + BuscaBinaria.passadas +
                            " | Tempo(ns): " + tempo
            );
        }

        System.out.println("\n=== RESULTADO FINAL ===");

        System.out.println("Média de Passadas: " + (totalPassadas / 10));

        System.out.println("Média de Tempo(ns): " + (totalTempo / 10));
    }

}