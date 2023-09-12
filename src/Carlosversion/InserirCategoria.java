package Carlosversion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirCategoria {
    public static void main(String[] args) throws SQLException {
        // Configura a conexão com o banco de dados
        String url = "jdbc:seu_banco_de_dados_url";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            // Inserção 1
            inserirCategoria(connection, 1, 1, "Categoria1", "despesa");

            // Inserção 2
            inserirCategoria(connection, 2, 1, "Categoria2", "receita");

            // Inserção 3
            inserirCategoria(connection, 3, 2, "Categoria3", "despesa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirCategoria(Connection connection, int id, int idUsuario, String nome, String tipo) throws SQLException {
        String sql = "INSERT INTO Categoria (id, id_usuario, nome, tipo) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idUsuario);
        statement.setString(3, nome);
        statement.setString(4, tipo);

        statement.executeUpdate();

        System.out.println("Categoria inserida com sucesso!");
        statement.close();
    }
}
