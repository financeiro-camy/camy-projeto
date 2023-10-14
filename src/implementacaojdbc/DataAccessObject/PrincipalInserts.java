package implementacaojdbc.DataAccessObject;
import java.time.LocalDate;
import java.util.Map;
import java.sql.SQLException;

public class PrincipalInserts {
    

	public static void main(String[] args) throws SQLException {
        
      ContasDinheiroDAO contasDinheiroDAO = new ContasDinheiroDAO();
      ContasDinheiro contasDinheiro1 = new ContasDinheiro(2,1,"Conta Sylvanian",56789.00,LocalDate.of(2023, 10, 13));
      contasDinheiroDAO.create(contasDinheiro1);
      
       CategoriaDAO categoriaDAO = new CategoriaDAO();

        Categoria categoria1 = new Categoria (1,1,"Alimentação");
        Categoria categoria2 = new Categoria (2,1,"Saúde");
        Categoria categoria3 = new Categoria (3,1,"Lazer");

        categoriaDAO.create(categoria1);
        categoriaDAO.create(categoria2);
        categoriaDAO.create(categoria3); 
    
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

    }
}

    
