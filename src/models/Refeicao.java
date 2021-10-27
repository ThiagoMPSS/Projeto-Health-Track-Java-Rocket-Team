package models;

import java.sql.Date;
import java.util.Calendar;

public class Refeicao extends ModelDefault {
    private long cd_refeicao = 0;
    private long cd_usuario = 0;
    private String ds_alimento = "";
    private float nr_calorias = 0;
    private Date dt_refeicao = null;


    public Refeicao(long cd_refeicao, long cd_usuario, String ds_alimento, float nr_calorias, Date dt_refeicao) {
        this.cd_refeicao = cd_refeicao;
        this.cd_usuario = cd_usuario;
        this.ds_alimento = ds_alimento;
        this.nr_calorias = nr_calorias;
        this.dt_refeicao = dt_refeicao;
    }

    public Refeicao(long cd_usuario, String ds_alimento, float nr_calorias) {
        this.cd_usuario = cd_usuario;
        this.ds_alimento = ds_alimento;
        this.nr_calorias = nr_calorias;
        this.dt_refeicao = new Date(Calendar.getInstance().getTime().getTime());
    }

    public long getCd_refeicao() {
        return this.cd_refeicao;
    }

    public void setCd_refeicao(long cd_refeicao) {
        this.cd_refeicao = cd_refeicao;
    }

    public long getCd_usuario() {
        return this.cd_usuario;
    }

    public void setCd_usuario(long cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public String getDs_alimento() {
        return this.ds_alimento;
    }

    public void setDs_alimento(String ds_alimento) {
        this.ds_alimento = ds_alimento;
    }

    public float getNr_calorias() {
        return this.nr_calorias;
    }

    public void setNr_calorias(float nr_calorias) {
        this.nr_calorias = nr_calorias;
    }

    public Date getDt_refeicao() {
        return this.dt_refeicao;
    }

    public void setDt_refeicao(Date dt_refeicao) {
        this.dt_refeicao = dt_refeicao;
    }

    @Override
    public String toString() {
        return "Codigo: " + getCd_refeicao() + "\n" + 
               "Usuario: " + getCd_usuario() + "\n" + 
               "Calorias: " + getNr_calorias() + "\n" + 
               "Alimento: " + getDs_alimento() + "\n" + 
               "Data: " + getDt_refeicao();
    }

    @Override
    public Object getPK() {
        return getCd_refeicao();
    }

}
