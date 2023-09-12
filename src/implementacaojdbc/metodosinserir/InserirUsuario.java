package implementacaojdbc.metodosinserir;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirUsuario {
    public static void main(String[] args) throws SQLException {
        // Configura a conexão com o banco de dados
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            inserirUsuario(connection, 1, "Jisoo", "jisoo@email.com", "senha123", true);
            inserirUsuario(connection, 2, "Lisa", "lisa@email.com", "senha456", true);
            inserirUsuario(connection, 3, "Rosé", "rose@email.com", "senha789", true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirUsuario(Connection connection, int id, String nome, String email, String senhaUsuario, boolean ativo) throws SQLException {
        String sql = "INSERT INTO Usuario (id, nome, email, senha, ativo) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, nome);
        statement.setString(3, email);
        statement.setString(4, senhaUsuario);
        statement.setBoolean(5, ativo);

        statement.executeUpdate();

        System.out.println("Usuário inserido com sucesso!");
        statement.close();
    }
}
