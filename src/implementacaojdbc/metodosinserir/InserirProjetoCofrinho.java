package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class InserirProjetoCofrinho{
 public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            int id = 1; 
            String nome = "Projeto1"; 
            String descricao = "Descrição do projeto cofrinho"; 
            Timestamp dataCriacao = new Timestamp(System.currentTimeMillis()); 
            Timestamp prazo = Timestamp.valueOf("2023-12-31 23:59:59"); 
            BigDecimal metaQuantia = new BigDecimal("1000.00"); 
            int idUsuario = 1; 
            boolean ativo = true; 

            String sql = "INSERT INTO ProjetoCofrinho (id, nome, descricao, data_criacao, prazo, meta_quantia, id_usuario, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, nome);
            statement.setString(3, descricao);
            statement.setTimestamp(4, dataCriacao);
            statement.setTimestamp(5, prazo);
            statement.setBigDecimal(6, metaQuantia);
            statement.setInt(7, idUsuario);
            statement.setBoolean(8, ativo);

            statement.executeUpdate();

            System.out.println("Projeto Cofrinho inserido com sucesso!");
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}