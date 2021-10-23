package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import config.ConnManager;
import models.Pressao;

public class PressaoDAO implements IDao {
    
    @Override
    public Object get(long cd_medicao) {
        // TODO Auto-generated method stub
        
        try{
            Connection conn = ConnManager.getInstance().getConn();

            PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_PRESSAO_ART WHERE cd_medicao = ?");
            pstmt.setLong(1,cd_medicao);
            ResultSet result = pstmt.executeQuery();

            if(result.next()){
                long cd_usuario = result.getLong("cd_usuario");
                float nr_pressao = result.getFloat("nr_pressao");
                Date dt_medicao = result.getDate("dt_medicao");
                return new Pressao(cd_medicao,cd_usuario,nr_pressao,dt_medicao);
            }

        } catch(SQLException e){
            e.printStackTrace(); 
        }
        return null;
    }   

    @Override
    public Object[] getAll() {
        // TODO Auto-generated method stub
        List<Pressao> listaPressao = new ArrayList<Pressao>();
        
        try {
            Connection conn = ConnManager.getInstance().getConn();

           PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM T_PRESSAO_ART");

           ResultSet result = pstmt.executeQuery();

           while(result.next()){
            long cd_usuario = result.getLong("cd_usuario");
            long cd_medicao = result.getLong("cd_medicao");
            float nr_pressao = result.getFloat("nr_pressao");
            Date dt_medicao = result.getDate("dt_medicao");

            listaPressao.add(new Pressao (cd_medicao,cd_usuario,nr_pressao,dt_medicao));
           }
        

        } catch (SQLException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        Pressao[] ArrayPressao = new Pressao[listaPressao.size()];
        listaPressao.toArray(ArrayPressao);
        return ArrayPressao;
    }

    
    public void insert(int cd_usuario, float nr_pressao) {
        // TODO Auto-generated method stub
        try{
            Connection conn = ConnManager.getInstance().getConn();
            
          PreparedStatement pstmt = conn.prepareStatement("INSERT INTO T_PRESSAO_ART (cd_medicao,cd_usuario,nr_pressao,dt_medicao) VALUES(SEQ_T_PRESSAO_ART.nextVal,?,?,?)");
          pstmt.setInt(1,cd_usuario);
          pstmt.setFloat(2,nr_pressao);
          pstmt.setDate(3, new Date(Calendar.getInstance().getTime().getTime()));

          pstmt.executeUpdate();
          } catch(SQLException e){
              e.printStackTrace();
          }
    
    }

    @Override
    public void insert(){
        
    }

    public void delete(){
        try{
            Connection conn = ConnManager.getInstance().getConn();
            
          PreparedStatement pstmt = conn.prepareStatement("DELETE FROM T_PRESSAO_ART" );

          pstmt.executeUpdate();
          } catch(SQLException e){
              e.printStackTrace();
          }
    }

}
