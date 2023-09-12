package implementacaojdbc.metodoslistar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;

public class ListarDespesa {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM Despesa";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCategoria = resultSet.getInt("id_categoria");
                int idConta = resultSet.getInt("id_conta");
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                BigDecimal valor = resultSet.getBigDecimal("valor");
                String classificacao = resultSet.getString("classificacao");
                Date dataVencimento = resultSet.getDate("data_vencimento");
                boolean pago = resultSet.getBoolean("pago");
                Date dataPagamento = resultSet.getDate("data_pagamento");
                String periodicidade = resultSet.getString("periodicidade");
                int numeroParcelas = resultSet.getInt("numero_parcelas");

                System.out.println("ID: " + id);
                System.out.println("ID da Categoria: " + idCategoria);
                System.out.println("ID da Conta: " + idConta);
                System.out.println("Nome: " + nome);
                System.out.println("Descrição: " + descricao);
                System.out.println("Valor: " + valor);
                System.out.println("Classificação: " + classificacao);
                System.out.println("Data de Vencimento: " + dataVencimento);
                System.out.println("Pago: " + pago);
                System.out.println("Data de Pagamento: " + dataPagamento);
                System.out.println("Periodicidade: " + periodicidade);
                System.out.println("Número de Parcelas: " + numeroParcelas);
                System.out.println("------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
