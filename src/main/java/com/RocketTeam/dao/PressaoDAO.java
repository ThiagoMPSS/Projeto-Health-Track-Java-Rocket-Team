package com.RocketTeam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RocketTeam.config.ConnManager;
import com.RocketTeam.models.ModelDefault;
import com.RocketTeam.models.Pressao;

public class PressaoDAO implements IDao {

    @Override
    public ModelDefault get(long cd_medicao) {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_PRESSAO_ART WHERE cd_medicao = ?");
            pstmt.setLong(1, cd_medicao);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                long cd_usuario = result.getLong("t_usuario_cd_usuario");
                float nr_pressao = result.getFloat("nr_pressao");
                Date dt_medicao = result.getDate("dt_medicao");
                return new Pressao(cd_medicao, cd_usuario, nr_pressao, dt_medicao);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public ModelDefault[] getAll() {
        List<ModelDefault> listaPressao = new ArrayList<ModelDefault>();
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_PRESSAO_ART");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd_usuario = result.getLong("t_usuario_cd_usuario");
                long cd_medicao = result.getLong("cd_medicao");
                float nr_pressao = result.getFloat("nr_pressao");
                Date dt_medicao = result.getDate("dt_medicao");

                listaPressao.add(new Pressao(cd_medicao, cd_usuario, nr_pressao, dt_medicao));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        Pressao[] ArrayPressao = new Pressao[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    public ModelDefault insert(Pressao pressao) {
        return insert((ModelDefault) pressao);
    }

    @Override
    public ModelDefault insert(ModelDefault dados) {
        Pressao pressao = (Pressao) dados;
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO T_PRESSAO_ART (cd_medicao, t_usuario_cd_usuario, nr_pressao, dt_medicao) VALUES(SEQ_T_PRESSAO_ART.nextVal, ?, ?, ?)");
            pstmt.setLong(1, pressao.getCd_Usuario());
            pstmt.setFloat(2, pressao.getNr_Pressao());
            pstmt.setDate(3, pressao.getDt_Medicao());

            pstmt.executeUpdate();

            pressao.setCd_Medicao(getLastIndex());
            return pressao;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return pressao;
    }

    public void delete() {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_PRESSAO_ART");

            pstmt.executeUpdate();
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
                    "select cd_medicao from t_pressao_art order by cd_medicao desc fetch first 1 row only");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                Index = rs.getInt(1);
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
