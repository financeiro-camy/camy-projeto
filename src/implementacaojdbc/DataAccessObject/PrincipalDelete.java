package implementacaojdbc.DataAccessObject;

public class PrincipalDelete {
    public static void main(String[] args) {
        
            ProjetoCofrinhoDAO projetoCofrinhoDAO = new ProjetoCofrinhoDAO(); 
            Integer idParaExcluir = 1; 
        
            projetoCofrinhoDAO.delete(idParaExcluir);
        
            System.out.println("Projeto com ID " + idParaExcluir + " excluído com sucesso.");
    
        
    }
}
