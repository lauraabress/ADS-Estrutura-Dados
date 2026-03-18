package filas.fila_prioridade.minha_pesquisa.prioridade_int;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class FilaPrioridadeIntTest {

    @Test
    public void testePrioridadeInteira() {

        FilaPrioridadeInt fila = new FilaPrioridadeInt();

        fila.enqueue(new PessoaInt("Ana", 2, null));
        fila.enqueue(new PessoaInt("Carlos", 1, null));
        fila.enqueue(new PessoaInt("Maria", 5, null));
        fila.enqueue(new PessoaInt("Pedro", 3, null));
        fila.enqueue(new PessoaInt("João", 4, null));

        String resultado = fila.view();

        System.out.println(resultado);

        assertEquals(
                "Maria(5) | João(4) | Pedro(3) | Ana(2) | Carlos(1) | ",
                resultado
        );
    }
}