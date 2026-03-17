package pilhas.nu_inteiro;

public class Elemento {

    int valor;
    Elemento proximo;
    Elemento topo;

    // CONSTRUTOR
    Elemento(int vl){
        this.valor = vl;
        this.proximo = null;
        this.topo = null;
    }

    // VER SE A PILHA ESTÁ VAZIA OU NÃO
    public boolean isEmpty(){
        return topo == null;
    }

    // INSERÇÃO DE UM ELEMENTO NA PILHA
    public void push(int vl){
        Elemento novo = new Elemento(vl);
        // SE ESTÁ NULL
        if (!isEmpty()) {
            novo.proximo = topo;
        }
        topo = novo;
    }

    // REMOÇÃO DE UM ELEMENTO DA PILHA
    public void pop(){
        if (!isEmpty()){
            topo = topo.proximo;
        }
    }

    // PEEK: RETORNA O VALOR/NÚMERO/DADO QUE O USUÁRIO QUER SABER
    public int peek(){
        if (isEmpty()){
            return 0;
        }
        return topo.valor;
    }

    // SABER TODOS OS ELEMENTOS/VALORS QUE ESTÃO NA PILHA
    public String view(){
        if (isEmpty()){
            return "";
        } else {
            String result = "";
            Elemento aux = topo;
            while(aux != null){
                result += aux.valor + " - ";
                aux = aux.proximo;
            }
            // PARA TIRAR O "-" QUE FICA SOBRANDO NO FINAL
            return result.substring(0, result.length()-3);
        }
    }
}
