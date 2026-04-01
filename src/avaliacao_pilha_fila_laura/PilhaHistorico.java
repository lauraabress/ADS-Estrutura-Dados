package avaliacao_pilha_fila_laura;

public class PilhaHistorico {

    No topo;

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(No no){
        if (!isEmpty()){
            no.proximo = topo;
        }
        topo = no;
    }

    public No pop() {
        if (!isEmpty()) {
            No saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }

}
