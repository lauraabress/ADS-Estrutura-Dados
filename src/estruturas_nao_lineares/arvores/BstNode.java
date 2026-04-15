package estruturas_nao_lineares.arvores;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BstNode {

        int value;
        BstNode left;
        BstNode right;

        public BstNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

}
