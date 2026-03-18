package filas.fila_prioridade.minha_pesquisa.prioridade_boolean;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pessoa {

    private String nome;
    private boolean prioridade;
    Pessoa proximo;

}
