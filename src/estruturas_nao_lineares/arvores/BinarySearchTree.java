package estruturas_nao_lineares.arvores;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

    private BstNode root;

    public void insert(int value) {
        root = insertRecursive(root, value);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public BstNode getRoot() {
        return root;
    }

    // --- INSERÇÃO ---

    private BstNode insertRecursive(BstNode current, int value) {
        if (current == null) {
            return new BstNode(value);
        }

        if (value < current.getValue()) {
            current.setLeft(insertRecursive(current.getLeft(), value));
        } else if (value > current.getValue()) {
            current.setRight(insertRecursive(current.getRight(), value));
        }

        return current;
    }

    // --- IMPRESSÃO EM FORMATO DE ÁRVORE ---

    public void printTree() {
        if (isEmpty()) {
            System.out.println("[árvore vazia]");
            return;
        }

        int height = getHeight(root);
        printTreeLevel(List.of(root), 1, height);
    }

    private void printTreeLevel(List<BstNode> nodes, int level, int height) {
        if (nodes.isEmpty() || allNull(nodes)) return;

        int floor = height - level;
        int edgeLines = (int) Math.pow(2, Math.max(floor - 1, 0));
        int firstSpaces = (int) Math.pow(2, floor) - 1;
        int betweenSpaces = (int) Math.pow(2, floor + 1) - 1;

        printSpaces(firstSpaces);

        List<BstNode> newNodes = new ArrayList<>();

        for (BstNode node : nodes) {
            if (node != null) {
                System.out.print(node.getValue());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                System.out.print(" ");
                newNodes.add(null);
                newNodes.add(null);
            }

            printSpaces(betweenSpaces);
        }
        System.out.println();

        // desenhar as linhas "/" e "\"
        for (int i = 1; i <= edgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printSpaces(firstSpaces - i);

                if (nodes.get(j) == null) {
                    printSpaces(edgeLines + edgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).getLeft() != null) {
                    System.out.print("/");
                } else {
                    printSpaces(1);
                }

                printSpaces(i + i - 1);

                if (nodes.get(j).getRight() != null) {
                    System.out.print("\\");
                } else {
                    printSpaces(1);
                }

                printSpaces(edgeLines + edgeLines - i);
            }
            System.out.println();
        }

        printTreeLevel(newNodes, level + 1, height);
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    private boolean allNull(List<BstNode> list) {
        for (BstNode node : list) {
            if (node != null) return false;
        }
        return true;
    }

    private int getHeight(BstNode node) {
        if (node == null) return 0;

        return 1 + Math.max(getHeight(node.getLeft()), getHeight(node.getRight()));
    }

    // --- BUSCA ---

    public void search(int value) {
        SearchResult result = searchRecursive(root, value, 0);

        if (result == null) {
            System.out.println("Valor " + value + " não encontrado na árvore.");
        } else {
            System.out.println("Valor encontrado: " + result.value);
            System.out.println("Nível do nó:      " + result.level);
            System.out.println("Altura do nó:     " + result.height);
        }
    }

    private SearchResult searchRecursive(BstNode current, int value, int level) {
        if (current == null) {
            return null; // não encontrado
        }

        if (value == current.getValue()) {
            return new SearchResult(current.getValue(), level, getHeight(current));
        }

        if (value < current.getValue()) {
            return searchRecursive(current.getLeft(), value, level + 1);
        } else {
            return searchRecursive(current.getRight(), value, level + 1);
        }
    }

    // --- REMOÇÃO ---

    public void remove(int value) {
        if (!contains(root, value)) {
            System.out.println("Valor " + value + " não encontrado na árvore.");
            return;
        }

        root = removeRecursive(root, value);
        System.out.println("Valor " + value + " removido com sucesso.");
    }

    private boolean contains(BstNode current, int value) {
        if (current == null) return false;
        if (value == current.getValue()) return true;
        if (value < current.getValue()) return contains(current.getLeft(), value);
        return contains(current.getRight(), value);
    }

    private BstNode removeRecursive(BstNode current, int value) {
        if (current == null) return null;

        if (value < current.getValue()) {
            current.setLeft(removeRecursive(current.getLeft(), value));

        } else if (value > current.getValue()) {
            current.setRight(removeRecursive(current.getRight(), value));

        } else {
            // Nó encontrado — 3 casos:

            // Caso 1: nó folha (sem filhos)
            if (current.getLeft() == null && current.getRight() == null) {
                return null;
            }

            // Caso 2: nó com apenas um filho
            if (current.getLeft() == null) return current.getRight();
            if (current.getRight() == null) return current.getLeft();

            // Caso 3: nó com dois filhos
            // Substitui pelo menor valor da subárvore direita (sucessor in-order)
            int smallestValue = findMin(current.getRight());
            current.setValue(smallestValue);
            current.setRight(removeRecursive(current.getRight(), smallestValue));
        }

        return current;
    }

    private int findMin(BstNode node) {
        return node.getLeft() == null ? node.getValue() : findMin(node.getLeft());
    }

    public String caminho(TipoCaminho tipo) {
        List<Integer> resultado = new ArrayList<>();

        if (tipo == TipoCaminho.IN_ORDER) {
            inOrder(root, resultado);
        } else if (tipo == TipoCaminho.PRE_ORDER) {
            preOrder(root, resultado);
        } else if (tipo == TipoCaminho.POS_ORDER) {
            posOrder(root, resultado);
        }

        return resultado.toString();
    }

    // Esquerda → Raiz → Direita
    private void inOrder(BstNode node, List<Integer> resultado) {
        if (node == null) return;
        inOrder(node.getLeft(), resultado);
        resultado.add(node.getValue());
        inOrder(node.getRight(), resultado);
    }

    // Raiz → Esquerda → Direita
    private void preOrder(BstNode node, List<Integer> resultado) {
        if (node == null) return;
        resultado.add(node.getValue());
        preOrder(node.getLeft(), resultado);
        preOrder(node.getRight(), resultado);
    }

    // Esquerda → Direita → Raiz
    private void posOrder(BstNode node, List<Integer> resultado) {
        if (node == null) return;
        posOrder(node.getLeft(), resultado);
        posOrder(node.getRight(), resultado);
        resultado.add(node.getValue());
    }

    // --- BALANCEAMENTO ---

    public void balance() {
        root = balanceRecursive(root);
        System.out.println("Árvore balanceada com sucesso.");
    }

    private BstNode balanceRecursive(BstNode node) {
        if (node == null) return null;

        // Primeiro balanceia os filhos recursivamente
        node.setLeft(balanceRecursive(node.getLeft()));
        node.setRight(balanceRecursive(node.getRight()));

        // Depois verifica e corrige o nó atual
        int fator = getFatorBalanceamento(node);

        // Pesada para a ESQUERDA
        if (fator > 1) {
            // Caso Esquerda-Direita (dupla): rotaciona filho esquerdo para esquerda primeiro
            if (getFatorBalanceamento(node.getLeft()) < 0) {
                node.setLeft(rotacionarEsquerda(node.getLeft()));
            }
            // Rotação simples para a direita
            return rotacionarDireita(node);
        }

        // Pesada para a DIREITA
        if (fator < -1) {
            // Caso Direita-Esquerda (dupla): rotaciona filho direito para direita primeiro
            if (getFatorBalanceamento(node.getRight()) > 0) {
                node.setRight(rotacionarDireita(node.getRight()));
            }
            // Rotação simples para a esquerda
            return rotacionarEsquerda(node);
        }

        return node; // já está balanceado
    }

    private int getFatorBalanceamento(BstNode node) {
        return getHeight(node.getLeft()) - getHeight(node.getRight());
    }
    //      y                x
    //     / \              / \
    //    x   T3    →     T1   y
    //   / \                  / \
    //  T1  T2              T2  T3
    private BstNode rotacionarDireita(BstNode y) {
        BstNode x = y.getLeft();
        BstNode T2 = x.getRight();

        x.setRight(y);
        y.setLeft(T2);

        return x;
    }

    //    x                  y
    //   / \                / \
    //  T1   y     →       x   T3
    //      / \           / \
    //     T2  T3        T1  T2
    private BstNode rotacionarEsquerda(BstNode x) {
        BstNode y = x.getRight();
        BstNode T2 = y.getLeft();

        y.setLeft(x);
        x.setRight(T2);

        return y;
    }

}