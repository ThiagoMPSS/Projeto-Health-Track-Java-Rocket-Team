package models;

import java.sql.Date;
import java.util.Calendar;

public class Imc extends ModelDefault {
    private long cd_imc = 0;
    private long cd_usuario = 0;
    private float nr_peso = 0;
    private float nr_altura = 0;
    private Date dt_atualizacao = null;
    

    public Imc(long cd_imc, long cd_usuario, float nr_peso, float nr_altura, Date dt_atualizacao) {
        this.cd_imc = cd_imc;
        this.cd_usuario = cd_usuario;
        this.nr_peso = nr_peso;
        this.nr_altura = nr_altura;
        this.dt_atualizacao = dt_atualizacao;
    }

    public Imc(long cd_usuario, float nr_peso, float nr_altura) {
        this.cd_usuario = cd_usuario;
        this.nr_peso = nr_peso;
        this.nr_altura = nr_altura;
        this.dt_atualizacao = new Date(Calendar.getInstance().getTime().getTime());
    }


    public long getCd_imc() {
        return this.cd_imc;
    }

    public void setCd_imc(long cd_imc) {
        this.cd_imc = cd_imc;
    }

    public long getCd_usuario() {
        return this.cd_usuario;
    }

    public void setCd_usuario(long cd_usuario) {
        this.cd_usuario = cd_usuario;
    }

    public float getNr_peso() {
        return this.nr_peso;
    }

    public void setNr_peso(float nr_peso) {
        this.nr_peso = nr_peso;
    }

    public float getNr_altura() {
        return this.nr_altura;
    }

    public void setNr_altura(float nr_altura) {
        this.nr_altura = nr_altura;
    }

    public Date getDt_atualizacao() {
        return this.dt_atualizacao;
    }

    public void setDt_atualizacao(Date dt_atualizacao) {
        this.dt_atualizacao = dt_atualizacao;
    }

    public float getIMC_value() {
        return getNr_peso() / (getNr_altura() * getNr_altura());
    }
    
    @Override
    public String toString() {
        return "Codigo: " + getCd_imc() + "\n" + 
               "Usuario: " + getCd_usuario() + "\n" + 
               "Altura: " + getNr_altura() + "\n" + 
               "Peso: " + getNr_peso() + "\n" + 
               "Data: " + getDt_atualizacao();
    }

    @Override
    public Object getPK() {
        return getCd_imc();
    }

}
