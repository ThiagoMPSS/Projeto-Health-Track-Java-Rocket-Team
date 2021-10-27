package models;

import java.sql.Date;

public class Ati_Fis extends ModelDefault {
    private long cd_ati_fis = 0;
    private long cd_usuario = 0;
    private Date dt_atividade = null;
    private String ds_frequencia_ati_fis = "";

    public Ati_Fis(long cd_ati_fis, long cd_usuario, Date dt_atividade, String ds_frequencia_ati_fis) {
        this.cd_ati_fis = cd_ati_fis;
        this.cd_usuario = cd_usuario;
        this.dt_atividade = dt_atividade;
        this.ds_frequencia_ati_fis = ds_frequencia_ati_fis;
    }

    public Ati_Fis(long cd_usuario, Date dt_atividade, String ds_frequencia_ati_fis) {
        this.cd_usuario = cd_usuario;
        this.dt_atividade = dt_atividade;
        this.ds_frequencia_ati_fis = ds_frequencia_ati_fis;
    }


    public long getCd_ati_fis() {
        return this.cd_ati_fis;
    }

    public void setCd_ati_fis(long cd_ati_fis) {
        this.cd_ati_fis = cd_ati_fis;
    }

    public long getCd_usuario() {
        return this.cd_usuario;
    }

    public void setCd_usuario(long cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public Date getDt_atividade() {
        return this.dt_atividade;
    }

    public void setDt_atividade(Date dt_atividade) {
        this.dt_atividade = dt_atividade;
    }

    public String getDs_frequencia_ati_fis() {
        return this.ds_frequencia_ati_fis;
    }

    public void setDs_frequencia_ati_fis(String ds_frequencia_ati_fis) {
        this.ds_frequencia_ati_fis = ds_frequencia_ati_fis;
    }

    @Override
    public String toString() {
        return "Codigo: " + getCd_ati_fis() + "\n" + 
               "Usuario: " + getCd_usuario() + "\n" + 
               "Data: " + getDt_atividade() + "\n" + 
               "Frequencia: " + getDs_frequencia_ati_fis();
    }

    @Override
    public Object getPK() {
        return getCd_ati_fis();
    }

}
