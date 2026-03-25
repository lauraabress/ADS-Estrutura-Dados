package exercicios_pilha_fila.fila.ex1;

import filas.fila_prioridade.minha_pesquisa.prioridade_int.PessoaInt;

public class FilaPrioridade {

    No inicio;
    No fim;

    public boolean isEmpty() {
        return inicio == null && fim == null;
    }

    public void enqueue(No novaTarefa) {

        if (isEmpty()) {
            inicio = novaTarefa;
            fim = novaTarefa;
            return;
        }

        // se a nova tarefa tem prioridade maior que a primeira
        if (novaTarefa.getPrioridade() > inicio.getPrioridade()) {
            novaTarefa.proximo = inicio;
            inicio = novaTarefa;
            return;
        }

        No atual = inicio;

        // percorre a fila até encontrar posição correta
        while (atual.proximo != null &&
                atual.proximo.getPrioridade() >= novaTarefa.getPrioridade()) {

            atual = atual.proximo;
        }

        novaTarefa.proximo = atual.proximo;
        atual.proximo = novaTarefa;

        if (novaTarefa.proximo == null) {
            fim = novaTarefa;
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
        No atual = inicio;

        while (atual != null) {
            resultado += atual.getIdTarefa() + "(" + atual.getPrioridade() + ") | ";
            atual = atual.proximo;
        }

        return resultado;
    }

    public int somarQtdTarefas(){
        int soma = 0;
        No atual = inicio;

        while (atual != null) {
            soma++;
            atual = atual.proximo;
        }
        return soma;
    }

    public double somarValoresEntregas(){
        double soma = 0;
        No atual = inicio;

        while (atual != null) {
            soma += atual.getValorEntrega();
            atual = atual.proximo;
        }
        return soma;
    }

}
