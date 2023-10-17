package implementacaojdbc.Interface;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import implementacaojdbc.DataAccessObject.Usuario;
import implementacaojdbc.DataAccessObject.UsuarioDAO;

public class ListarUsuariosJFrame extends JDialog {
    private JTable table;
    private JScrollPane scrollPane;
    private DefaultTableModel tableModel;
    private JPanel panel;
    private UsuarioDAO usuarioDAO;
    
    public ListarUsuariosJFrame(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
        setTitle("Listar Usuários");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setModal(true);

        tableModel = new DefaultTableModel(
            new Object[] { "ID", "Nome", "Email", "Ativo" },
            0
        );

        table = new JTable(tableModel);

        scrollPane = new JScrollPane(table);

        panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        loadData();

        getContentPane().add(panel);

        setVisible(true);
    }

    private void loadData() {
        List<Usuario> usuarios = usuarioDAO.findAll();

        for (Usuario usuario : usuarios) {
            Object[] row = { 
                usuario.getId(), 
                usuario.getNome(), 
                usuario.getEmail(),
                usuario.isAtivo() ? "Sim" : "Não"
            };
            tableModel.addRow(row);
        }
    }
}
