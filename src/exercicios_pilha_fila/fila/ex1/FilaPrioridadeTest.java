package exercicios_pilha_fila.fila.ex1;

import filas.fila_simples.FilaPessoa;
import filas.fila_simples.Pessoa;
import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilaPrioridadeTest {

    FilaPrioridade fila;
    No tarefa1;
    No tarefa2;
    No tarefa3;

    @BeforeEach
    void init() {
        fila = new FilaPrioridade();
        tarefa1 = new No(1, 10.00, 3, null);
        tarefa2 = new No(2, 20.00, 9, null);
        tarefa3 = new No(3, 30.00, 6, null);
    }

    @Test
    @Description("Inserção na fila")
    void insercaoTest(){
        fila.enqueue(tarefa1);
        fila.enqueue(tarefa2);
        fila.enqueue(tarefa3);
        assertEquals(9, fila.inicio.getPrioridade());
        assertEquals(3, fila.fim.getPrioridade());
    }

}