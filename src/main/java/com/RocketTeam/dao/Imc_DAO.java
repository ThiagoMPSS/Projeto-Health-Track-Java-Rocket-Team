package com.RocketTeam.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.RocketTeam.config.ConnManager;
import com.RocketTeam.models.Imc;
import com.RocketTeam.models.ModelDefault;

public class Imc_DAO implements IDao {

    @Override
    public ModelDefault get(long cd_imc) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_IMC WHERE CD_IMC = ?");
            pstmt.setLong(1, cd_imc);
            ResultSet result = pstmt.executeQuery();

            if (result.next()) {
                long cd_usuario = result.getLong("cd_usuario");
                float nr_peso = result.getFloat("nr_peso");
                float nr_altura = result.getFloat("nr_altura");
                Date dt_atualizacao = result.getDate("dt_atualizacao");

                return new Imc(cd_imc, cd_usuario, nr_peso, nr_altura, dt_atualizacao);
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_IMC WHERE CD_USUARIO = ?");
            pstmt.setLong(1, id);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd = result.getLong("cd_imc");
                float nr_peso = result.getFloat("nr_peso");
                float nr_altura = result.getFloat("nr_altura");
                Date dt_atualizacao = result.getDate("dt_atualizacao");

                ret.add(new Imc(cd, id, nr_peso, nr_altura, dt_atualizacao));
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
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_IMC");

            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd_imc = result.getLong("cd_imc");
                long cd_usuario = result.getLong("cd_usuario");
                float nr_peso = result.getFloat("nr_peso");
                float nr_altura = result.getFloat("nr_altura");
                Date dt_atualizacao = result.getDate("dt_atualizacao");

                listaPressao.add(new Imc(cd_imc, cd_usuario, nr_peso, nr_altura, dt_atualizacao));
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

        Imc[] ArrayPressao = new Imc[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    public ModelDefault insert(Imc dados) throws SQLException {
         Connection conn = ConnManager.getInstance().getConn();
         
         try {
             PreparedStatement pstmt = conn.prepareStatement(
                     "INSERT INTO T_IMC (cd_imc, cd_usuario, nr_peso, nr_altura, dt_atualizacao) VALUES(SEQ_T_IMC.nextVal, ?, ?, ?, ?)");
             pstmt.setLong(1, dados.getCd_usuario());
             pstmt.setFloat(2, dados.getNr_peso());
             pstmt.setFloat(3, dados.getNr_altura());
             pstmt.setDate(4, dados.getDt_atualizacao());


             pstmt.executeUpdate();

             dados.setCd_imc(getLastIndex());
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
       return insert((Imc) dados);
    }

    public void update(long id, Imc dados) throws SQLException {
    	Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE T_IMC SET cd_usuario = ?, nr_peso = ?, nr_altura = ?, dt_atualizacao = ? WHERE cd_imc = ?");
            pstmt.setLong(1, dados.getCd_usuario());
            pstmt.setFloat(2, dados.getNr_peso());
            pstmt.setFloat(3, dados.getNr_altura());
            pstmt.setDate(4, new Date(Calendar.getInstance().getTime().getTime()));
            pstmt.setLong(5, id);

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
		update(id, (Imc) dados);
	}

    public void delete() throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_IMC");

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
	            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_IMC WHERE CD_IMC = ?");
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
                    "select cd_imc from t_imc order by cd_imc desc fetch first 1 row only");
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
