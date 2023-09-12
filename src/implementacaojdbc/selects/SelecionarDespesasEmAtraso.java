package implementacaojdbc.selects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SelecionarDespesasEmAtraso {
  public static void main(String[] args) {
         String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT d.nome AS nome_despesa, d.data_vencimento AS data_vencimento, d.valor AS valor_despesa " +
                         "FROM Despesa d " +
                         "WHERE d.pago = FALSE " +
                         "AND d.data_vencimento < CURDATE()";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String nomeDespesa = resultSet.getString("nome_despesa");
                Date dataVencimento = resultSet.getDate("data_vencimento");
                double valorDespesa = resultSet.getDouble("valor_despesa");

                System.out.println("Despesa: " + nomeDespesa);
                System.out.println("Data de Vencimento: " + dataVencimento);
                System.out.println("Valor da Despesa: " + valorDespesa);
                System.out.println();
            }

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
