package filas.fila_simples;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPessoaTest {

    FilaPessoa fila;
    Pessoa p1;
    Pessoa p2;
    Pessoa p3;

    @BeforeEach
    void init() {
        fila = new FilaPessoa();
        p1 = new Pessoa("Laura", null);
        p2 = new Pessoa("Arthur", null);
        p3 = new Pessoa("Illy", null);
    }

    @Test
    @Description("Inserção na fila")
    void inserirTest() {
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        assertEquals("Laura", fila.inicio.getNome());
        assertEquals("Illy", fila.fim.getNome());
    }

    @Test
    @Description("Remoção da fila")
    void removerTest() {
        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.dequeue();
        assertEquals("Arthur", fila.inicio.getNome());
        assertEquals("Illy", fila.fim.getNome());
        fila.dequeue();
        assertEquals("Illy", fila.inicio.getNome());
        assertEquals("Illy", fila.fim.getNome());
        fila.dequeue();
        assertTrue(fila.isEmpty());
    }

    @Test
    @Description("Listar a ordem da fila")
    void viewTest(){
        fila.enqueue(p2); // 1. Arthur
        fila.enqueue(p3); // 2. Illy
        fila.enqueue(p1); // 3. Laura
        assertEquals("Arthur | Illy | Laura | ", fila.view());
    }

}