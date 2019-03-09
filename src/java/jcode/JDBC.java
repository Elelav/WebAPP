package jcode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nikita
 */

import java.sql.*;
import java.util.*;
import oracle.jdbc.pool.OracleDataSource;



public class JDBC {
    
    private String versionInfo;
    private String curdate;
    private ArrayList <String> list = new ArrayList<>();
    private ArrayList <String> idList = new ArrayList<>();
    private ArrayList <String> curList = new ArrayList<>();

    
    public void SQLconnect() throws SQLException{
        
        DatabaseMetaData meta = openSQLConnection().getMetaData();
        System.out.println("JDBC driver version is " + meta.getDriverVersion());
        versionInfo = "JDBC driver version is " + meta.getDriverVersion();        
        Statement stmt = openSQLConnection().createStatement();
        ResultSet rset = stmt.executeQuery("INSERT INTO TUTURU (CUR_DATE) VALUES (SYSDATE)");
        rset.close();
        ResultSet rset2 =  stmt.executeQuery("SELECT TO_CHAR(MAX(CUR_DATE), 'yyyy.mm.dd HH24:MI:SS') AS LAST FROM TUTURU");        
        while(rset2.next()){
            curdate = rset2.getString("LAST");
        }
        rset2.close();
        ResultSet rset3 =  stmt.executeQuery("SELECT TO_CHAR(CUR_DATE,'yyyy.mm.dd HH24:MI:SS') AS CUR_DATE FROM TUTURU");
        while(rset3.next()){
            list.add(rset3.getString("CUR_DATE"));
        }        
        rset3.close();
        stmt.close();

    }
   
    
    public String getVersionInfo(){
        return versionInfo;
    }
    
    public String getCurDate(){
        return curdate;
    }
    
    public ArrayList getList(){       
        return list;
    }
    
    private Connection openSQLConnection() throws SQLException{
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:superadmin/3232@localhost:1521:XE");
        Connection conn = ods.getConnection();
        return conn;
    }
    private void closeSQLConnection(Connection conn) throws SQLException{
        conn.close();
    }
    
   /* public void simpleSQL() throws SQLException{        
        Statement stmt = openSQLConnection().createStatement();
        ResultSet rset = stmt.executeQuery("SELECT ID FROM TUTURU");
        while(rset.next()){
            idList.add(rset.getString("ID"));
        }        
        rset.close();
        ResultSet rset2 = stmt.executeQuery("SELECT TO_CHAR(CUR_DATE,'yyyy.mm.dd HH24:MI:SS') AS CUR_DATE FROM TUTURU");
        while(rset2.next()){
            idList.add(rset2.getString("CUR_DATE"));
        }        
        rset2.close();
    }
    
      public ArrayList<String> getIDList(){       
        return idList;
    }
        public ArrayList<String> getCurDateList(){       
        return curList;
    }
        
        public String[] lolArray(){
            String lolAr[]= new String[idList.size()];
            int i=0;
            for(String s: idList){
                lolAr[i]=s;
                i++;
            }
            return lolAr;
        }*/
        
        
}
