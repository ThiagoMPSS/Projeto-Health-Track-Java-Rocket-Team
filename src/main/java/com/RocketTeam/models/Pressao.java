package com.RocketTeam.models;

import java.sql.Date;
import java.util.Calendar;

public class Pressao extends ModelDefault {
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

    public Pressao(long cd_usuario, float nr_pressao, Date dt_medicao) {
        this.cd_usuario = cd_usuario;
        this.nr_pressao = nr_pressao;
        this.dt_medicao = dt_medicao;
    }

    public Pressao(long cd_usuario, float nr_pressao) {
        this.cd_usuario = cd_usuario;
        this.nr_pressao = nr_pressao;
        this.dt_medicao = new Date(Calendar.getInstance().getTime().getTime());
    }

    public long getCd_Medicao() {
        return this.cd_medicao;
    }

    public void setCd_Medicao(long cd_medicao) {
        this.cd_medicao = cd_medicao;
    }

    public long getCd_Usuario() {
        return this.cd_usuario;
    }

    public void setCd_Usuario(long cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public float getNr_Pressao() {
        return this.nr_pressao;
    }

    public void setNr_Pressao(float nr_pressao) {
        this.nr_pressao = nr_pressao;
    }

    public Date getDt_Medicao() {
        return this.dt_medicao;
    }

    public void setDt_Medicao(Date dt_medicao) {
        this.dt_medicao = dt_medicao;
    }

    @Override
    public String toString() {
        return ("Nr_pressao: " + getNr_Pressao() + "\n" +
                "Dt_medicao: " + getDt_Medicao());
    }

    @Override
    public Object getPK() {
        return getCd_Medicao();
    }
}