package implementacaojdbc.selects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelecionarTotalDespesaPorCategoria {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

       Scanner scanner = new Scanner(System.in);
       System.out.print("Digite o ID da categoria: ");
       int idCategoria = scanner.nextInt();

       try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
           String sql = "SELECT c.nome AS nome_categoria, SUM(d.valor) AS total_despesas " +
                        "FROM Categoria c " +
                        "JOIN Despesa d ON c.id = d.id_categoria " +
                        "WHERE c.id = ? " +
                        "GROUP BY c.id";

           PreparedStatement statement = connection.prepareStatement(sql);
           statement.setInt(1, idCategoria);

           ResultSet resultSet = statement.executeQuery();

           if (resultSet.next()) {
               String nomeCategoria = resultSet.getString("nome_categoria");
               double totalDespesas = resultSet.getDouble("total_despesas");

               System.out.println("Categoria: " + nomeCategoria);
               System.out.println("Total de Despesas: " + totalDespesas);
           } else {
               System.out.println("Nenhuma categoria encontrada com ID " + idCategoria + ".");
           }

           statement.close();
       } catch (SQLException e) {
           e.printStackTrace();
       } finally {
           scanner.close();
       }
   }
}
