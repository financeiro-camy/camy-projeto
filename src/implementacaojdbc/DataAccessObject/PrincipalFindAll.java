package implementacaojdbc.DataAccessObject;
import java.sql.SQLException;
import java.util.List;
public class PrincipalFindAll {
    public static void main(String[] args) throws SQLException {
    /* 
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
	*/

	LancamentoDAO lancamentoDAO = new LancamentoDAO();
	List<Lancamento> lancamentos = lancamentoDAO.findAll();

	if (lancamentos != null) {
    	for (Lancamento lancamento : lancamentos) {
        	System.out.println(lancamento); 
    	}
	} else {
    	System.out.println("Erro ao buscar os lancamentos.");
	}

    }
}
