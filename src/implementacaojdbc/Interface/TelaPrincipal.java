package implementacaojdbc.Interface;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import implementacaojdbc.DataAccessObject.UsuarioDAO;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JButton cadastrarUsuarioButton;
    private JButton listarUsuariosButton;
    private JPanel panel;
    
    public TelaPrincipal() {
        setTitle("Tela Principal");
        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cadastrarUsuarioButton = new JButton("Cadastrar Usuário");
        listarUsuariosButton = new JButton("Listar Usuários");

        cadastrarUsuarioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Cadastrar Usuário");
                new CadastrarUsuarioJFrame();
            }
        });

        listarUsuariosButton.addActionListener(e -> {
            System.out.println("Listar Usuários");
            new ListarUsuariosJFrame(new UsuarioDAO());
        });
        
        panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.add(cadastrarUsuarioButton);
        panel.add(listarUsuariosButton);

        getContentPane().add(panel);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal();
            }
        });
    }
}
