package ImplementacaoJDBC.MétodosListar;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.math.BigDecimal;

public class ListarProjetoCofrinho {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "SELECT * FROM ProjetoCofrinho";

            PreparedStatement statement = connection.prepareStatement(sql);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String descricao = resultSet.getString("descricao");
                Timestamp dataCriacao = resultSet.getTimestamp("data_criacao");
                Timestamp prazo = resultSet.getTimestamp("prazo");
                BigDecimal metaQuantia = resultSet.getBigDecimal("meta_quantia");
                int idUsuario = resultSet.getInt("id_usuario");
                boolean ativo = resultSet.getBoolean("ativo");

                System.out.println("ID: " + id);
                System.out.println("Nome: " + nome);
                System.out.println("Descrição: " + descricao);
                System.out.println("Data de Criação: " + dataCriacao);
                System.out.println("Prazo: " + prazo);
                System.out.println("Meta de Quantia: " + metaQuantia);
                System.out.println("ID do Usuário: " + idUsuario);
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
