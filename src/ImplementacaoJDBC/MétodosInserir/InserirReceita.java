package ImplementacaoJDBC.MétodosInserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import java.math.BigDecimal;

public class InserirReceita {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";


        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            // Inserção 1
            inserirReceita(connection, 1, 1, 1, "Receita1", "Descrição da Receita 1", new BigDecimal("500.00"), "fixa", new Date(System.currentTimeMillis()), "mensal", 1);

            // Inserção 2
            inserirReceita(connection, 2, 2, 2, "Receita2", "Descrição da Receita 2", new BigDecimal("800.00"), "parcelada", new Date(System.currentTimeMillis()), "mensal", 3);

            // Inserção 3
            inserirReceita(connection, 3, 1, 1, "Receita3", "Descrição da Receita 3", new BigDecimal("1000.00"), "fixa", new Date(System.currentTimeMillis()), "anual", 1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirReceita(Connection connection, int id, int idCategoria, int idConta, String nome, String descricao, BigDecimal valor, String classificacao, Date data, String periodicidade, int numeroParcelas) throws SQLException {
        String sql = "INSERT INTO Receita (id, id_categoria, id_conta, nome, descricao, valor, classificacao, data, periodicidade, numero_parcelas) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idCategoria);
        statement.setInt(3, idConta);
        statement.setString(4, nome);
        statement.setString(5, descricao);
        statement.setBigDecimal(6, valor);
        statement.setString(7, classificacao);
        statement.setDate(8, data);
        statement.setString(9, periodicidade);
        statement.setInt(10, numeroParcelas);

        statement.executeUpdate();

        System.out.println("Receita inserida com sucesso!");
        statement.close();
    }
}
