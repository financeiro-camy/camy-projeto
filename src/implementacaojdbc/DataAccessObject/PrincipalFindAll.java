package implementacaojdbc.DataAccessObject;
import java.sql.SQLException;
import java.util.List;
public class PrincipalFindAll {
    public static void main(String[] args) throws SQLException {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
	List<Usuario> usuarios = usuarioDAO.findAll();

	if (usuarios != null) {
    	for (Usuario usuario : usuarios ) {
        	System.out.println(usuario); 
    	}
	} else {
    	System.out.println("Erro ao buscar os usuários.");
	}


    RelatorioPCDAO relatorioPCDAO = new RelatorioPCDAO();
	List<RelatorioPC> relatorios = relatorioPCDAO.findAll();
    
	if (relatorios != null) {
    	for (RelatorioPC relatorio : relatorios ) {
        	System.out.println(relatorio); 
    	}
	} else {
    	System.out.println("Erro ao buscar os relatórios.");
	}

    
	ContasDinheiroDAO contasDinheiroDAO = new ContasDinheiroDAO();
	List<ContasDinheiro> contasDinheiro = contasDinheiroDAO.findAll();
  
	if (contasDinheiro != null) {
    	for (ContasDinheiro conta : contasDinheiro) {
        	System.out.println(conta); 
    	}
	} else {
    	System.out.println("Erro ao buscar as contas.");
	}
    
	
    ProjetoCofrinhoDAO projetoCofrinhoDAO2 = new ProjetoCofrinhoDAO();
	List<ProjetoCofrinho> projetos = projetoCofrinhoDAO2.findAll();
  
	if (projetos != null) {
    	for (ProjetoCofrinho projeto : projetos) {
        	System.out.println(projeto); 
    	}
	} else {
    	System.out.println("Erro ao buscar os projetos.");
	}

	CategoriaDAO categoriaDAO1 = new CategoriaDAO();
    List<Categoria> categorias = categoriaDAO1.findAll();
	
	if (categorias != null) {
    	for (Categoria categoria : categorias) {
        	System.out.println(categoria); 
    	}
	} else {
    	System.out.println("Erro ao buscar as categorias.");
	}

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
