package exercicios_pilha_fila.fila.ex1;

public class Pilha {

    No topo;

    public boolean isEmpty() {
        return topo == null;
    }

    // EMPILHAR
    public void push(No novo) {
        if (!isEmpty()) {
            novo.proximo = topo;
        }
        topo = novo;
    }

    // DESEMPILHAR
    public No pop() {
        if (!isEmpty()) {
            No removido = topo;
            topo = topo.proximo;
            return removido;
        }
        return null;
    }

    // VER TOPO (sem remover)
    public No peek() {
        return topo;
    }

    // VISUALIZAR PILHA
    public String view() {
        String resultado = "";
        No atual = topo;

        while (atual != null) {
            resultado += atual.getIdTarefa() + "(" + atual.getPrioridade() + ") | ";
            atual = atual.proximo;
        }

        return resultado;
    }

    // CONTAR ELEMENTOS
    public int size() {
        int count = 0;
        No atual = topo;

        while (atual != null) {
            count++;
            atual = atual.proximo;
        }

        return count;
    }
}