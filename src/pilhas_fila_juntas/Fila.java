package pilhas_fila_juntas;

public class Fila {

    public Pessoa inicio;
    public Pessoa fim;

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
    public Pessoa dequeue(){
        if(!isEmpty()) {
            Pessoa saiu = inicio;
            if (inicio == fim) {
                inicio = null;
                fim = null;
            } else {
                inicio = inicio.proximo;
            }
            return saiu;
        }
        return null;
    }

}
