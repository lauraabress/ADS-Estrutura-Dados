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
        fila.enqueue(p1); // add pessoa 1 (Laura)
        fila.enqueue(p2); // add pessoa 2 (Arthur)
        fila.enqueue(p3); // add pessoa 3 (Illy)
        fila.dequeue(); // tira o primeiro da fila (Laura)
        assertEquals("Arthur", fila.inicio.getNome()); // verifica se o início da fila é o Arthur
        assertEquals("Illy", fila.fim.getNome()); // verifica se o início da fila é a Illy
        fila.dequeue(); // tira o primeiro da fila (Arthur)
        assertEquals("Illy", fila.inicio.getNome()); // verifica se o início da fila é a Illy
        assertEquals("Illy", fila.fim.getNome()); // verifica se o fim da fila é a Illy
        fila.dequeue(); // tira o primeiro da fila (Illy)
        assertTrue(fila.isEmpty()); // verifica se é verdade que está null
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