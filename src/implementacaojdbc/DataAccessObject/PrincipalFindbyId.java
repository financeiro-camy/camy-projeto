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
    try {
        RelatorioPCDAO relatorioPCDAO = new RelatorioPCDAO();
        
        int idProjeto = 1;
        Map <String, Double> resultado = relatorioPCDAO.valorArrecadado(idProjeto);

        if (!resultado.isEmpty()) {
            for (Map.Entry<String, Double> entry : resultado.entrySet()) {
                String nomeProjeto = entry.getKey();
                double totalArrecadado = entry.getValue();

                System.out.println("Projeto: " + nomeProjeto);
                System.out.println("Total arrecadado: R$ " + totalArrecadado);
            }
        } else {
            System.out.println("Nenhum resultado encontrado para o projeto com ID " + idProjeto);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}

    

