package implementacaojdbc.DataAccessObject;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LancamentoDAO {
    
    public Lancamento create(Lancamento lancamento) throws SQLException {
        String sql = "INSERT INTO Lancamento (id, id_categoria, id_conta, nome, descricao, valor, tipo, periodicidade, numero_parcelas, data_vencimento, pago, data_pagamento) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, lancamento.getId());
            statement.setInt(2, lancamento.getIdCategoria());
            statement.setInt(3, lancamento.getIdConta());
            statement.setString(4, lancamento.getNome());
            statement.setString(5, lancamento.getDescricao());
            statement.setDouble(6, lancamento.getValor());
            statement.setString(7, lancamento.getTipo());
            statement.setString(8, lancamento.getPeriodicidade());
            statement.setInt(9, lancamento.getNumeroParcelas());
            statement.setDate(10, Date.valueOf(lancamento.getDataVencimento()));
            statement.setBoolean(11, lancamento.isPago());
            statement.setDate(12, Date.valueOf(lancamento.getDataPagamento()));

            statement.executeUpdate();
        }

        return lancamento;
    }
    
    public Lancamento update(Lancamento lancamento) throws SQLException {
        String sql = "UPDATE Lancamento SET id_categoria=?, id_conta=?, nome=?, descricao=?, valor=?, tipo=?, periodicidade=?, numero_parcelas=?, data_vencimento=?, pago=?, data_pagamento=? " +
                     "WHERE id=?";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, lancamento.getIdCategoria());
            statement.setInt(2, lancamento.getIdConta());
            statement.setString(3, lancamento.getNome());
            statement.setString(4, lancamento.getDescricao());
            statement.setDouble(5, lancamento.getValor());
            statement.setString(6, lancamento.getTipo());
            statement.setString(7, lancamento.getPeriodicidade());
            statement.setInt(8, lancamento.getNumeroParcelas());
            statement.setDate(9, Date.valueOf(lancamento.getDataVencimento()));
            statement.setBoolean(10, lancamento.isPago());
            statement.setDate(11, Date.valueOf(lancamento.getDataPagamento()));
            statement.setInt(12, lancamento.getId());

            statement.executeUpdate();
        }

        return lancamento;
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM Lancamento WHERE id=?";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }

    public Lancamento findById(int id) throws SQLException {
        String sql = "SELECT * FROM Lancamento WHERE id=?";

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSetToLancamento(resultSet);
            }
        }

        return null;
    }

    public List<Lancamento> findAll() throws SQLException {
        String sql = "SELECT * FROM Lancamento";
        List<Lancamento> lancamentos = new ArrayList<>();

        try (
            Connection connection = Conexao.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
        ) {
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Lancamento lancamento = resultSetToLancamento(resultSet);
                lancamentos.add(lancamento);
            }
        }

        return lancamentos;
    }

    private Lancamento resultSetToLancamento(ResultSet rs) throws SQLException {
        return new Lancamento(
            rs.getInt("id"),
            rs.getInt("id_categoria"),
            rs.getInt("id_conta"),
            rs.getString("nome"),
            rs.getString("descricao"),
            rs.getDouble("valor"),
            rs.getString("tipo"),
            rs.getString("periodicidade"),
            rs.getInt("numero_parcelas"),
            rs.getDate("data_vencimento").toLocalDate(),
            rs.getBoolean("pago"),
            rs.getDate("data_pagamento") != null ? rs.getDate("data_pagamento").toLocalDate() : null
        );
    }
    
}

