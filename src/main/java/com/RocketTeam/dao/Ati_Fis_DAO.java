package com.RocketTeam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RocketTeam.config.ConnManager;
import com.RocketTeam.models.Ati_Fis;
import com.RocketTeam.models.ModelDefault;

public class Ati_Fis_DAO implements IDao {
    
    @Override
    public ModelDefault get(long cd_Ati_Fis) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_ATI_FIS WHERE CD_ATI_FIS = ?");
            pstmt.setLong(1, cd_Ati_Fis);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                long cd_usuario = result.getLong("cd_usuario");
                Date dt_atividade = result.getDate("dt_atividade");
                String ds_frequencia_ati_fis = result.getString("ds_frequencia_ati_fis");

                return new Ati_Fis(cd_Ati_Fis, cd_usuario, dt_atividade, ds_frequencia_ati_fis);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return null;
    }
    
    @Override
    public ModelDefault[] getByFk(long id) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();
        List<ModelDefault> ret = new ArrayList<ModelDefault>();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_ATI_FIS WHERE CD_USUARIO = ?");
            pstmt.setLong(1, id);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
            	 long cd = result.getLong("CD_ATI_FIS");
                 Date dt_atividade = result.getDate("dt_atividade");
                 String ds_frequencia_ati_fis = result.getString("ds_frequencia_ati_fis");

                 ret.add(new Ati_Fis(cd, id, dt_atividade, ds_frequencia_ati_fis));
            }


        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        ModelDefault[] retArray = new ModelDefault[ret.size()];
        ret.toArray(retArray);
        
        return retArray;
    }

    @Override
    public ModelDefault[] getAll() throws SQLException {
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
            throw e;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }

        Ati_Fis[] ArrayPressao = new Ati_Fis[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    public ModelDefault insert(Ati_Fis dados) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO T_ATI_FIS (cd_ati_fis, cd_usuario, dt_atividade, ds_frequencia_ati_fis) VALUES (SEQ_T_IMC.nextVal, ?, ?, ?)");
            pstmt.setFloat(1, dados.getCd_usuario());
            pstmt.setDate(2, dados.getDt_atividade());
            pstmt.setString(3, dados.getDs_frequencia_ati_fis());


            pstmt.executeUpdate();

            dados.setCd_ati_fis(getLastIndex());
            pstmt.close();
            return dados;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    @Override
    public ModelDefault insert(ModelDefault dados) throws SQLException {
        return insert((Ati_Fis) dados);
    }
    
	public void update(long id, Ati_Fis dados) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE T_ATI_FIS SET cd_usuario = ?, dt_atividade = ?, ds_frequencia_ati_fis = ? WHERE cd_ati_fis = ?");
            pstmt.setLong(1, dados.getCd_usuario());
            pstmt.setDate(2, dados.getDt_atividade());
            pstmt.setString(3, dados.getDs_frequencia_ati_fis());
            pstmt.setLong(4, id);

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
	}

	@Override
	public void update(long id, ModelDefault dados) throws SQLException {
		update(id, (Ati_Fis) dados);
	}

    public void delete() throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_ATI_FIS");

            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

	@Override
    public void delete(long id) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_ATI_FIS WHERE CD_ATI_FIS = ?");
            pstmt.setLong(1, id);
            
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
    }

    @Override
    public int getLastIndex() throws SQLException {
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
            throw e;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return Index;
    }
}
