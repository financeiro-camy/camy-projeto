package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class InserirNotificacao {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {

            inserirNotificacao(connection, 1, 1, "Notificacao1", "Esta é uma notificação de exemplo 1.", false);

            inserirNotificacao(connection, 2, 1, "Notificacao2", "Esta é uma notificação de exemplo 2.", true);

            inserirNotificacao(connection, 3, 2, "Notificacao3", "Esta é uma notificação de exemplo 3.", false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirNotificacao(Connection connection, int id, int idUsuario, String nome, String mensagem, boolean lida) throws SQLException {
        Timestamp dataEnvio = new Timestamp(System.currentTimeMillis());

        String sql = "INSERT INTO Notificacao (id, id_usuario, nome, mensagem, data_envio, lida) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idUsuario);
        statement.setString(3, nome);
        statement.setString(4, mensagem);
        statement.setTimestamp(5, dataEnvio);
        statement.setBoolean(6, lida);

        statement.executeUpdate();

        System.out.println("Notificação inserida com sucesso!");
        statement.close();
    }
}

