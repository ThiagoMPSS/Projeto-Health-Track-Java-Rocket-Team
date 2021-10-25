import dao.PressaoDAO;
import models.Pressao;

public class App {
    public static void main (String[] args) {
        System.out.println("******************************************");
        PressaoDAO pressaoDAO = new PressaoDAO();
        
        Pressao pressao1 = (Pressao) pressaoDAO.insert(new Pressao(1,12.8f));
        System.out.println("Código da ultima medição: " + pressao1.getCd_Medicao());
        
        Pressao pressao2 = (Pressao) pressaoDAO.insert(new Pressao(1,16.10f));
        System.out.println("Código da ultima medição: " + pressao2.getCd_Medicao());
        System.out.println("******************************************");
        
        Pressao[] listaPressao = (Pressao[])pressaoDAO.getAll();
        System.out.println("\nTodos os dados: ");
        for (Pressao s : listaPressao) {
            System.out.println(s);
        }
        System.out.println("******************************************\n");

        Pressao um = (Pressao) pressaoDAO.get(pressao2.getCd_Medicao());
        System.out.print("Um dado só: ");
        System.out.println(um);
        System.out.println("******************************************");
        
        //pressaoDAO.delete();
    }
}