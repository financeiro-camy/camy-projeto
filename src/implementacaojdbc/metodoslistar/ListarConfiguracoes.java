package implementacaojdbc.metodoslistar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarConfiguracoes {
    
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM Configuracao";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                int idUsuario = resultSet.getInt("id_usuario");
                String moeda = resultSet.getString("moeda");

                System.out.println("ID: " + id);
                System.out.println("ID do Usuário: " + idUsuario);
                System.out.println("Moeda: " + moeda);
                System.out.println("------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
