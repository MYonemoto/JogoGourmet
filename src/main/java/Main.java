import Controller.GameController;
import Model.Tree;
import View.View;

public class Main {

    /**
     * Método que inicia o jogo
     */
    public static void init() {
        GameController game = new GameController();
        View view = game.getView();

        /**
         * Mantém o jogo sempre acontecendo enquanto não cancelar ou fechar a janela
         */
        while (view.openingSentence()) {
            Tree<String> foundPlate = game.checkTree();

            /**
             * Verifica o prato com o usuário, caso já tenha acertado mostra mensagem
             * de vitória, caso contrário, continua perguntando o nome do prato que
             * o usuário pensou
             */
            if (view.checkPlate(foundPlate.getValue())) {
                view.winMessage();
                continue;
            }

            String plate = view.newPlate();
            String feature = view.newFeature(plate, foundPlate);

            game.setTree(foundPlate, plate, feature);
        }
    }

    public static void main(String[] args) {
        init();
    }

}