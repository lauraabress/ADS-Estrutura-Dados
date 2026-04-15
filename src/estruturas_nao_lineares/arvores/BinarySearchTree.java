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
}