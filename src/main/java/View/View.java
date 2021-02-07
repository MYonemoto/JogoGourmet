package View;

import Model.Tree;

import javax.swing.*;

import static javax.swing.JOptionPane.*;

public class View {

    private final JFrame jFrame;

    public View() {
        UIManager.put("OptionPane.cancelButtonText", "Cancelar");
        UIManager.put("OptionPane.yesButtonText", "sim");
        UIManager.put("OptionPane.noButtonText", "nao");
        UIManager.put("OptionPane.okButtonText", "OK");

        this.jFrame = new JFrame();
    }

    /**
     * Mostra ao usuário o diálogo inicial para dar sequência ao jogo
     * @return true se o usuário clicar em OK ou false se o usuário clicar em CANCELAR
     * ou fechar a janela
     */
    public boolean openingSentence() {
        int answer = showConfirmDialog(jFrame, "Pense em um prato que gosta", "Jogo Gourmet", OK_CANCEL_OPTION, INFORMATION_MESSAGE);

        if (answer == CANCEL_OPTION || answer == CLOSED_OPTION) System.exit(0);

        return answer == OK_OPTION;
    }

    /**
     * Mostra o diálogo tentando adivinhar o prato do usuário
     * @param text o prato que o jogo pergunta se está certo
     * @return true se o usuário responder SIM ou false se o usuário responder NAO
     */
    public boolean checkPlate(String text) {
        String message = String.format("O prato que você pensou é %s?", text);
        int answer = showConfirmDialog(jFrame, message, "Confirm", YES_NO_OPTION, QUESTION_MESSAGE);

        return answer == YES_OPTION;
    }

    /**
     * Mostra mensagem de vitória
     */
    public void winMessage() {
        showMessageDialog(jFrame, "Acertei de novo!", "Jogo Gourmet", INFORMATION_MESSAGE);
    }

    /**
     * Mostra diálogo pedindo para o usuário digitar o prato que pensou
     * @return o nome do prato digitado ou NULL caso não digite nada
     */
    public String newPlate() {
        return showInputDialog(jFrame, "Qual prato você pensou?", "Desisto", INFORMATION_MESSAGE);

    }

    /**
     * Mostra diálogo pedindo para o usuário digitar uma característica do novo prato
     * @param newPlate nome do novo prato
     * @param plate o nó da árvore que contém o nome do prato que nao contém tal característica
     * @return a característica do prato caso respondido ou NULL caso não respondido
     */
    public String newFeature(String newPlate, Tree<String> plate) {

        return showInputDialog(jFrame, String.format("%s é ________ mas %s não.", newPlate, plate.getValue()), "Complete", INFORMATION_MESSAGE);
    }
}
