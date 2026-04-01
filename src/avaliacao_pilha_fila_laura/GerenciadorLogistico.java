package avaliacao_pilha_fila_laura;

public class GerenciadorLogistico {

    FilaPrioridade filaPrioridade = new FilaPrioridade();
    PilhaHistorico pilhaHistorico = new PilhaHistorico();

    // Insere o pedido na posição correta da fila.
    public void receberPedido(int idPedido, double valor, int prioridade) {
        No novoNo = new No(idPedido, valor, prioridade, null);
        filaPrioridade.enqueue(novoNo);
    }

    // Remove o pedido de maior prioridade da fila e o insere no topo da pilha de histórico
    public void processarProximo() {
        pilhaHistorico.push(filaPrioridade.dequeue());
    }

    // Remove o pedido do topo da PilhaHistorico e o reinsere na
    // FilaPrioridade (respeitando novamente a regra de prioridade).
    // Se a pilha estiver vazia, lançar uma mensagem de erro
    public void desfazerProcessamento() {
        if (pilhaHistorico.isEmpty()){
            System.out.println("A pilha está vazia");
        } else {
            filaPrioridade.enqueue(pilhaHistorico.pop());
        }
    }

    // -- RELATÓRIOS E ESTATÍSTICAS

    // Implementar um método que percorra as duas estruturas e retorne o Valor Total em Fretes (soma
    // do que está na fila + o que está na pilha).
    public double vlTotalFretePilhaFila() {

        double vlFinal = 0;

        No inicioFila = filaPrioridade.inicio;
        while (inicioFila != null){
            vlFinal += inicioFila.getValorFrete();
            inicioFila = inicioFila.proximo;
        }

        No topoPilha = pilhaHistorico.topo;
        while (topoPilha != null){
            vlFinal += topoPilha.getValorFrete();
            topoPilha = topoPilha.proximo;
        }

        return vlFinal;
    }

    // Implementar um método que retorne a quantidade total de pedidos aguardando na fila.
    public int qtdPedidosFila(){

        int qtdPedidos = 0;

        No inicioFila = filaPrioridade.inicio;
        while (inicioFila != null){
            qtdPedidos ++;
            inicioFila = inicioFila.proximo;
        }
        return qtdPedidos;
    }

}
