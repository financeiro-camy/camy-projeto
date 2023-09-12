package implementacaojdbc.metodosbuscar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BuscarUsuarioID {
     public static void main(String[] args) throws SQLException {
        // Configura a conexão com o banco de dados
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        int idUsuario = 1; // Substitua pelo ID do usuário que deseja buscar

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM Usuario WHERE id = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, idUsuario);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senhaUsuario = resultSet.getString("senha");
                boolean ativo = resultSet.getBoolean("ativo");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Email: " + email);
                System.out.println("Senha: " + senhaUsuario);
                System.out.println("Ativo: " + ativo);
            } else {
                System.out.println("Usuário com ID " + idUsuario + " não encontrado.");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}