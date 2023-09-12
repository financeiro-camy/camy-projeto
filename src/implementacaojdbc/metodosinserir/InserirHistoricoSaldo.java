package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;

public class InserirHistoricoSaldo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";


        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            // Inserção 1
            inserirHistoricoSaldo(connection, 1, 1, new Date(System.currentTimeMillis()), new BigDecimal("1000.00"));

            // Inserção 2
            inserirHistoricoSaldo(connection, 2, 2, new Date(System.currentTimeMillis()), new BigDecimal("1500.00"));

            // Inserção 3
            inserirHistoricoSaldo(connection, 3, 1, new Date(System.currentTimeMillis()), new BigDecimal("800.00"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirHistoricoSaldo(Connection connection, int id, int idConta, Date dataRegistro, BigDecimal saldo) throws SQLException {
        String sql = "INSERT INTO HistoricoSaldos (id, id_conta, data_registro, saldo) VALUES (?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idConta);
        statement.setDate(3, dataRegistro);
        statement.setBigDecimal(4, saldo);

        statement.executeUpdate();

        System.out.println("Histórico de Saldo inserido com sucesso!");
        statement.close();
    }
}
