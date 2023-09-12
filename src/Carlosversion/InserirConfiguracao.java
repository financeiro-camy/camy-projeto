package Carlosversion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirConfiguracao {
    public static void main(String[] args) throws SQLException {
        // Configura a conexão com o banco de dados
        String url = "jdbc:seu_banco_de_dados_url";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            // Inserção 1
            inserirConfiguracao(connection, 1, 1, "BRL");

            // Inserção 2
            inserirConfiguracao(connection, 2, 2, "USD");

            // Inserção 3
            inserirConfiguracao(connection, 3, 1, "EUR");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirConfiguracao(Connection connection, int id, int idUsuario, String moeda) throws SQLException {
        String sql = "INSERT INTO Configuracao (ID, id_usuario, moeda) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idUsuario);
        statement.setString(3, moeda);

        statement.executeUpdate();

        System.out.println("Configuração inserida com sucesso!");
        statement.close();
    }
}
