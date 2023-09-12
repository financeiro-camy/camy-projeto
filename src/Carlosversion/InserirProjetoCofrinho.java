package Carlosversion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class InserirProjetoCofrinho {
    public static void main(String[] args) throws SQLException {
        // Configura a conexão com o banco de dados
        String url = "jdbc:seu_banco_de_dados_url";
        String usuario = "seu_usuario";
        String senha = "sua_senha";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            // Inserção 1
            inserirProjetoCofrinho(connection, 1, "Projeto1", "Descrição do projeto 1", 
                Timestamp.valueOf("2023-12-31 23:59:59"), new BigDecimal("1000.00"), 1, true);

            // Inserção 2
            inserirProjetoCofrinho(connection, 2, "Projeto2", "Descrição do projeto 2", 
                Timestamp.valueOf("2023-12-31 23:59:59"), new BigDecimal("1500.00"), 2, true);

            // Inserção 3
            inserirProjetoCofrinho(connection, 3, "Projeto3", "Descrição do projeto 3", 
                Timestamp.valueOf("2024-12-31 23:59:59"), new BigDecimal("800.00"), 1, false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirProjetoCofrinho(Connection connection, int id, String nome, String descricao, 
            Timestamp prazo, BigDecimal metaQuantia, int idUsuario, boolean ativo) throws SQLException {
        Timestamp dataCriacao = new Timestamp(System.currentTimeMillis());

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
    }
}
