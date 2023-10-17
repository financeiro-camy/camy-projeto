package implementacaojdbc.DataAccessObject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;

public class RelatorioPCDAO {
    
    public RelatorioPC create(RelatorioPC relatorioPC) throws SQLException {
        String sql = """
                INSERT INTO RelatorioPC (id, id_cofrinho, id_conta, valor, data_insercao)
                VALUES (?,?,?,?,?);
                """;

                try (
                    Connection connection = Conexao.getConnection();
                    PreparedStatement statement = connection
                        .prepareStatement(sql);
                ) {
                   
            statement.setInt(1, relatorioPC.getId());
            statement.setInt(2, relatorioPC.getId_cofrinho());
            statement.setInt(3, relatorioPC.getId_conta());
            statement.setDouble(4, relatorioPC.getValor());
            statement.setDate(5, Date.valueOf(relatorioPC.getData_insercao()));
           
            statement.executeUpdate();

        
            return relatorioPC;
                }
        }
        
        public RelatorioPC update(RelatorioPC relatorioPC) throws SQLException {
            String sql = "UPDATE RelatorioPC SET id_cofrinho=?, id_conta=?, valor=?, data_insercao=? WHERE id=?;";
    
            try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
            ) {
                statement.setInt(1, relatorioPC.getId_cofrinho());
                statement.setInt(2, relatorioPC.getId_conta());
                statement.setDouble(3, relatorioPC.getValor());
                statement.setDate(4, Date.valueOf(relatorioPC.getData_insercao()));
                statement.setInt(5, relatorioPC.getId());
    
                statement.executeUpdate();
    
                return relatorioPC;
            }
        }

        public void delete(Integer id) {
            String sql = "DELETE FROM RelatorioPC WHERE id = ?;";
    
            try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
            ) {
                statement.setInt(1, id);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    
        public void delete(RelatorioPC relatorioPC) {
            delete(relatorioPC.getId());
        }
    
        public RelatorioPC findById(Integer id) {
            String sql = "SELECT * FROM RelatorioPC WHERE id = ?;";
    
            try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
            ) {
                statement.setInt(1, id);
    
                ResultSet rs = statement.executeQuery();
    
                if (rs.next()) {
                    return resultSetToRelatorioPC(rs);
                }
    
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    
            return null;
        }

        public List<RelatorioPC> findAll() {
            String sql = "SELECT * FROM RelatorioPC;";
            List<RelatorioPC> relatorios = new ArrayList<>();
    
            try (
                Connection connection = Conexao.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(sql);
            ) {
                while (rs.next()) {
                    relatorios.add(resultSetToRelatorioPC(rs));
                }
    
                return relatorios;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        public Map<String, Double> valorArrecadado(ProjetoCofrinho projetoCofrinho) throws SQLException {
            String sql = "SELECT pc.nome AS Projeto, SUM(rpc.valor) AS TotalArrecadado, (pc.meta_quantia - SUM(rpc.valor)) AS QuantiaRestante " +
                         "FROM RelatorioPC rpc " +
                         "INNER JOIN ProjetoCofrinho pc ON rpc.id_cofrinho = pc.id " +
                         "WHERE rpc.id_cofrinho = ?;";
            
            Map<String, Double> resultado = new HashMap<>();
            double totalArrecadado = 0.0; // Inicialize totalArrecadado
            
            try (
                Connection connection = Conexao.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
            ) {
                statement.setInt(1, projetoCofrinho.getId());
            
                ResultSet rs = statement.executeQuery();
            
                if (rs.next()) {
                    String projeto = rs.getString("Projeto");
                    totalArrecadado = rs.getDouble("TotalArrecadado");
                    double quantiaRestante = rs.getDouble("QuantiaRestante");
                    double percentual = (totalArrecadado / projetoCofrinho.getMetaQuantia()) * 100; 
            
                    resultado.put("Projeto", totalArrecadado);
                    resultado.put("QuantiaRestante", quantiaRestante);
                    resultado.put("Percentual", percentual);
                }
            
                rs.close();
            }
            
            if (totalArrecadado == projetoCofrinho.getMetaQuantia()) {
                projetoCofrinho.setAtivo(false); 
                System.out.println("Projeto já completado!Parabéns!");
            }
            
            return resultado;
        }
        
        

        
private RelatorioPC resultSetToRelatorioPC(ResultSet rs) throws SQLException {
            return new RelatorioPC(
                rs.getInt("id"),
                rs.getInt("id_cofrinho"),
                rs.getInt("id_conta"),
                rs.getDouble("valor"),
                rs.getDate("data_insercao").toLocalDate()
            );
        }
    }