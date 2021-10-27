import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.List;

import dao.Ati_Fis_DAO;
import dao.IDao;
import dao.Imc_DAO;
import dao.PressaoDAO;
import dao.RefeicaoDAO;
import models.Ati_Fis;
import models.Imc;
import models.ModelDefault;
import models.Pressao;
import models.Refeicao;

public class App {
    public static void main (String[] args) {
        Random r = new Random();
        DadosFunc(new PressaoDAO(), new Pressao[] { 
            new Pressao(1, r.nextFloat(9.6f, 21.8f)),
            new Pressao(1, r.nextFloat(9.6f, 21.8f)),
            new Pressao(1, r.nextFloat(9.6f, 21.8f)),
            new Pressao(1, r.nextFloat(9.6f, 21.8f)),
            new Pressao(1, r.nextFloat(9.6f, 21.8f))
        });
        DadosFunc(new Imc_DAO(), new Imc[] { 
            new Imc(8, r.nextFloat(80f, 150f), r.nextFloat(.49f, 2f)),
            new Imc(8, r.nextFloat(80f, 150f), r.nextFloat(.49f, 2f)),
            new Imc(8, r.nextFloat(80f, 150f), r.nextFloat(.49f, 2f)),
            new Imc(8, r.nextFloat(80f, 150f), r.nextFloat(.49f, 2f)),
            new Imc(8, r.nextFloat(80f, 150f), r.nextFloat(.49f, 2f))
        });
        DadosFunc(new Ati_Fis_DAO(), new Ati_Fis[] {
            new Ati_Fis(1, new Date(Calendar.getInstance().getTime().getTime()), "asdasd"),
            new Ati_Fis(1, new Date(Calendar.getInstance().getTime().getTime()), "asdasd"),
            new Ati_Fis(1, new Date(Calendar.getInstance().getTime().getTime()), "asdasd"),
            new Ati_Fis(1, new Date(Calendar.getInstance().getTime().getTime()), "asdasd"),
            new Ati_Fis(1, new Date(Calendar.getInstance().getTime().getTime()), "asdasd")
        });
        DadosFunc(new RefeicaoDAO(), new Refeicao[] {
            new Refeicao(1, "adsads", r.nextFloat(.1f, 2f)),
            new Refeicao(1, "adsads", r.nextFloat(.1f, 2f)),
            new Refeicao(1, "adsads", r.nextFloat(.1f, 2f)),
            new Refeicao(1, "adsads", r.nextFloat(.1f, 2f)),
            new Refeicao(1, "adsads", r.nextFloat(.1f, 2f))
        });
    }

    private static void DadosFunc(IDao mDAO, ModelDefault[] dados) {
        System.out.println("******************************************");        
        //Insere 10 registros
        ModelDefault m1 = null;
        for (ModelDefault md : dados) {
            m1 = mDAO.insert(md);
            System.out.println("Novo dado inserido!");
        }
        System.out.print("******************************************");
        //Recupera todos os registros
        ModelDefault[] listaM = mDAO.getAll();
        for (ModelDefault s : listaM) {
            System.out.println("\n" + s);
        }
        System.out.println("******************************************");
        //Recupera um unico registro
        ModelDefault um = mDAO.get((long)m1.getPK());
        System.out.println(um);
        System.out.println("******************************************");
        //Remove todos os dados
        mDAO.delete();
        System.out.println("Dados Removidos!");
        System.out.println("******************************************");
        System.out.println();
        System.out.println();
    }
}