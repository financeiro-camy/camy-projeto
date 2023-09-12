package ImplementacaoJDBC.MétodosListar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;

public class ListarHistoricoSaldo {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
         String usuario = "estudante";
         String senha = "estudante";
 
 
         try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
             String sql = "SELECT * FROM HistoricoSaldos";
 
             PreparedStatement statement = connection.prepareStatement(sql);
 
             ResultSet resultSet = statement.executeQuery();
 
             while (resultSet.next()) {
                 int id = resultSet.getInt("id");
                 int idConta = resultSet.getInt("id_conta");
                 Date dataRegistro = resultSet.getDate("data_registro");
                 BigDecimal saldo = resultSet.getBigDecimal("saldo");
 
                 System.out.println("ID: " + id);
                 System.out.println("ID da Conta: " + idConta);
                 System.out.println("Data de Registro: " + dataRegistro);
                 System.out.println("Saldo: " + saldo);
                 System.out.println("------------");
             }
 
             resultSet.close();
             statement.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }
