package implementacaojdbc.metodoslistar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;


public class ListarRelatorioPc {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM RelatorioPc";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCofrinho = resultSet.getInt("id_cofrinho");
                int idConta = resultSet.getInt("id_conta");
                BigDecimal valor = resultSet.getBigDecimal("valor");
                Timestamp dataInsercao = resultSet.getTimestamp("data_insercao");

                System.out.println("ID: " + id);
                System.out.println("ID do Cofrinho: " + idCofrinho);
                System.out.println("ID da Conta: " + idConta);
                System.out.println("Valor: " + valor);
                System.out.println("Data de Inserção: " + dataInsercao);
                System.out.println("------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

