package implementacaojdbc.Interface;

import implementacaojdbc.DataAccessObject.UsuarioDAO;

public class TestarTelaListar {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        ListarUsuariosJFrame listarUsuariosFrame = new ListarUsuariosJFrame(usuarioDAO);

    }
}
