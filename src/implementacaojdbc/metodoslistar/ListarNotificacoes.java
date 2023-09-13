package implementacaojdbc.metodoslistar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

public class ListarNotificacoes {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";
        

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM Notificacao";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idUsuario = resultSet.getInt("id_usuario");
                String nome = resultSet.getString("nome");
                String mensagem = resultSet.getString("mensagem");
                Timestamp dataEnvio = resultSet.getTimestamp("data_envio");
                boolean lida = resultSet.getBoolean("lida");

                System.out.println("ID: " + id);
                System.out.println("ID do Usuário: " + idUsuario);
                System.out.println("Nome: " + nome);
                System.out.println("Mensagem: " + mensagem);
                System.out.println("Data de Envio: " + dataEnvio);
                System.out.println("Lida: " + lida);
                System.out.println("------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
