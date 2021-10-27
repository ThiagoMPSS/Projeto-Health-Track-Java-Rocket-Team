package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnManager;
import models.ModelDefault;
import models.Refeicao;

public class RefeicaoDAO implements IDao {
    @Override
    public ModelDefault get(long cd_refeicao) {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_REFE WHERE CD_REFEICAO = ?");
            pstmt.setLong(1, cd_refeicao);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                long cd_usuario = result.getLong("cd_usuario");
                String ds_alimento = result.getString("ds_alimento");
                float nr_calorias = result.getFloat("nr_calorias");
                Date dt_refeicao = result.getDate("dt_refeicao");
                

                return new Refeicao(cd_refeicao, cd_usuario, ds_alimento, nr_calorias, dt_refeicao);
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_REFE");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd_refeicao = result.getLong("cd_refeicao");
                long cd_usuario = result.getLong("cd_usuario");
                String ds_alimento = result.getString("ds_alimento");
                float nr_calorias = result.getFloat("nr_calorias");
                Date dt_refeicao = result.getDate("dt_refeicao");

                listaPressao.add(new Refeicao(cd_refeicao, cd_usuario, ds_alimento, nr_calorias, dt_refeicao));
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

        Refeicao[] ArrayPressao = new Refeicao[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    public ModelDefault insert(Refeicao pressao) {
        return insert((ModelDefault) pressao);
    }

    @Override
    public ModelDefault insert(ModelDefault dados) {
        Refeicao refeicao = (Refeicao) dados;
        Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO T_REFE (cd_refeicao, cd_usuario, ds_alimento, nr_calorias, dt_refeicao) VALUES (SEQ_T_IMC.nextVal, ?, ?, ?, ?)");
            pstmt.setLong(1, refeicao.getCd_usuario());
            pstmt.setString(2, refeicao.getDs_alimento());
            pstmt.setFloat(3, refeicao.getNr_calorias());
            pstmt.setDate(4, refeicao.getDt_refeicao());


            pstmt.executeUpdate();

            refeicao.setCd_refeicao(getLastIndex());
            pstmt.close();
            return refeicao;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return refeicao;
    }

    @Override
    public void delete() {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_REFE");

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
                    "select cd_refeicao from T_REFE order by cd_refeicao desc fetch first 1 row only");
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
