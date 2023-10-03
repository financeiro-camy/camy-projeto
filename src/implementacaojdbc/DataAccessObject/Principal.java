package implementacaojdbc.DataAccessObject;
import java.time.LocalDate;
import java.sql.SQLException;

public class Principal {
   
    public static void main(String[] args) throws SQLException {
        ProjetoCofrinhoDAO projetoCofrinhoDAO = new ProjetoCofrinhoDAO();

        LocalDate prazo = LocalDate.of(2023, 4, 20);
        LocalDate dataCriacao = LocalDate.of(2023, 9, 23);

        ProjetoCofrinho projetoCofrinho = new ProjetoCofrinho (1, "Viagem Milão", "A viagem dos meus sonhos", prazo, dataCriacao, 15000.00,true);
        ProjetoCofrinho projetoCriado = projetoCofrinhoDAO.create(projetoCofrinho);
        System.out.println(projetoCriado.getId());
        System.out.println(projetoCofrinhoDAO.findById(1));
    }
}
