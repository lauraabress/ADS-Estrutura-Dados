package pilhas.string;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Livro {

    private String titulo;
    private int nuPaginas;
    private int anoLancamento;
    public Livro proximo;

}
