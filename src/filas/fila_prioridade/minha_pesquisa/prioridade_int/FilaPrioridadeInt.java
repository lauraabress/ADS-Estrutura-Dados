package filas.fila_prioridade.minha_pesquisa.prioridade_int;

public class FilaPrioridadeInt {

    PessoaInt inicio;
    PessoaInt fim;

    public boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public void enqueue(PessoaInt novaPessoa) {

        if (isEmpty()) {
            inicio = novaPessoa;
            fim = novaPessoa;
            return;
        }

        // se a nova pessoa tem prioridade maior que a primeira
        if (novaPessoa.getPrioridade() > inicio.getPrioridade()) {

            novaPessoa.proximo = inicio;
            inicio = novaPessoa;
            return;
        }

        PessoaInt atual = inicio;

        // percorre a fila até encontrar posição correta
        while (atual.proximo != null &&
                atual.proximo.getPrioridade() >= novaPessoa.getPrioridade()) {

            atual = atual.proximo;
        }

        novaPessoa.proximo = atual.proximo;
        atual.proximo = novaPessoa;

        if (novaPessoa.proximo == null) {
            fim = novaPessoa;
        }
    }

    public void dequeue() {

        if (isEmpty()) {
            return;
        }

        if (inicio == fim) {
            inicio = null;
            fim = null;
        } else {
            inicio = inicio.proximo;
        }
    }

    public String view() {

        String resultado = "";
        PessoaInt atual = inicio;

        while (atual != null) {
            resultado += atual.getNome() + "(" + atual.getPrioridade() + ") | ";
            atual = atual.proximo;
        }

        return resultado;
    }
}
