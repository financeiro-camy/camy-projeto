package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InserirCategoria {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";
        
        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {
            inserirCategoria(connection, 1, 1, "Categoria1", "despesa");
            inserirCategoria(connection, 2, 1, "Categoria2", "receita");
            inserirCategoria(connection, 3, 2, "Categoria3", "despesa");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirCategoria(Connection connection, int id, int idUsuario, String nome, String tipo) throws SQLException {
        String sql = "INSERT INTO Categoria (id, id_usuario, nome, tipo) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idUsuario);
        statement.setString(3, nome);
        statement.setString(4, tipo);

        statement.executeUpdate();

        System.out.println("Categoria inserida com sucesso!");
        statement.close();
    }
}
