package implementacaojdbc.Interface;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import implementacaojdbc.DataAccessObject.Usuario;
import implementacaojdbc.DataAccessObject.UsuarioDAO;

public class CadastrarUsuarioJFrame extends JFrame {
    private JLabel idLabel = new JLabel("ID:");
    private JTextField idTextField = new JTextField(20);
    private JLabel nomeLabel = new JLabel("Nome:");
    private JTextField nomeTextField = new JTextField(20);
    private JLabel emailLabel = new JLabel("Email:");
    private JTextField emailTextField = new JTextField(20);
    private JLabel senhaLabel = new JLabel("Senha:");
    private JTextField senhaTextField = new JTextField(20);
    private JCheckBox ativoCheckBox = new JCheckBox("Ativo", true);
    private JButton cadastrarButton = new JButton("Cadastrar");
    private JPanel panel = new JPanel();

    public CadastrarUsuarioJFrame() {
        setTitle("Cadastrar Novo Usuário");
        setSize(300, 220);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new GridLayout(6, 2, 5, 5));
        panel.add(idLabel);
        panel.add(idTextField);
        panel.add(nomeLabel);
        panel.add(nomeTextField);
        panel.add(emailLabel);
        panel.add(emailTextField);
        panel.add(senhaLabel);
        panel.add(senhaTextField);
        panel.add(ativoCheckBox);
        panel.add(new JLabel(""));
        panel.add(cadastrarButton);

        cadastrarButton.addActionListener(e -> {
            String idStr = idTextField.getText();
            String nome = nomeTextField.getText();
            String email = emailTextField.getText();
            String senha = senhaTextField.getText();
            Boolean ativo = ativoCheckBox.isSelected();

            ArrayList<String> errors = new ArrayList<>();
            
            // Validar dados
            if (idStr.isBlank()) {
                errors.add("ID não pode ser vazio");
            }

            if (nome.isBlank()) {
                errors.add("Nome não pode ser vazio");
            }

            if (nome.trim().length() < 3 || nome.trim().length() > 100) {
                errors.add("Nome deve ter entre 3 e 100 caracteres");
            }

            if (email.isBlank()) {
                errors.add("Email não pode ser vazio");
            }

            if (senha.isBlank()) {
                errors.add("Senha não pode ser vazia");
            }

            if (!errors.isEmpty()) {
                JOptionPane.showMessageDialog(
                    CadastrarUsuarioJFrame.this,
                    String.join("\n", errors),
                    "Erro ao cadastrar",
                    JOptionPane.ERROR_MESSAGE    
                );
            } else {
                try {
                    int id = Integer.parseInt(idStr);
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    Usuario usuario = new Usuario(id, nome, email, senha, ativo);
                    Usuario usuarioSalvo = usuarioDAO.create(usuario);
                    JOptionPane.showMessageDialog(
                        CadastrarUsuarioJFrame.this,
                        "Usuário cadastrado com sucesso ID: " + usuarioSalvo.getId(),
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE    
                    );
                    cleanTextFields();

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(
                        CadastrarUsuarioJFrame.this,
                        "ID deve ser um número válido.",
                        "Erro ao cadastrar",
                        JOptionPane.ERROR_MESSAGE
                    );
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Adicione tratamento apropriado, como exibir uma mensagem de erro ao usuário.
                }
            }
        });

        getContentPane().add(panel);
        setResizable(false);
        setVisible(true);
    }

    private void cleanTextFields() {
        idTextField.setText("");
        nomeTextField.setText("");
        emailTextField.setText("");
        senhaTextField.setText("");
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new CadastrarUsuarioJFrame();
        });
    }
}
