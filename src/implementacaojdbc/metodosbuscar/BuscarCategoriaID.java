package implementacaojdbc.metodosbuscar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarCategoriaID {
        public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        int idCategoria = 1; // Substitua pelo ID da categoria que deseja buscar

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM Categoria WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idCategoria);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idUsuario = resultSet.getInt("id_usuario");
                String nome = resultSet.getString("nome");
                String tipo = resultSet.getString("tipo");

                System.out.println("ID: " + id);
                System.out.println("ID do Usuário: " + idUsuario);
                System.out.println("Nome: " + nome);
                System.out.println("Tipo: " + tipo);
            } else {
                System.out.println("Categoria com ID " + idCategoria + " não encontrada.");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}