package estruturas_lineares.listas;

public class Lista {

    int qtd = 0;
    No pontoInicial;

    boolean isEmpty(){
        return qtd == 0;
    }

    void add(No novoNo){
        if(isEmpty()){
            pontoInicial = novoNo;
        } else {
            No ultimo = buscaUltimo();
            ultimo.proximo = novoNo;
            novoNo.anterior = ultimo;
        }
        qtd++;
    }

    void addPosicao(No novoNo, int posicao){

        if (isEmpty()) {
            pontoInicial = novoNo;
        }

        if (posicao == 0){
            if (pontoInicial != null){
                novoNo.proximo = pontoInicial;
                pontoInicial.anterior = novoNo;
            }
            pontoInicial = novoNo;
        } else {
            No atual = buscaPosicao(posicao);

            if (atual == null){
                No ultimo = buscaUltimo();
                ultimo.proximo = novoNo;
                novoNo.anterior = ultimo;
            } else {
                No anterior = atual.anterior;

                anterior.proximo = novoNo;
                novoNo.anterior = anterior;

                novoNo.proximo = atual;
                atual.anterior = novoNo;
            }
        }
        qtd++;
    }

    void remove(int posicao){
        if(!isEmpty() && posicao <= qtd){
            No remover = buscaPosicao(posicao);
            if (remover == null){
                return;
            }
            if (remover.anterior != null){
                remover.anterior.proximo = remover.proximo;
            }
            if (remover.proximo != null) {
                remover.proximo.anterior = remover.anterior;
            }
            if (remover == pontoInicial){
                pontoInicial = remover.proximo;
            }
            qtd--;
        }
    }

    String view(){
        String ret = "";
        No atual = pontoInicial;
        for (int i = 0; i < qtd; i++){
            ret += atual.valor + "|";
            atual = atual.proximo;
        }
        return ret;
    }

    private No buscaUltimo(){
        No ultimo = pontoInicial;
        while(ultimo.proximo != null){
            ultimo = ultimo.proximo;
        }
        return ultimo;
    }

    private No buscaPosicao(int posicao){
        No noPosicao = pontoInicial;
        for (int i = 0; i < posicao; i++){
            noPosicao = noPosicao.proximo;
        }
        return noPosicao;
    }

}
