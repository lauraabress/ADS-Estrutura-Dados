package pilhas.string;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PilhaLivro {

    private Livro topo;

    public boolean isEmpty(){
        return topo == null;
    }

    // MÉTODO QUE EMPILHA
    // O BULDER É COMO SE ESTIVESSE UM CONSTRUTOR PARA CADA ATRIBUTO SEPARADO!
    public void push(Livro livro){
        if (!isEmpty()){
            livro.proximo = topo;
        }
        topo = livro;
    }

    public Livro pop(){
        if(!isEmpty()){
            Livro saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }

    // PEEK RETORNA O VALOR DO TOPO
    public Livro peek(){
        if (isEmpty()){
            return null;
        }
        return topo;
    }

    // VIEW RETORNS A PILHA TODA
    public String view(){
        if (isEmpty()){
            return "";
        }

        PilhaLivro aux = this;
        StringBuilder retorno = new StringBuilder();

        while(aux.topo != null){
            retorno.append(aux.topo.getTitulo()).append("\n");
            aux.topo = topo.proximo;
        }
        return retorno.toString();
    }

}
