package implementacaojdbc.metodoslistar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;

public class ListarParcela {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";
        
         try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
             String sql = "SELECT * FROM Parcela";
 
             PreparedStatement statement = connection.prepareStatement(sql);
 
             ResultSet resultSet = statement.executeQuery();
 
             while (resultSet.next()) {
                 int id = resultSet.getInt("id");
                 int idLancamento = resultSet.getInt("id_lancamento");
                 String tipoLancamento = resultSet.getString("tipo_lancamento");
                 int numero = resultSet.getInt("numero");
                 BigDecimal valor = resultSet.getBigDecimal("valor");
                 Date dataVencimento = resultSet.getDate("data_vencimento");
                 boolean pago = resultSet.getBoolean("pago");
                 Date dataPagamento = resultSet.getDate("data_pagamento");
 
                 System.out.println("ID: " + id);
                 System.out.println("ID do Lançamento: " + idLancamento);
                 System.out.println("Tipo de Lançamento: " + tipoLancamento);
                 System.out.println("Número: " + numero);
                 System.out.println("Valor: " + valor);
                 System.out.println("Data de Vencimento: " + dataVencimento);
                 System.out.println("Pago: " + pago);
                 System.out.println("Data de Pagamento: " + dataPagamento);
                 System.out.println("------------");
             }
 
             resultSet.close();
             statement.close();
         } catch (SQLException e) {
             e.printStackTrace();
         }
     }
 }
