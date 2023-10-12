package implementacaojdbc.DataAccessObject;
import java.util.List;
public class PrincipalFindAll {
    public static void main(String[] args) {

    ProjetoCofrinhoDAO projetoCofrinhoDAO2 = new ProjetoCofrinhoDAO();
	CategoriaDAO categoriaDAO1 = new CategoriaDAO();
        
	 List<ProjetoCofrinho> projetos = projetoCofrinhoDAO2.findAll();
     List<Categoria> categorias = categoriaDAO1.findAll();
	  
	if (projetos != null) {
    	for (ProjetoCofrinho projeto : projetos) {
        	System.out.println(projeto); 
    	}
	} else {
    	System.out.println("Erro ao buscar os projetos.");
	}

	if (categorias != null) {
    	for (Categoria categoria : categorias) {
        	System.out.println(categoria); 
    	}
	} else {
    	System.out.println("Erro ao buscar os projetos.");
	}

    }
}
