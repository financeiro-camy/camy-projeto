package ImplementacaoJDBC.MétodosListar;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ListarMetas {
     public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM Meta";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idCategoria = resultSet.getInt("id_categoria");
                BigDecimal valor = resultSet.getBigDecimal("valor");
                int mes = resultSet.getInt("mes");
                int ano = resultSet.getInt("ano");
                boolean ativo = resultSet.getBoolean("ativo");

                System.out.println("ID: " + id);
                System.out.println("ID da Categoria: " + idCategoria);
                System.out.println("Valor: " + valor);
                System.out.println("Mês: " + mes);
                System.out.println("Ano: " + ano);
                System.out.println("Ativo: " + ativo);
                System.out.println("------------");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}