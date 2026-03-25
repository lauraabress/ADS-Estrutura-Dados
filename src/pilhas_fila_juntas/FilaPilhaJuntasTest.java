package pilhas_fila_juntas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPilhaJuntasTest {

    Fila fila;
    Pilha pilha;

    Pessoa pA;
    Pessoa pB;
    Pessoa pC;
    Pessoa pD;

    @BeforeEach
    void init(){
        fila = new Fila();
        pilha = new Pilha();
        pA = new Pessoa("A", null);
        pB = new Pessoa("B", null);
        pC = new Pessoa("C", null);
        pD = new Pessoa("D", null);
    }

    @Test
    void deFilaParaPilha(){
        fila.enqueue(pA);
        fila.enqueue(pB);
        fila.enqueue(pC);
        fila.enqueue(pD);
        assertEquals("A", fila.inicio.getNome());
        assertEquals("D", fila.fim.getNome());
        pilha.push(fila.dequeue());
        pilha.push(fila.dequeue());
        pilha.push(fila.dequeue());
        pilha.push(fila.dequeue());
        assertTrue(fila.isEmpty());
        assertEquals("D", pilha.topo.nome);

    }

    @Test
    void dePilhaParaFila(){
        pilha.push(pA);
        pilha.push(pB);
        pilha.push(pC);
        pilha.push(pD);
        assertEquals("D", pilha.topo.getNome());
        fila.enqueue(pilha.pop());
        fila.enqueue(pilha.pop());
        fila.enqueue(pilha.pop());
        fila.enqueue(pilha.pop());
        assertTrue(pilha.isEmpty());
        assertEquals("D", fila.inicio.getNome());
        assertEquals("A", fila.fim.getNome());
    }

    @Test
    void dePilhaParaPilha(){
        Pilha pilha2 = new Pilha();

        pilha.push(pA);
        pilha.push(pB);
        pilha.push(pC);
        pilha.push(pD);

        // topo = D
        assertEquals("D", pilha.topo.getNome());

        pilha2.push(pilha.pop());
        pilha2.push(pilha.pop());
        pilha2.push(pilha.pop());
        pilha2.push(pilha.pop());

        assertTrue(pilha.isEmpty());

        // topo continua sendo D
        assertEquals("A", pilha2.topo.getNome());
    }

    @Test
    void deFilaParaFila(){
        Fila fila2 = new Fila();

        fila.enqueue(pA);
        fila.enqueue(pB);
        fila.enqueue(pC);
        fila.enqueue(pD);

        assertEquals("A", fila.inicio.getNome());

        fila2.enqueue(fila.dequeue());
        fila2.enqueue(fila.dequeue());
        fila2.enqueue(fila.dequeue());
        fila2.enqueue(fila.dequeue());

        assertTrue(fila.isEmpty());

        assertEquals("A", fila2.inicio.getNome());
        assertEquals("D", fila2.fim.getNome());
    }



}