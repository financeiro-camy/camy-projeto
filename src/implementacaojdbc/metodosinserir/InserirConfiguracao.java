package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class InserirConfiguracao {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudandte";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            inserirConfiguracao(connection, 1, 1, "BRL");
            inserirConfiguracao(connection, 2, 2, "USD");
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
