package pilhas_fila_juntas;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Pessoa {
    public String nome;
    public Pessoa proximo;
}
