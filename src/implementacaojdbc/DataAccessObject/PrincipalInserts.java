package implementacaojdbc.DataAccessObject;
import java.time.LocalDate;
import java.util.Map;
import java.sql.SQLException;

public class PrincipalInserts {
    

	public static void main(String[] args) throws SQLException {
        
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
     Usuario usuario1 = new Usuario(1, "João Silva", "joao@email.com", "e7d80ffeefa212b7c5c55700e4f7193e", true);
     Usuario usuario2 = new Usuario(2, "Maria Santos", "maria@email.com", "58cb14423e912245bd2ef8a6841eba75", true);
     Usuario usuario3 = new Usuario(3, "Pedro Oliveira", "pedro@email.com", "e10adc3949ba59abbe56e057f20f883e", true);
     Usuario usuario4 = new Usuario(4, "Ana Pereira", "ana@email.com", "7c67e713a4b4139702de1a4fac672344", true);
     Usuario usuario5 = new Usuario(5, "Luiz Fernandes", "luiz@email.com", "ac152b7ba40ea05c7ba71b8e7c941cf4", true);

     usuarioDAO.create(usuario2);
     usuarioDAO.create(usuario3);
     usuarioDAO.create(usuario4);
     usuarioDAO.create(usuario5);

      ContasDinheiroDAO contasDinheiroDAO = new ContasDinheiroDAO();
      ContasDinheiro contasDinheiro1 = new ContasDinheiro(2,1,"Conta Sylvanian",56789.00,LocalDate.of(2023, 10, 13));
      contasDinheiroDAO.create(contasDinheiro1);
    
      
       CategoriaDAO categoriaDAO = new CategoriaDAO();

        Categoria categoria1 = new Categoria(1, 1, "Alimentação");
        Categoria categoria2 = new Categoria(2, 1, "Receita Principal");
        Categoria categoria3 = new Categoria(3, 1, "Salário");
        Categoria categoria4 = new Categoria(4, 1, "Moradia");
        Categoria categoria5 = new Categoria(5, 1, "Presentes");
        Categoria categoria6 = new Categoria(6, 1, "Carro");
        Categoria categoria7 = new Categoria(7,1, "Bonus");
        Categoria categoria8 = new Categoria(8,1,"Coleção Sylvanian Families");

        categoriaDAO.create(categoria1);
        categoriaDAO.create(categoria2);
        categoriaDAO.create(categoria3); 
        categoriaDAO.create(categoria4);
        categoriaDAO.create(categoria5); 
        categoriaDAO.create(categoria6); 
        categoriaDAO.create(categoria7);
        categoriaDAO.create(categoria8); 
        

      ProjetoCofrinhoDAO projetoCofrinhoDAO = new ProjetoCofrinhoDAO();

       ProjetoCofrinho projetoCofrinho = new ProjetoCofrinho (1,1, "Viagem Milão", "A viagem dos meus sonhos", LocalDate.of(2023,10,13), LocalDate.of(2023,10,13), 15000.00,true);
       ProjetoCofrinho projetoCofrinho2 = new ProjetoCofrinho (2,1,"Carro","carro vermelho",LocalDate.of(2023,12,31),LocalDate.of(2023,10,13),56000.00,true);
       ProjetoCofrinho projetoCofrinho3 = new ProjetoCofrinho (3,1,"Carro","carro preto",LocalDate.of(2024,9,15),LocalDate.of(2023,10,13),56000.00,true);
       ProjetoCofrinho projetoCofrinho4 = new ProjetoCofrinho (4,1,"Plushie do Soobin","pelúcia do Soobin do txt",LocalDate.of(2023,11,12),LocalDate.of(2023,10,11),220.00,true);
       ProjetoCofrinho projetoCofrinho5 = new ProjetoCofrinho (5,1,"Caneta","perdi a minha caneta",LocalDate.of(2025,12,31),LocalDate.of(2023,10,13),30.00,true);
    
        ProjetoCofrinho projetoCriado = projetoCofrinhoDAO.create(projetoCofrinho);
        ProjetoCofrinho projetoCriado2 = projetoCofrinhoDAO.create(projetoCofrinho2);
        ProjetoCofrinho projetoCriado3 = projetoCofrinhoDAO.create(projetoCofrinho3);
        ProjetoCofrinho projetoCriado4 = projetoCofrinhoDAO.create(projetoCofrinho4);
        ProjetoCofrinho projetoCriado5 = projetoCofrinhoDAO.create(projetoCofrinho5); 

        RelatorioPCDAO relatorioPCDAO = new RelatorioPCDAO();
        
        RelatorioPC relatorioPC = new RelatorioPC(1,1,2,240.0,LocalDate.of(2023,10,13));
        RelatorioPC relatorioPC2 = new RelatorioPC (12,1,2,12240.0,LocalDate.of(2023,10,13));
        RelatorioPC relatorioPC3 = new RelatorioPC(34,2,2,12400.0,LocalDate.of(2023,10,13));

        relatorioPCDAO.create(relatorioPC); 
        relatorioPCDAO.create(relatorioPC2); 
        relatorioPCDAO.create(relatorioPC3); 

        
        LancamentoDAO lancamentoDAO = new LancamentoDAO();
        Lancamento lancamento1 = new Lancamento(1,1,2,"Nuggets","faz tempo que não como nuggets",12.90,"despesa","eventual",1,LocalDate.of(2023,10,14),true, LocalDate.of(2023,10,14));
        Lancamento lancamento2 = new Lancamento(2, 4, 2, "Aluguel", "Pagamento mensal do aluguel", 1000.00, "despesa", "mensal", 1, LocalDate.of(2023,11,01), false, LocalDate.of(2023,11,01));
        Lancamento lancamento3 = new Lancamento(3, 3, 2, "Salário", "Recebimento de salário mensal", 2500.00, "receita", "mensal", 1, LocalDate.of(2023, 11, 05), true, LocalDate.of(2023, 11, 05));
        Lancamento lancamento4 = new Lancamento(4, 6, 2, "Seguro de Carro", "Pagamento anual do seguro do carro", 600.00, "despesa", "anual", 1, LocalDate.of(2023, 12, 15), false, LocalDate.of(2023, 12, 15));
        Lancamento lancamento5 = new Lancamento(5, 2, 2, "Venda de Itens no Mercado de Plushies", "Recebimento de vendas no mercado de plushies", 300.00, "receita", "eventual", 0, LocalDate.of(2023, 11, 20), false, LocalDate.of(2023, 11, 18));
        Lancamento lancamento6 = new Lancamento(6, 1, 2, "Supermercado", "Compras quinzenais de supermercado", 250.00, "despesa", "semanal", 2, LocalDate.of(2023, 10, 30), false, LocalDate.of(2023, 10, 28));
        Lancamento lancamento7 = new Lancamento(7, 2, 2, "Consultoria Freelancer", "Recebimento de honorários de consultoria", 800.00, "receita", "mensal", 1, LocalDate.of(2023, 12, 01), true, LocalDate.of(2023, 12, 01));
        Lancamento lancamento8 = new Lancamento(8, 6, 2, "Manutenção do Carro", "Manutenção trimestral do carro", 400.00, "despesa", "mensal", 3, LocalDate.of(2023, 11, 10), false, LocalDate.of(2023, 11, 4));
        Lancamento lancamento9 = new Lancamento(9, 7, 2, "Bônus Anual", "Recebimento de bônus de final de ano", 2000.00, "receita", "anual", 1, LocalDate.of(2023, 12, 05), true, LocalDate.of(2023, 12, 05));
        Lancamento lancamento10 = new Lancamento(10, 4, 2, "Conta de Luz", "Pagamento mensal da conta de luz", 150.00, "despesa", "mensal", 1, LocalDate.of(2023, 11, 30), true, LocalDate.of(2023, 11, 30));
        Lancamento lancamento11 = new Lancamento(11, 5, 2, "Presente de Aniversário", "Compra de presente de aniversário", 50.00, "despesa", "eventual", 0, LocalDate.of(2023, 10, 15), false, LocalDate.of(2023, 10, 9));
        Lancamento lancamento12 = new Lancamento(12,8,2,"Primeira Casa Sylvanian Family","Casinha da Coelho Chocolate",200.00,"despesa","eventual",1,LocalDate.of(2023,10,14),true,LocalDate.of(2023,10,14));

        lancamentoDAO.create(lancamento1);
        lancamentoDAO.create(lancamento2);
        lancamentoDAO.create(lancamento3);
        lancamentoDAO.create(lancamento4);
        lancamentoDAO.create(lancamento5);
        lancamentoDAO.create(lancamento6);
        lancamentoDAO.create(lancamento7);
        lancamentoDAO.create(lancamento8);
        lancamentoDAO.create(lancamento9);
        lancamentoDAO.create(lancamento10);
        lancamentoDAO.create(lancamento11);
        lancamentoDAO.create(lancamento12);
        
    }
}

