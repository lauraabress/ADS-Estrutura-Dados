package pilhas_fila_juntas;

public class Pilha {

    Pessoa topo;

    public boolean isEmpty(){
        return topo == null;
    }

    public void push(Pessoa pessoa){
        if (!isEmpty()){
            pessoa.proximo = topo;
        }
        topo = pessoa;
    }

    public Pessoa pop() {
        if (!isEmpty()) {
            Pessoa saiu = topo;
            topo = topo.proximo;
            return saiu;
        }
        return null;
    }

}
