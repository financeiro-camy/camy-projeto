package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class InserirProjetoCofrinho{
 public static void main(String[] args) throws SQLException {
    String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
    String usuario = "estudante";
    String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            int id = 1; // Substitua pelo ID desejado
            String nome = "Projeto1"; // Nome do projeto cofrinho
            String descricao = "Descrição do projeto cofrinho"; // Descrição do projeto cofrinho
            Timestamp dataCriacao = new Timestamp(System.currentTimeMillis()); // Data de criação
            Timestamp prazo = Timestamp.valueOf("2023-12-31 23:59:59"); // Prazo do projeto cofrinho
            BigDecimal metaQuantia = new BigDecimal("1000.00"); // Meta de quantia do projeto cofrinho
            int idUsuario = 1; // Substitua pelo ID do usuário associado
            boolean ativo = true; // Define se o projeto cofrinho está ativo ou não

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