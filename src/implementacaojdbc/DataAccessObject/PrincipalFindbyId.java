package implementacaojdbc.DataAccessObject;

import java.sql.SQLException;
import java.util.Map;

public class PrincipalFindbyId {
    
    public static void main(String[] args) throws Exception {

        RelatorioPCDAO relatorioPCDAO = new RelatorioPCDAO();
        System.out.println(relatorioPCDAO.findById(1));

        ProjetoCofrinhoDAO projetoCofrinhoDAO1 = new ProjetoCofrinhoDAO();
        System.out.println(projetoCofrinhoDAO1.findById(1));
        
        CategoriaDAO categoriaDAO = new CategoriaDAO();
         System.out.println(categoriaDAO.findById(1));

        ContasDinheiroDAO contasDinheiroDAO = new ContasDinheiroDAO();
        System.out.println(contasDinheiroDAO.findById(2));

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        System.out.println(usuarioDAO.findById(3));

        LancamentoDAO lancamentoDAO = new LancamentoDAO();
        System.out.println(lancamentoDAO.findById(4));

       
   
    }}
    

