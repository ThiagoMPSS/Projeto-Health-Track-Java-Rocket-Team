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
    public ModelDefault get(long cd_medicao) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_PRESSAO_ART WHERE cd_medicao = ?");
            pstmt.setLong(1, cd_medicao);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                long cd_usuario = result.getLong("cd_usuario");
                float nr_pressao = result.getFloat("nr_pressao");
                Date dt_medicao = result.getDate("dt_medicao");
                return new Pressao(cd_medicao, cd_usuario, nr_pressao, dt_medicao);
            }

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
        return null;
    }
    
    @Override
    public ModelDefault[] getByFk(long id) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();
        List<ModelDefault> ret = new ArrayList<ModelDefault>();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_PRESSAO_ART WHERE cd_usuario = ?");
            pstmt.setLong(1, id);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd = result.getLong("cd_medicao");
                float nr_pressao = result.getFloat("nr_pressao");
                Date dt_medicao = result.getDate("dt_medicao");
                
                ret.add(new Pressao(cd, id, nr_pressao, dt_medicao));
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_PRESSAO_ART");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd_usuario = result.getLong("cd_usuario");
                long cd_medicao = result.getLong("cd_medicao");
                float nr_pressao = result.getFloat("nr_pressao");
                Date dt_medicao = result.getDate("dt_medicao");

                listaPressao.add(new Pressao(cd_medicao, cd_usuario, nr_pressao, dt_medicao));
            }

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
        Pressao[] ArrayPressao = new Pressao[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    public ModelDefault insert(Pressao dados) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO T_PRESSAO_ART (cd_medicao, cd_usuario, nr_pressao, dt_medicao) VALUES(SEQ_T_PRESSAO_ART.nextVal, ?, ?, ?)");
            pstmt.setLong(1, dados.getCd_Usuario());
            pstmt.setFloat(2, dados.getNr_Pressao());
            pstmt.setDate(3, dados.getDt_Medicao());

            pstmt.executeUpdate();

            dados.setCd_Medicao(getLastIndex());
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
    	return insert((Pressao) dados); 
    }

    public void update(long id, Pressao dados) throws SQLException {
    	Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE T_PRESSAO_ART SET cd_usuario = ?, nr_pressao = ?, dt_medicao = ? WHERE cd_medicao = ?");
            pstmt.setLong(1, dados.getCd_Usuario());
            pstmt.setFloat(2, dados.getNr_Pressao());
            pstmt.setDate(3, dados.getDt_Medicao());
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
		update(id, (Pressao) dados);
	}

    public void delete() throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_PRESSAO_ART");

            pstmt.executeUpdate();
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
	            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_PRESSAO_ART WHERE cd_medicao = ?");
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
                    "select cd_medicao from t_pressao_art order by cd_medicao desc fetch first 1 row only");
            ResultSet rs = pstmt.executeQuery();

            if (rs.next())
                Index = rs.getInt(1);
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
