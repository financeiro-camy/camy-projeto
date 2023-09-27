package implementacaojdbc.DataAccessObject;

import java.sql.SQLException;

public class Principal {
   
    public static void main(String[] args) throws SQLException {
        ProjetoCofrinhoDAO projetoCofrinhoDAO = new ProjetoCofrinhoDAO();
        ProjetoCofrinho projetoCofrinho = new ProjetoCofrinho("1", "Viagem Milão", "A viagem dos meus sonhos", 2024-04-20, 2023-09-23, 15000.00,true);
        ProjetoCofrinho projetoCriado = projetoCofrinhoDAO.create(projetoCofrinho);
        System.out.println(projetoCriado.getId());
        System.out.println(projetoCofrinhoDAO.findById(1));
    }
}
