package com.RocketTeam.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnManager {
  private static ConnManager instance;

  private ConnManager() {
  }

  public static ConnManager getInstance() {
    if (instance == null) {
      instance = new ConnManager();
    }
    return instance;
  }

  public Connection getConn() {
    Connection conn = null;

    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "system", "semsenha");
    } catch (SQLException e) {
      System.out.println(e);
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      System.out.println(e);
      e.printStackTrace();
    }
    return conn;
  }
}