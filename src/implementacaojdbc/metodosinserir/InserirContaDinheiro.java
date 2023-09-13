package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirContaDinheiro {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {

            inserirContaDinheiro(connection, 1, 1, "Conta1");

            inserirContaDinheiro(connection, 2, 1, "Conta2");

            inserirContaDinheiro(connection, 3, 2, "Conta3");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirContaDinheiro(Connection connection, int id, int idUsuario, String nome) throws SQLException {
        String sql = "INSERT INTO ContasDinheiro (id, id_usuario, nome) VALUES (?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idUsuario);
        statement.setString(3, nome);

        statement.executeUpdate();

        System.out.println("Conta de Dinheiro inserida com sucesso!");
        statement.close();
    }
}
