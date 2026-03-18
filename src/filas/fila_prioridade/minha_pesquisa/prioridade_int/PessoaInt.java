package filas.fila_prioridade.minha_pesquisa.prioridade_int;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PessoaInt {

    private String nome;
    private int prioridade;
    PessoaInt proximo;

}

