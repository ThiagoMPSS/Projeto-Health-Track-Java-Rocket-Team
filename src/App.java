import java.lang.reflect.Array;

import config.ConnManager;
import dao.PressaoDAO;
import models.Pressao;

public class App {
    public static void main (String[] args) {
        PressaoDAO pressaoDAO = new PressaoDAO();
        
        pressaoDAO.insert(1,12.8f);
        pressaoDAO.insert(1,16.10f);

        Pressao[] listaPressao = (Pressao[])pressaoDAO.getAll();
        System.out.print("Todos os dados: ");
        System.out.println(listaPressao);

        Pressao um = (Pressao) pressaoDAO.get(18);
        System.out.print("Um dado só: ");
        System.out.println(um);
        
        //pressaoDAO.delete();
    }
}