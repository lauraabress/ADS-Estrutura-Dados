package pilhas.nu_inteiro;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ElementoTest {

    Elemento pilha;

    @BeforeEach
    public void inicializa() {
        pilha = new Elemento(0);
    }

    @Test
    public void pushTest() {
        pilha.push(1);
        pilha.push(5);
        pilha.push(8);
        int valorTopo = pilha.peek();
        Assertions.assertEquals(8, valorTopo);
        String view = pilha.view();
        Assertions.assertEquals("8 - 5 - 1", view);
    }

    @Test
    public void popTest() {
        pilha.push(1);
        pilha.push(2);
        pilha.pop();
        Assertions.assertEquals(1, pilha.topo.valor);
        pilha.pop();
        Assertions.assertTrue(pilha.isEmpty());
    }

    @Test
    public void peekTest() {
        Assertions.assertEquals(0, pilha.peek());
        pilha.push(1);
        pilha.push(2);
        pilha.push(3);
        Assertions.assertEquals(3, pilha.peek());
    }

    @Test
    public void pilhaVazia() {
        pilha.pop();
        Assertions.assertTrue(pilha.isEmpty());
    }

}