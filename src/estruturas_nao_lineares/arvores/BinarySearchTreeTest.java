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
        arvore.printTree();
    }

}