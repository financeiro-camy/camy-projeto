package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class InserirRelatorioPc {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            int id = 1; 
            int idCofrinho = 1; 
            int idConta = 1; 
            BigDecimal valor = new BigDecimal("100.00"); 
            Timestamp dataInsercao = new Timestamp(System.currentTimeMillis()); 

            String sql = "INSERT INTO RelatorioPc (id, id_cofrinho, id_conta, valor, data_insercao) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setInt(2, idCofrinho);
            statement.setInt(3, idConta);
            statement.setBigDecimal(4, valor);
            statement.setTimestamp(5, dataInsercao);

            statement.executeUpdate();

            System.out.println("Relatório inserido com sucesso!");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
