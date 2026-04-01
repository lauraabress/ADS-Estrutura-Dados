package avaliacao_pilha_fila_laura;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class No {

    private int idPedido;
    private double valorFrete;
    private int prioridade;
    No proximo;

}
