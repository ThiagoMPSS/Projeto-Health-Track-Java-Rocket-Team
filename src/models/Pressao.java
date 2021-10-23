package models;

import java.sql.Date;

public class Pressao {
    private long cd_medicao = 0;
    private long cd_usuario;
    private float nr_pressao;
    private Date dt_medicao;

    public Pressao(long cd_medicao, long cd_usuario, float nr_pressao, Date dt_medicao){
        this.cd_medicao = cd_medicao;
        this.cd_usuario = cd_usuario;
        this.nr_pressao = nr_pressao;
        this.dt_medicao = dt_medicao;
    }

    public long getCd_medicao(){
        return cd_medicao;
    }

    public long getCd_usuario(){
        return cd_usuario;
    }

    public float getNr_pressao(){
        return nr_pressao;
    }

    public Date getDt_medicao(){
        return dt_medicao;
    }

    @Override
    public String toString() {
        return ("Nr_pressao: " + getNr_pressao() + "\n" +
                "Dt_medicao: " + getDt_medicao() + "\n");
    }
}