package filas.fila_simples;

public class FilaPessoa {
    Pessoa inicio;
    Pessoa fim;

    public boolean isEmpty(){
        return inicio == null && fim == null;
    }

    // COLOCAR ALGUEM NA FILA
    public void enqueue(Pessoa entrarNaFila){
        if (isEmpty()){
            inicio = entrarNaFila;
            fim = entrarNaFila;
        } else {
            fim.proximo = entrarNaFila;
            fim = entrarNaFila;
        }
    }

    // REMOVER ALGUEM DA FILA
    public void dequeue(){
        if(!isEmpty()) {
            if (inicio == fim) {
                inicio = null;
                fim = null;
            } else {
                inicio = inicio.proximo;
            }
        }
    }

    // PERCORRER DO PRIMIERO AO ÚLTIMO ELEMENTO
    public String view(){
        FilaPessoa aux = clone();
        String ret = "";
        if (isEmpty()){
            return "";
        } else {
            do {
                ret += aux.inicio.getNome() + " | ";
                aux.inicio = aux.inicio.proximo;
            } while (aux.inicio != null);
        }
        return ret;
    }


    // MÉTODO CLONE: É UMA OUTRA PESSOA COM AS MESAS CARACTERISTICAS
    @Override
    public FilaPessoa clone(){
        FilaPessoa nova = new FilaPessoa();
        nova.inicio = this.inicio;
        nova.fim = this.fim;
        return nova;
    }

}
