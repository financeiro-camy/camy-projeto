package implementacaojdbc.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjetoCofrinhoDAO {
    public ProjetoCofrinho create(ProjetoCofrinho projetoCofrinho) throws SQLException {
        String sql = """
            INSERT INTO ProjetoCofrinho (id_usuario, nome, descricao, prazo, data_criacao, meta_quantia, ativo)
            VALUES (?, ?, ?, ?, ?, ?, ?);
        """;

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection
                .prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ) {
            statement.setInt(1, projetoCofrinho.getId_usuario());
            statement.setString(2, projetoCofrinho.getNome());
            statement.setString(3, projetoCofrinho.getDescricao());
            statement.setDate(4, projetoCofrinho.getPrazo());
            statement.setDate(5, projetoCofrinho.getDataCriacao());
            statement.setDouble(6, projetoCofrinho.getMetaQuantia());
            statement.setBoolean(7, projetoCofrinho.getAtivo());
            statement.executeUpdate();

            ResultSet rs = statement.getGeneratedKeys();

            if (rs.next()) {
                projetoCofrinho.setId(rs.getInt(1));
            }

            rs.close();

            return projetoCofrinho;

        }
    }

    public ProjetoCofrinho update(ProjetoCofrinho projetoCofrinho) throws SQLException {
        String sql = """
            UPDATE ProjetoCofrinho 
            SET id_usuario = ?, nome = ?, descricao = ?, prazo = ?, data_criacao = ?, meta_quantia = ?, ativo = ?
            WHERE id = ?;
        """;
    
        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, projetoCofrinho.getId_usuario());
            statement.setString(2, projetoCofrinho.getNome());
            statement.setString(3, projetoCofrinho.getDescricao());
            statement.setDate(4, projetoCofrinho.getPrazo());
            statement.setDate(5, projetoCofrinho.getDataCriacao());
            statement.setDouble(6, projetoCofrinho.getMetaQuantia());          
            statement.setBoolean(7, projetoCofrinho.getAtivo());
            statement.setInt(8, projetoCofrinho.getId());
            
            statement.executeUpdate();
            
            return projetoCofrinho;
        } catch (SQLException e) {
            return null;
        }
    }
    
    private ProjetoCofrinho resultSetToProjetoCofrinho(ResultSet rs) throws SQLException {
        return new ProjetoCofrinho(
            rs.getInt("id"),
            rs.getInt("id_usuario"),
            rs.getString("nome"),
            rs.getString("descricao"),
            rs.getDate("prazo"),
            rs.getDate("data_criacao"),
            rs.getDouble("meta_quantia"),
            rs.getBoolean("ativo")
        );
    }
}