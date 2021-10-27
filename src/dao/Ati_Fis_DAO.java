package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.ConnManager;
import models.Ati_Fis;
import models.ModelDefault;

public class Ati_Fis_DAO implements IDao {
    
    @Override
    public ModelDefault get(long cd_imc) {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_ATI_FIS WHERE CD_ATI_FIS = ?");
            pstmt.setLong(1, cd_imc);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                long cd_usuario = result.getLong("cd_usuario");
                Date dt_atividade = result.getDate("dt_atividade");
                String ds_frequencia_ati_fis = result.getString("ds_frequencia_ati_fis");

                return new Ati_Fis(cd_usuario, dt_atividade, ds_frequencia_ati_fis);
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_ATI_FIS");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd_ati_fis = result.getLong("cd_ati_fis");
                long cd_usuario = result.getLong("cd_usuario");
                Date dt_atividade = result.getDate("dt_atividade");
                String ds_frequencia_ati_fis = result.getString("ds_frequencia_ati_fis");

                listaPressao.add(new Ati_Fis(cd_ati_fis, cd_usuario, dt_atividade, ds_frequencia_ati_fis));
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

        Ati_Fis[] ArrayPressao = new Ati_Fis[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    public ModelDefault insert(Ati_Fis pressao) {
        return insert((ModelDefault) pressao);
    }

    @Override
    public ModelDefault insert(ModelDefault dados) {
        Ati_Fis imc = (Ati_Fis) dados;
        Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO T_ATI_FIS (cd_ati_fis, cd_usuario, dt_atividade, ds_frequencia_ati_fis) VALUES (SEQ_T_IMC.nextVal, ?, ?, ?)");
            pstmt.setFloat(1, imc.getCd_usuario());
            pstmt.setDate(2, imc.getDt_atividade());
            pstmt.setString(3, imc.getDs_frequencia_ati_fis());


            pstmt.executeUpdate();

            imc.setCd_ati_fis(getLastIndex());
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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_ATI_FIS");

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
                    "select cd_ati_fis from t_ati_fis order by cd_ati_fis desc fetch first 1 row only");
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
