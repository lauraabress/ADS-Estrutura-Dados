package filas.fila_prioridade.minha_pesquisa.prioridade_boolean;

public class FilaPrioridade {

    Pessoa inicio;
    Pessoa fim;

    // verifica se a fila está vazia
    public boolean isEmpty() {
        return inicio == null && fim == null;
    }

    // adicionar pessoa na fila
    public void enqueue(Pessoa novaPessoa) {

        if (isEmpty()) {
            inicio = novaPessoa;
            fim = novaPessoa;
            return;
        }

        // se for prioridade ela entra antes das pessoas normais
        if (novaPessoa.isPrioridade()) {

            // se o primeiro não for prioridade
            if (!inicio.isPrioridade()) {
                novaPessoa.proximo = inicio;
                inicio = novaPessoa;
                return;
            }

            // procurar o último com prioridade
            Pessoa atual = inicio;

            while (atual.proximo != null && atual.proximo.isPrioridade()) {
                atual = atual.proximo;
            }

            novaPessoa.proximo = atual.proximo;
            atual.proximo = novaPessoa;

            if (novaPessoa.proximo == null) {
                fim = novaPessoa;
            }

        } else {

            // pessoa normal entra no final
            fim.proximo = novaPessoa;
            fim = novaPessoa;
        }
    }

    // remover da fila
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

    // visualizar fila
    public String view() {

        String resultado = "";
        Pessoa atual = inicio;

        while (atual != null) {
            resultado += atual.getNome() + " | ";
            atual = atual.proximo;
        }

        return resultado;
    }
}
