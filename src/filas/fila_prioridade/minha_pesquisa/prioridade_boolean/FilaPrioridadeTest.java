package filas.fila_prioridade.minha_pesquisa.prioridade_boolean;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FilaPrioridadeTest {

    @Test
    public void testeFilaComPrioridade() {

        FilaPrioridade fila = new FilaPrioridade();

        Pessoa p1 = new Pessoa("Ana", false, null);
        Pessoa p2 = new Pessoa("Carlos", false, null);
        Pessoa p3 = new Pessoa("Maria", true, null);
        Pessoa p4 = new Pessoa("Pedro", false, null);
        Pessoa p5 = new Pessoa("João", true, null);

        fila.enqueue(p1);
        fila.enqueue(p2);
        fila.enqueue(p3);
        fila.enqueue(p4);
        fila.enqueue(p5);

        String resultado = fila.view();

        System.out.println(resultado);

        assertEquals("Maria | João | Ana | Carlos | Pedro | ", resultado);
    }

    @Test
    public void testeRemocao() {

        FilaPrioridade fila = new FilaPrioridade();

        fila.enqueue(new Pessoa("Ana", false, null));
        fila.enqueue(new Pessoa("Maria", true, null));
        fila.enqueue(new Pessoa("Pedro", false, null));

        fila.dequeue();

        String resultado = fila.view();

        System.out.println(resultado);

        assertEquals("Ana | Pedro | ", resultado);
    }
}