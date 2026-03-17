package pilhas.desafio;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pilhas.string.Livro;

@Getter
@Setter
@NoArgsConstructor
public class PilhaParentese {

    Parentese topo;

    public boolean isEmpty() {
        return topo == null;
    }

    // MÉTODO QUE EMPILHA
    // O BULDER É COMO SE ESTIVESSE UM CONSTRUTOR PARA CADA ATRIBUTO SEPARADO!
    public void push(Parentese parentese) {
        if (!isEmpty()) {
            parentese.proximo = topo;
        }
        topo = parentese;
    }

    public Parentese pop() {
        if (!isEmpty()) {
            Parentese saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }

}
