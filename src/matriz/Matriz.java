package matriz;

import java.util.Arrays;

public class Matriz {
    static void main() {
        int [][] matriz = new int[][] {{1,2,3}, {4,5,6}, {7,8,9}};
        int soma = Arrays.stream(matriz).flatMapToInt(Arrays::stream).sum();
        System.out.println(soma);
    }
}
