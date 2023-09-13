package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirParcela {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            inserirParcela(connection, 1, "despesa", 1, 500.00, "2023-09-30", false, null);
            inserirParcela(connection, 2, "receita", 1, 800.00, "2023-09-15", true, "2023-09-15");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirParcela(Connection connection, int id, String tipoLancamento, int numero, double valor, String dataVencimento, boolean pago, String dataPagamento) throws SQLException {
        String sql = "INSERT INTO Parcela (id, id_lancamento, tipo_lancamento, numero, valor, data_vencimento, pago, data_pagamento) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, id); 
        statement.setString(3, tipoLancamento);
        statement.setInt(4, numero);
        statement.setDouble(5, valor);
        statement.setString(6, dataVencimento);
        statement.setBoolean(7, pago);
        if (dataPagamento != null) {
            statement.setString(8, dataPagamento);
        } else {
            statement.setNull(8, java.sql.Types.DATE);
        }

        statement.executeUpdate();

        System.out.println("Parcela inserida com sucesso!");
        statement.close();
    }
}
