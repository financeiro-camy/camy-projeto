package implementacaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CriarTabelas {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost/estudante?user=estudante&password=estudante&useSSL=true";
        String usuario = "estudante";
        String senha = "estudante";
        try (Connection connection = DriverManager.getConnection(url, usuario, senha)){

            String createUsuario = "CREATE TABLE Usuario (" +
                "id INT," +
                "nome VARCHAR(255) NOT NULL," +
                "email VARCHAR(255) NOT NULL," +
                "senha CHAR (100) NOT NULL," +
                "PRIMARY KEY (id));";
            connection.prepareStatement(createUsuario);

            String createCategoria = "CREATE TABLE Categoria (" +
                "id INT," +
                "id_usuario INT NOT NULL," +
                "nome VARCHAR(255) NOT NULL," +
                "tipo ENUM('despesa', 'receita') NOT NULL," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (id_usuario) REFERENCES Usuario(id));";
            connection.prepareStatement(createCategoria);

            String createContas = "CREATE TABLE ContasDinheiro (" +
                "id INT," +
                "id_usuario INT NOT NULL," +
                "nome VARCHAR(255) NOT NULL," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (id_usuario) REFERENCES Usuario(id));"; 
            connection.prepareStatement(createContas);

            String createDespesa = "CREATE TABLE Despesa (" +
                "id INT PRIMARY KEY," +
                "id_categoria INT NOT NULL," +
                "id_conta INT NOT NULL," + 
                "nome VARCHAR(100) NOT NULL," +
                "descricao VARCHAR(500)," +
                "valor DECIMAL(10, 2) NOT NULL," +
                "classificacao ENUM('fixa', 'parcelada', 'eventual') NOT NULL," +
                "data_vencimento DATE NOT NULL," +
                "pago BOOLEAN NOT NULL," +
                "data_pagamento DATE," +
                "periodicidade ENUM('diaria', 'semanal', 'mensal', 'anual')," +
                "numero_parcelas INT," +
                "FOREIGN KEY (id_categoria) REFERENCES Categoria(id)," +
                "FOREIGN KEY (id_conta) REFERENCES ContasDinheiro(id));";
            connection.prepareStatement(createDespesa);

            String createReceita = "CREATE TABLE Receita (" +
                "id INT PRIMARY KEY," +
                "id_categoria INT NOT NULL," +
                "id_conta INT NOT NULL," +
                "nome VARCHAR(100) NOT NULL," +
                "descricao VARCHAR(500)," +
                "valor DECIMAL(10, 2) NOT NULL," +
                "classificacao ENUM('fixa', 'parcelada', 'eventual') NOT NULL," +
                "data DATE NOT NULL," +
                "periodicidade ENUM('diaria', 'semanal', 'mensal', 'anual')," +
                "numero_parcelas INT," +
                "FOREIGN KEY (id_categoria) REFERENCES Categoria(id));";
            connection.prepareStatement(createReceita);

            String createParcela = "CREATE TABLE Parcela (" +
                "id INT PRIMARY KEY," +
                "id_lancamento INT NOT NULL," +
                "tipo_lancamento ENUM('despesa', 'receita') NOT NULL," +
                "numero INT NOT NULL," +
                "valor DECIMAL(10, 2) NOT NULL," +
                "data_vencimento DATE NOT NULL," +
                "pago BOOLEAN NOT NULL," +
                "data_pagamento DATE," +
                "FOREIGN KEY (id_lancamento) REFERENCES Despesa(id) ON DELETE CASCADE," +
                "FOREIGN KEY (id_lancamento) REFERENCES Receita(id) ON DELETE CASCADE;";
            connection.prepareStatement(createParcela);

            String createCofrinho = "CREATE TABLE ProjetoCofrinho (" +
                "id INT," +
                "nome VARCHAR(100) NOT NULL," +
                "descricao VARCHAR (500)," +
                "data_criacao DATE NOT NULL," +
                "prazo DATE," +
                "meta_quantia DECIMAL(10,2) NOT NULL," +
                "id_usuario INT NOT NULL," +
                "ativo BOOLEAN NOT NULL," +
                "PRIMARY KEY (id), FOREIGN KEY (id_usuario)" +
                "REFERENCES Usuario (id));" ;
            connection.prepareStatement(createCofrinho);

            String createRelatorioPc = "CREATE TABLE RelatorioPc(" +
                "id INT," +
                "id_cofrinho  INT NOT NULL," +
                "id_conta INT NOT NULL," +
                "valor DECIMAL(10,2)," +
                "data_insercao DATE," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (id_cofrinho) REFERENCES ProjetoCofrinho (id),"+
                "FOREIGN KEY (id_conta) REFERENCES ContasDinheiro (id));";
            connection.prepareStatement(createRelatorioPc);

            String createNotificacao = "CREATE TABLE Notificacao (" +
                "id INT," +
                "id_usuario INT NOT NULL," +
                "nome VARCHAR(100) NOT NULL," +
                "mensagem TEXT NOT NULL," +
                "data_envio TIMESTAMP DEFAULT CURRENT_TIMESTAMP," +
                "lida BOOLEAN DEFAULT FALSE," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (id_usuario) REFERENCES Usuario (id));";
            connection.prepareStatement(createNotificacao);

            String createMeta = "CREATE TABLE Meta (" +
                "id INT," +
                "id_categoria INT NOT NULL," +
                "valor DECIMAL(10, 2) NOT NULL," +
                "mes INT," +
                "ano INT," +
                "PRIMARY KEY (id)," +
                "FOREIGN KEY (id_categoria) REFERENCES Categoria(id));";
            connection.prepareStatement(createMeta);

            String createConfiguracao = "CREATE TABLE Configuracao (" +
                "ID INT PRIMARY KEY," +
                "id_usuario INT," +
                "moeda VARCHAR(50)," +
                "FOREIGN KEY (id_usuario) REFERENCES Usuario(ID));";
            connection.prepareStatement(createConfiguracao);

            String createHistoricoSaldos = "CREATE TABLE HistoricoSaldos (" +
                "id INT PRIMARY KEY," +
                "id_conta INT NOT NULL," +
                "data_registro DATE NOT NULL," +
                "saldo DECIMAL(10, 2) NOT NULL," +
                "FOREIGN KEY (id_conta) REFERENCES ContasDinheiro(id));";
            connection.prepareStatement(createHistoricoSaldos);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
