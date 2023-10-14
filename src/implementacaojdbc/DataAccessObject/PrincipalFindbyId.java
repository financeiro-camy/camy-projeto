package implementacaojdbc.DataAccessObject;

import java.sql.SQLException;
import java.util.Map;

public class PrincipalFindbyId {
    
    public static void main(String[] args) throws Exception {
        //ProjetoCofrinhoDAO projetoCofrinhoDAO1 = new ProjetoCofrinhoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        /*System.out.println(projetoCofrinhoDAO1.findById(1));
        System.out.println(projetoCofrinhoDAO1.findById(2));
        System.out.println(projetoCofrinhoDAO1.findById(3));

        System.out.println(categoriaDAO.findById(1));
        System.out.println(categoriaDAO.findById(2));
        System.out.println(categoriaDAO.findById(3)); */

        ContasDinheiroDAO contasDinheiroDAO = new ContasDinheiroDAO();
        System.out.println(contasDinheiroDAO.findById(2));
   
    }}
    

