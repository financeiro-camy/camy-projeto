package implementacaojdbc.DataAccessObject;
import java.time.LocalDate;
import java.util.Map;
import java.sql.SQLException;

public class PrincipalInserts {
    

	public static void main(String[] args) throws SQLException {
        
        /*ProjetoCofrinhoDAO projetoCofrinhoDAO = new ProjetoCofrinhoDAO();

        LocalDate prazo = LocalDate.of(2023, 4, 20);
        LocalDate dataCriacao = LocalDate.of(2023, 9, 23);

       ProjetoCofrinho projetoCofrinho = new ProjetoCofrinho (1,1, "Viagem Milão", "A viagem dos meus sonhos", prazo, dataCriacao, 15000.00,true);
       ProjetoCofrinho projetoCofrinho2 = new ProjetoCofrinho (2,1,"Carro","carro vermelho",prazo,dataCriacao,56000.00,true);
       ProjetoCofrinho projetoCofrinho3 = new ProjetoCofrinho (3,1,"Carro","carro preto",prazo,dataCriacao,56000.00,true);
       ProjetoCofrinho projetoCofrinho4 = new ProjetoCofrinho (4,1,"Plushie do Soobin","pelúcia do Soobin do txt",prazo,dataCriacao,220.00,true);
       ProjetoCofrinho projetoCofrinho5 = new ProjetoCofrinho (5,1,"Caneta","perdi a minha caneta",prazo,dataCriacao,30.00,true);
    
        ProjetoCofrinho projetoCriado = projetoCofrinhoDAO.create(projetoCofrinho);
        ProjetoCofrinho projetoCriado2 = projetoCofrinhoDAO.create(projetoCofrinho2);
        ProjetoCofrinho projetoCriado3 = projetoCofrinhoDAO.create(projetoCofrinho3);
        ProjetoCofrinho projetoCriado4 = projetoCofrinhoDAO.create(projetoCofrinho4);
        ProjetoCofrinho projetoCriado5 = projetoCofrinhoDAO.create(projetoCofrinho5); 

        CategoriaDAO categoriaDAO = new CategoriaDAO();

        Categoria categoria1 = new Categoria (1,1,"Alimentação");
        Categoria categoria2 = new Categoria (2,1,"Saúde");
        Categoria categoria3 = new Categoria (3,1,"Lazer");

        categoriaDAO.create(categoria1);
        categoriaDAO.create(categoria2);
        categoriaDAO.create(categoria3); 

        RelatorioPCDAO relatorioPCDAO = new RelatorioPCDAO();
        LocalDate datainsercao = LocalDate.of(2023, 10, 10);
        
        RelatorioPC relatorioPC = new RelatorioPC(1,1,1,240.0,datainsercao);

        relatorioPCDAO.create(relatorioPC); */

         LocalDate prazo = LocalDate.of(2023, 4, 20);
        LocalDate dataCriacao = LocalDate.of(2023, 9, 23);
        ProjetoCofrinho projetoCofrinho = new ProjetoCofrinho (1,1, "Viagem Milão", "A viagem dos meus sonhos", prazo, dataCriacao, 15000.00,true);

         try {
        RelatorioPCDAO relatorioPCDAO = new RelatorioPCDAO();
        Map<String, Double> resultado = relatorioPCDAO.valorArrecadado(projetoCofrinho);

        if (!resultado.isEmpty()) {
            double totalArrecadado = resultado.get("Projeto");
            double quantiaRestante = resultado.get("QuantiaRestante");
            double percentual = resultado.get("Percentual");

            System.out.println("Projeto: " + projetoCofrinho.getNome());
            System.out.println("Total arrecadado: " + totalArrecadado);
            System.out.println("Quantia restante: " + quantiaRestante);
            System.out.println("Percentual: " + percentual + "%");
        } else {
            System.out.println("Nenhum resultado encontrado para o projeto com ID " + projetoCofrinho.getId());
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }



        
    }
}

    
