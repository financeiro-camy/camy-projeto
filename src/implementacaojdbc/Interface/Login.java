package implementacaojdbc.Interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        // Cria a janela principal
        JFrame frame = new JFrame("LOGIN");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 350);

        // Cria um painel para adicionar componentes
        JPanel panel = new JPanel();
        frame.add(panel);

        // Layout de fluxo para organizar os componentes
        panel.setLayout(new FlowLayout());

        // Cria um rótulo
        JLabel emailLabel = new JLabel("e-mail:");
        panel.add(emailLabel);

        // Cria uma caixa de texto para inserir o e-mail
        JTextField emailTextField = new JTextField(20);
        panel.add(emailTextField);

        // Cria um botão para enviar
        JButton sendButton = new JButton("Prosseguir");
        panel.add(sendButton);

        // Define um evento de ação para o botão
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailTextField.getText();
                // Faça algo com o endereço de e-mail aqui
                JOptionPane.showMessageDialog(frame, "Verifique se o email inserido: " + email);
            }
        });

        // Exibe a janela
        frame.setVisible(true);
    }
}
