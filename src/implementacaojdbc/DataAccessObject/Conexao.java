package implementacaojdbc.DataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao{
    
        public static Connection getConnection() {
            String url = "jdbc:mysql://127.0.0.1:3306/Camy?user=root&password=ditto&useSSL=true";
            try {
                return DriverManager.getConnection(url);
            } catch (SQLException e) {
                e.printStackTrace();
                 throw new RuntimeException("Erro ao conectar ao Banco.");
            }
        }
    }

 
