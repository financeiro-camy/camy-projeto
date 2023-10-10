package implementacaojdbc.DataAccessObject;
import java.sql.SQLException;
import java.time.LocalDate;
public class PrincipalUpdate {
    
public static void main(String[] args) throws SQLException {

    LocalDate prazo = LocalDate.of(2023, 4, 20);
    LocalDate dataCriacao = LocalDate.of(2023, 9, 23);

	ProjetoCofrinhoDAO projetoCofrinhoDAO3 = new ProjetoCofrinhoDAO();
	ProjetoCofrinho projetoToUpdate = new ProjetoCofrinho(6,1, "Viagem Milão", "A viagem dos meus sonhos", prazo, dataCriacao, 15000.00,true);
	projetoToUpdate.setId(6); 
	projetoToUpdate.setIdUsuario(1);
	projetoToUpdate.setNome("Franquia Mc Donald's"); 
	projetoToUpdate.setDescricao("comer hamburguer de graça todos os dias");
	projetoToUpdate.setPrazo(LocalDate.of(2023, 12, 31));
	projetoToUpdate.setDataCriacao(LocalDate.now());
	projetoToUpdate.setMetaQuantia(1000.0);
	projetoToUpdate.setAtivo(true);

    projetoCofrinhoDAO3.create(projetoToUpdate);

	try {
    	ProjetoCofrinho projetoAtualizado = projetoCofrinhoDAO3.update(projetoToUpdate);
    	if (projetoAtualizado != null) {
        	System.out.println("Projeto atualizado com sucesso: " + projetoAtualizado);
    	} else {
        	System.out.println("Erro ao atualizar o projeto.");
    	}
	} catch (SQLException e) {
    	System.out.println("Erro SQL ao atualizar o projeto: " + e.getMessage());
	}
}


}
