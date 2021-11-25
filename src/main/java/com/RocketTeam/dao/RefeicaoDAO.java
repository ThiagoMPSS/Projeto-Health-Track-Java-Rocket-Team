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
import com.RocketTeam.models.Refeicao;

public class RefeicaoDAO implements IDao {
    @Override
    public ModelDefault get(long cd_refeicao) throws SQLException {
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
            throw e;
        }

        return null;
    }
    
    @Override
    public ModelDefault[] getByFk(long id) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();
        List<ModelDefault> ret = new ArrayList<ModelDefault>();

        try {
            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_REFE WHERE CD_USUARIO = ?");
            pstmt.setLong(1, id);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                long cd = result.getLong("cd_refeicao");
                String ds_alimento = result.getString("ds_alimento");
                float nr_calorias = result.getFloat("nr_calorias");
                Date dt_refeicao = result.getDate("dt_refeicao");
                

                ret.add(new Refeicao(cd, id, ds_alimento, nr_calorias, dt_refeicao));
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
            throw e;
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw e;
            }
        }

        Refeicao[] ArrayPressao = new Refeicao[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    public ModelDefault insert(Refeicao dados) throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "INSERT INTO T_REFE (cd_refeicao, cd_usuario, ds_alimento, nr_calorias, dt_refeicao) VALUES (SEQ_T_IMC.nextVal, ?, ?, ?, ?)");
            pstmt.setLong(1, dados.getCd_usuario());
            pstmt.setString(2, dados.getDs_alimento());
            pstmt.setFloat(3, dados.getNr_calorias());
            pstmt.setDate(4, dados.getDt_refeicao());


            pstmt.executeUpdate();

            dados.setCd_refeicao(getLastIndex());
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
    	return insert((Refeicao)dados);
    }

    public void update(long id, Refeicao dados) throws SQLException {
    	Connection conn = ConnManager.getInstance().getConn();
        
        try {
            PreparedStatement pstmt = conn.prepareStatement(
                    "UPDATE T_REFE SET cd_usuario = ?, ds_alimento = ?, nr_calorias = ?, dt_refeicao = ? WHERE cd_refeicao = ?");
            pstmt.setLong(1, dados.getCd_usuario());
            pstmt.setString(2, dados.getDs_alimento());
            pstmt.setFloat(3, dados.getNr_calorias());
            pstmt.setDate(4, dados.getDt_refeicao());
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
		update(id, (Refeicao) dados);
	}

    @Override
    public void delete() throws SQLException {
        Connection conn = ConnManager.getInstance().getConn();

        try {
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_REFE");

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
            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_REFE WHERE CD_REFEICAO = ?");
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
                    "select cd_refeicao from T_REFE order by cd_refeicao desc fetch first 1 row only");
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
