package implementacaojdbc.DataAccessObject;
import java.util.List;
public class PrincipalFindAll {
    public static void main(String[] args) {

        ProjetoCofrinhoDAO projetoCofrinhoDAO2 = new ProjetoCofrinhoDAO();
        
	 List<ProjetoCofrinho> projetos = projetoCofrinhoDAO2.findAll();

	if (projetos != null) {
    	for (ProjetoCofrinho projeto : projetos) {
        	System.out.println(projeto); 
    	}
	} else {
    	System.out.println("Erro ao buscar os projetos.");
	}


    }
}
