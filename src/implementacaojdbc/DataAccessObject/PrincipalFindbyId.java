package implementacaojdbc.DataAccessObject;

public class PrincipalFindbyId {
    
    public static void main(String[] args) {
        //ProjetoCofrinhoDAO projetoCofrinhoDAO1 = new ProjetoCofrinhoDAO();
        CategoriaDAO categoriaDAO = new CategoriaDAO();

        /*System.out.println(projetoCofrinhoDAO1.findById(1));
        System.out.println(projetoCofrinhoDAO1.findById(2));
        System.out.println(projetoCofrinhoDAO1.findById(3));*/

        System.out.println(categoriaDAO.findById(1));
        System.out.println(categoriaDAO.findById(2));
        System.out.println(categoriaDAO.findById(3));

    }
}
