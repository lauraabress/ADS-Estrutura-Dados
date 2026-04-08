package estruturas_lineares.listas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaTest {

    Lista lista;

    @BeforeEach
    void init(){
        lista = new Lista();
    }

    @Test
    void addTest(){
        assertTrue(lista.isEmpty());
        lista.add(new No("A"));
        lista.add(new No("B"));
        lista.add(new No("C"));
        assertFalse(lista.isEmpty());
        assertEquals(3, lista.qtd);
        assertEquals("A|B|C|", lista.view());
    }

    @Test
    void removePrimeiroTest(){
        lista.add(new No("A"));
        lista.add(new No("B"));
        lista.add(new No("C"));
        lista.add(new No("D"));
        lista.remove(3);
        assertEquals("A|B|C|", lista.view());
    }

    @Test
    void removeMeioTest(){
        lista.add(new No("A"));
        lista.add(new No("B"));
        lista.add(new No("C"));
        lista.add(new No("D"));
        lista.remove(2);
        assertEquals("A|B|D|", lista.view());
    }

    @Test
    void addInicioTest(){
        lista.add(new No("B"));
        lista.add(new No("C"));

        lista.addPosicao(new No("A"), 0);

        assertEquals("A|B|C|", lista.view());
    }

    @Test
    void addMeioTest(){
        lista.add(new No("A"));
        lista.add(new No("C"));

        lista.addPosicao(new No("B"), 1);

        assertEquals("A|B|C|", lista.view());
    }

    @Test
    void addFinalTest(){
        lista.add(new No("A"));
        lista.add(new No("B"));

        lista.addPosicao(new No("C"), 2);

        assertEquals("A|B|C|", lista.view());
    }

}