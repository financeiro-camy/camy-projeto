package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;


public class InserirParcela {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            // Inserção 1
            inserirParcela(connection, 1, 1, "despesa", 1, new BigDecimal("100.00"), Date.valueOf("2023-09-15"), false, null);

            // Inserção 2
            inserirParcela(connection, 2, 2, "receita", 1, new BigDecimal("200.00"), Date.valueOf("2023-09-20"), false, null);

            // Inserção 3
            inserirParcela(connection, 3, 1, "despesa", 2, new BigDecimal("150.00"), Date.valueOf("2023-09-25"), true, Date.valueOf("2023-09-25"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirParcela(Connection connection, int id, int idLancamento, String tipoLancamento, int numero, BigDecimal valor, Date dataVencimento, boolean pago, Date dataPagamento) throws SQLException {
        String sql = "INSERT INTO Parcela (id, id_lancamento, tipo_lancamento, numero, valor, data_vencimento, pago, data_pagamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idLancamento);
        statement.setString(3, tipoLancamento);
        statement.setInt(4, numero);
        statement.setBigDecimal(5, valor);
        statement.setDate(6, dataVencimento);
        statement.setBoolean(7, pago);
        statement.setDate(8, dataPagamento);

        statement.executeUpdate();

        System.out.println("Parcela inserida com sucesso!");
        statement.close();
    }
}
