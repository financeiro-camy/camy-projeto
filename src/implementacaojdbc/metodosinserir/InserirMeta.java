package implementacaojdbc.metodosinserir;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.math.BigDecimal;

public class InserirMeta {
    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
        String usuario = "root";
        String senha = "ditto";

        try (Connection connection = DriverManager.getConnection(url, usuario, senha)) {

            inserirMeta(connection, 1, 1, new BigDecimal("1000.00"), 9, 2023, true);


            inserirMeta(connection, 2, 2, new BigDecimal("800.00"), 9, 2023, true);

            inserirMeta(connection, 3, 1, new BigDecimal("1500.00"), 10, 2023, true);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void inserirMeta(Connection connection, int id, int idCategoria, BigDecimal valor, int mes, int ano, boolean ativo) throws SQLException {
        String sql = "INSERT INTO Meta (id, id_categoria, valor, mes, ano, ativo) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        statement.setInt(2, idCategoria);
        statement.setBigDecimal(3, valor);
        statement.setInt(4, mes);
        statement.setInt(5, ano);
        statement.setBoolean(6, ativo);

        statement.executeUpdate();

        System.out.println("Meta inserida com sucesso!");
        statement.close();
    }
}
