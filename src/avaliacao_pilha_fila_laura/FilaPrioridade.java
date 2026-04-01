package avaliacao_pilha_fila_laura;

public class FilaPrioridade {

    No inicio;
    No fim;

    public boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public void enqueue(No no) {

        if (isEmpty()) {
            inicio = no;
            fim = no;
            return;
        }

        if (no.getPrioridade() > inicio.getPrioridade()) {
            no.proximo = inicio;
            inicio = no;
            return;
        }

        No atual = inicio;

        while (atual.proximo != null &&
                atual.proximo.getPrioridade() >= no.getPrioridade()) {

            atual = atual.proximo;
        }

        no.proximo = atual.proximo;
        atual.proximo = no;

        if (no.proximo == null) {
            fim = no;
        }
    }

    public No dequeue() {
        
        No noExcluido = null;

        if (isEmpty()) {
            return null;
        }

        if (inicio == fim) {
            noExcluido = inicio;
            inicio = null;
            fim = null;
        } else {
            noExcluido = inicio;
            inicio = inicio.proximo;
        }
        return noExcluido;
    }

    public String view() {

        String resultado = "";
        No atual = inicio;

        while (atual != null) {
            resultado += atual.getIdPedido() + "(" + atual.getPrioridade() + ") | ";
            atual = atual.proximo;
        }

        return resultado;
    }
}
