package estruturas_nao_lineares.arvores;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    BinarySearchTree arvore;

    @BeforeEach
    void init(){
        arvore = new BinarySearchTree();
    }

    @Test
    void insere(){
        arvore.insert(44);
        arvore.insert(33);
        arvore.insert(22);
        arvore.insert(25);
        arvore.insert(55);
        arvore.insert(52);
        arvore.insert(34);
        arvore.insert(35);
        arvore.insert(54);
        arvore.insert(51);
        arvore.printTree();
    }

    @Test
    void busca() {
        arvore.insert(44);
        arvore.insert(33);
        arvore.insert(22);
        arvore.insert(25);
        arvore.insert(55);
        arvore.insert(52);
        arvore.insert(34);
        arvore.insert(35);
        arvore.insert(54);
        arvore.insert(51);



        arvore.search(25);   // deve encontrar: nível 4, altura 1
        arvore.search(44);   // deve encontrar: nível 1, altura 4
        arvore.search(99);   // não encontrado
        arvore.printTree();
    }

    @Test
    void remove() {
        arvore.insert(44);
        arvore.insert(33);
        arvore.insert(22);
        arvore.insert(25);
        arvore.insert(55);
        arvore.insert(52);
        arvore.insert(34);
        arvore.insert(35);
        arvore.insert(54);
        arvore.insert(51);

        arvore.printTree();

        arvore.remove(44);   // nó com dois filhos
        arvore.remove(55);   // nó com um filho
        arvore.remove(99);   // não encontrado

        arvore.printTree();
    }

    @Test
    void caminho() {
        arvore.insert(44);
        arvore.insert(33);
        arvore.insert(22);
        arvore.insert(25);
        arvore.insert(55);
        arvore.insert(52);
        arvore.insert(34);
        arvore.insert(35);
        arvore.insert(54);
        arvore.insert(51);

        System.out.println("In-Order:  " + arvore.caminho(TipoCaminho.IN_ORDER));
        System.out.println("Pre-Order: " + arvore.caminho(TipoCaminho.PRE_ORDER));
        System.out.println("Pos-Order: " + arvore.caminho(TipoCaminho.POS_ORDER));
    }

    @Test
    void balanceamento() {
        // árvore degenerada (vira uma lista ligada sem balanceamento)
        arvore.insert(10);
        arvore.insert(20);
        arvore.insert(30);
        arvore.insert(40);
        arvore.insert(50);

        System.out.println("=== Antes ===");
        arvore.printTree();

        arvore.balance();

        System.out.println("=== Depois ===");
        arvore.printTree();
    }

}