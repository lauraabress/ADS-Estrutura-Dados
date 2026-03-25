package exercicios_pilha_fila.fila.ex1;

import filas.fila_prioridade.minha_pesquisa.prioridade_int.PessoaInt;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class No {

    public int idTarefa;
    public Double valorEntrega;
    private int prioridade;
    No proximo;

}
