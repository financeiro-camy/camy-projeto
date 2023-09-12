package implementacaojdbc.selects;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelecionarProjetosComMetaAlcancada {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
       String usuario = "estudante";
       String senha = "estudante";

       try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
           String sql = "SELECT pc.nome AS nome_projeto, pc.meta_quantia AS meta, SUM(rp.valor) AS quantia_arrecadada " +
                        "FROM ProjetoCofrinho pc " +
                        "LEFT JOIN RelatorioPc rp ON pc.id = rp.id_cofrinho " +
                        "WHERE pc.ativo = TRUE " +
                        "GROUP BY pc.id " +
                        "HAVING SUM(rp.valor) >= pc.meta_quantia";

           PreparedStatement statement = connection.prepareStatement(sql);

           ResultSet resultSet = statement.executeQuery();

           while (resultSet.next()) {
               String nomeProjeto = resultSet.getString("nome_projeto");
               double meta = resultSet.getDouble("meta");
               double quantiaArrecadada = resultSet.getDouble("quantia_arrecadada");

               System.out.println("Projeto: " + nomeProjeto);
               System.out.println("Meta: " + meta);
               System.out.println("Quantia Arrecadada: " + quantiaArrecadada);
               System.out.println();
           }

           statement.close();
       } catch (SQLException e) {
           e.printStackTrace();
       }
   }
}

