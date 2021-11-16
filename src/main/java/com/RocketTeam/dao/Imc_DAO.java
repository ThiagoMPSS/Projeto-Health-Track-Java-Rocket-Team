package com.RocketTeam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RocketTeam.config.ConnManager;
import com.RocketTeam.models.Imc;
import com.RocketTeam.models.ModelDefault;

public class Imc_DAO implements IDao {

    @Override
    public ModelDefault get(long cd_imc) {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_IMC WHERE CD_IMC = ?");
            pstmt.setLong(1, cd_imc);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                long cd_usuario = result.getLong("cd_imc");
                float nr_peso = result.getFloat("cd_usuario");
                float nr_altura = result.getFloat("nr_altura");
                Date dt_atualizacao = result.getDate("dt_atualizacao");

                return new Imc(cd_imc, cd_usuario, nr_peso, nr_altura, dt_atualizacao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ModelDefault[] getAll() {
        List<ModelDefault> listaPressao = new ArrayList<ModelDefault>();
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_IMC");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd_imc = result.getLong("cd_imc");
                long cd_usuario = result.getLong("cd_imc");
                float nr_peso = result.getFloat("cd_usuario");
                float nr_altura = result.getFloat("nr_altura");
                Date dt_atualizacao = result.getDate("dt_atualizacao");

                listaPressao.add(new Imc(cd_imc, cd_usuario, nr_peso, nr_altura, dt_atualizacao));
            }
            
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        Imc[] ArrayPressao = new Imc[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    public ModelDefault insert(Imc pressao) {
        return insert((ModelDefault) pressao);
    }

    @Override
    public ModelDefault insert(ModelDefault dados) {
        Imc imc = (Imc) dados;
        Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO T_IMC (cd_imc, cd_usuario, nr_peso, nr_altura, dt_atualizacao) VALUES(SEQ_T_IMC.nextVal, ?, ?, ?, ?)");
            pstmt.setLong(1, imc.getCd_usuario());
            pstmt.setFloat(2, imc.getNr_peso());
            pstmt.setFloat(3, imc.getNr_altura());
            pstmt.setDate(4, imc.getDt_atualizacao());


            pstmt.executeUpdate();

            imc.setCd_imc(getLastIndex());
            pstmt.close();
            return imc;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return imc;
    }

    public void delete() {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_IMC");

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getLastIndex() {
        int Index = 0;
        Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "select cd_imc from t_imc order by cd_imc desc fetch first 1 row only");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                Index = rs.getInt(1);
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return Index;
    }
}
