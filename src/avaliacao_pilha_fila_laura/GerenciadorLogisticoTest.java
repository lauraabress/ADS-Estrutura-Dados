package avaliacao_pilha_fila_laura;

import jdk.jfr.Description;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GerenciadorLogisticoTest {

    FilaPrioridade fila;
    PilhaHistorico pilha;
    GerenciadorLogistico gl;

    No n1;
    No n2;
    No n3;
    No n4;
    No n5;

    @BeforeEach
    void init(){
        fila = new FilaPrioridade();
        pilha = new PilhaHistorico();
        gl = new GerenciadorLogistico();
        n1 = new No(1, 10.00, 2, null);
        n2 = new No(2, 20.00, 5, null);
        n3 = new No(3, 30.00, 3, null);
        n4 = new No(4, 40.00, 1, null);
        n5 = new No(5, 50.00, 4, null);
        // ORDEM PRIORIDADE: 2, 5, 3, 1, 4
    }

    @Test
    @Description("Validar se um pedido \"desfeito\" volta para a posição correta na fila de prioridade")
    void desfeitoVoltaPrioridade(){
        gl.receberPedido(1, 10.00, 2);
        gl.receberPedido(2, 20.00, 5);
        gl.receberPedido(3, 30.00, 3);
        gl.receberPedido(4, 40.00, 1);
        gl.receberPedido(5, 50.00, 4);
        gl.processarProximo();
        gl.desfazerProcessamento();
        assertEquals(2, gl.filaPrioridade.inicio.getIdPedido());
        assertEquals(4, gl.filaPrioridade.fim.getIdPedido());
    }

    @Test
    @Description("Validar o cálculo da soma total de valores entre as duas estruturas simultaneamente")
    void calcSomaFreteTotal(){
        gl.receberPedido(1, 10.00, 2);
        gl.receberPedido(2, 20.00, 5);
        gl.receberPedido(3, 30.00, 3);
        gl.receberPedido(4, 40.00, 1);
        gl.receberPedido(5, 50.00, 4);
        double total = gl.vlTotalFretePilhaFila();
        assertEquals(150.00, total);
    }

    @Test
    @Description("Validar o comportamento de \"Desfazer\" em uma pilha vazia")
    void desfazerPilhaVazia(){
        gl.desfazerProcessamento();
    }

    @Test
    @Description("Ordem correta na fila")
    void ordemCorretaFila(){
        gl.receberPedido(1, 10.00, 2);
        gl.receberPedido(2, 20.00, 5);
        gl.receberPedido(3, 30.00, 3);
        gl.receberPedido(4, 40.00, 1);
        gl.receberPedido(5, 50.00, 4);
        assertEquals(2, gl.filaPrioridade.inicio.getIdPedido());
        assertEquals(4, gl.filaPrioridade.fim.getIdPedido());
    }

    @Test
    @Description("Ordem correta na pilha")
    void ordemCorretaPilha(){
        gl.receberPedido(1, 10.00, 2);
        gl.receberPedido(2, 20.00, 5);
        gl.receberPedido(3, 30.00, 3);
        gl.receberPedido(4, 40.00, 1);
        gl.receberPedido(5, 50.00, 4);
        gl.processarProximo(); // id: 2
        gl.processarProximo(); // id: 5
        gl.processarProximo(); // id: 3
        gl.processarProximo(); // id: 1
        gl.processarProximo(); // id: 4
        gl.desfazerProcessamento();
        gl.processarProximo();
        assertEquals(4, gl.pilhaHistorico.topo.getIdPedido());
    }

}