package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class InserirRelatorioPc {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            int id = 1; // Substitua pelo ID desejado
            int idCofrinho = 1; // Substitua pelo ID do cofrinho associado
            int idConta = 1; // Substitua pelo ID da conta associada
            BigDecimal valor = new BigDecimal("100.00"); // Valor do relatório
            Timestamp dataInsercao = new Timestamp(System.currentTimeMillis()); // Data de inserção

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
