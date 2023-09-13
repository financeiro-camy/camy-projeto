package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDespesa {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            inserirDespesa(connection, 1, 1, "Aluguel", "Aluguel do mês", 1000.00, "fixa", "2023-09-30", false, null, "mensal", 1);
            inserirDespesa(connection, 2, 2, "Conta de Luz", "Pagamento da conta de luz", 150.00, "fixa", "2023-09-15", false, null, "mensal", 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirDespesa(Connection connection, int id, int idCategoria, String nome, String descricao,
            double valor, String classificacao, String dataVencimento, boolean pago, String dataPagamento,
            String periodicidade, int numeroParcelas) throws SQLException {
        String sql = "INSERT INTO Despesa (id, id_categoria, id_conta, nome, descricao, valor, classificacao, data_vencimento, pago, data_pagamento, periodicidade, numero_parcelas) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idCategoria);
        statement.setInt(3, id); // Substitua pelo id da conta correto
        statement.setString(4, nome);
        statement.setString(5, descricao);
        statement.setDouble(6, valor);
        statement.setString(7, classificacao);
        statement.setString(8, dataVencimento);
        statement.setBoolean(9, pago);
        statement.setString(10, dataPagamento);
        statement.setString(11, periodicidade);
        statement.setInt(12, numeroParcelas);

        statement.executeUpdate();

        System.out.println("Despesa inserida com sucesso!");
        statement.close();
    }
}
