package ImplementacaoJDBC.MétodosInserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirDespesa {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "INSERT INTO Despesa (id_categoria, id_conta, nome, descricao, valor, classificacao, data_vencimento, pago, data_pagamento, periodicidade, numero_parcelas) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);

            // Exemplo 1
            statement.setInt(1, 1);
            statement.setInt(2, 1);
            statement.setString(3, "Aluguel");
            statement.setString(4, "Aluguel do mês");
            statement.setDouble(5, 1000.00);
            statement.setString(6, "fixa");
            statement.setString(7, "2023-09-30");
            statement.setBoolean(8, false);
            statement.setNull(9, java.sql.Types.DATE);
            statement.setString(10, "mensal");
            statement.setInt(11, 1);
            statement.executeUpdate();

            // Exemplo 2 (Repita o processo para os outros exemplos)

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
