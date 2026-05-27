package algoritmos_busca.busca_sequencial;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static algoritmos_busca.GeraVetorUtil.geraAleatorio;

class BuscaSequencialTest {

    BuscaSequencial buscaSequencial = new BuscaSequencial();

    static int[] vetorAleatorio;

    @BeforeAll
    static void gerarDados() {

        vetorAleatorio = geraAleatorio(50_000);
    }

    @Test
    void testarBuscaSequencial() {

        Random rnd = new Random();

        long inicio, fim;

        long totalTempo = 0;
        long totalPassadas = 0;

        System.out.println("\n=== BUSCA SEQUENCIAL ===");

        for (int i = 1; i <= 10; i++) {

            int valorBusca = vetorAleatorio[rnd.nextInt(vetorAleatorio.length)];

            inicio = System.nanoTime();

            int posicao = buscaSequencial.buscar(vetorAleatorio, valorBusca);

            fim = System.nanoTime();

            long tempo = fim - inicio;

            totalTempo += tempo;
            totalPassadas += BuscaSequencial.passadas;

            System.out.println(
                    "Busca " + i +
                            " | Valor: " + valorBusca +
                            " | Posição: " + posicao +
                            " | Passadas: " + BuscaSequencial.passadas +
                            " | Tempo(ns): " + tempo
            );
        }

        System.out.println("\n=== RESULTADO FINAL ===");

        System.out.println("Média de Passadas: " + (totalPassadas / 10));

        System.out.println("Média de Tempo(ns): " + (totalTempo / 10));
    }

}