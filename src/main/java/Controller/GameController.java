package Controller;

import Model.Tree;
import lombok.Data;
import lombok.Getter;

@Data
public class GameController {

    @Getter
    private static final View.View view = new View.View();

    /**
     * Inicia a árvore com as palavras massa, lasanha e bolo de chocolate
     */
    private final Tree<String> root = new Tree<String>("massa", "Lasanha", "Bolo de Chocolate");;

    /**
     * Método para adicionar um novo prato na árvore
     * @param node onde o novo prato irá ser adicionado
     * @param plate nome do prato
     * @param feature a característica do prato
     */
    public static void setTree(Tree<String> node, String plate, String feature) {

        /**
         * Verifica se o nó possui filhos, ou seja, se é folha
         */
        if (!node.isLeaf()) {
            throw new IllegalArgumentException();
        }

        node.setLeft(plate);
        node.setRight(node.getValue());
        node.setValue(feature);
    }


    /**
     * Método que verifica qual prato o usuário está pensando
     * @return nó que mais se encaixa nas respostas do usuário
     */
    public Tree<String> checkTree() {
        Tree<String> tree = root;

        /**
         * verifica se o nó em questão é folha, caso seja o while é terminado
         */
        while (!tree.isLeaf()) {

            /**
             * Verifica o nome do prato de acordo com a resposta do usuário, caso a resposta
             * seja positiva ao nome sugerido, cai para o filho da esquerda, caso contrário,
             * cai para o filho da direita
             */
            if (view.checkPlate(tree.getValue())) {
                //Left == Yes
                tree = tree.getLeft();
            } else {
                //Right == No
                tree = tree.getRight();
            }
        }

        return tree;
    }
}
