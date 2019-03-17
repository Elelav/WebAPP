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

public class DataBaseActivitiesHandler {

    private ArrayList<String> columnContent;
    DataBaseItem[] dbi;
    private String[] strArr;


    public DataBaseItem[] getDBI(String tableName) throws SQLException {        
        return getGamesTableContent(tableName);
    }
    
    private DataBaseItem[] getGamesTableContent(String tableName) throws SQLException {
        Connection conn = openSQLConnection();
        int i = 0;
        int rowCount = 0;
        int colCount = 0;
        Statement statement = conn.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("SELECT * FROM " + tableName);
        ResultSetMetaData rsmd = rs.getMetaData();
        colCount=rsmd.getColumnCount();
        rs = statement.executeQuery("SELECT COUNT(*) FROM " + tableName);
        while (rs.next()) {
            rowCount = rs.getInt(1);
        }
        columnContent = new ArrayList<>();
        dbi = new DataBaseItem[rowCount];       
        rs = statement.executeQuery("SELECT * FROM "+ tableName);
        while (rs.next()) {   
                strArr=new String[colCount];
                for(int j=1;j<=colCount;j++){
                        strArr[j-1]=rs.getString(j);
                        System.out.println("Adding to row : " + rs.getString(j));
                }
                columnContent.add(rs.getString(2));
                DataBaseItem dbiContent = new DataBaseItem();
                dbiContent.setItemValues(strArr, strArr.length);
                System.out.println("Adding to DBI : " + strArr[1]);
                dbi[i]=dbiContent;
                i++;
        }         
        rs.close();
        statement.close();
        conn.close();
        return dbi;
    }
    
    public void addNewGameToTable(String gameName, String gameGenre, int companyID, String platform, int pegi, String mainLanguage, int multiplayer, int coop, String releaseDate, double price) throws SQLException{
        Connection conn = openSQLConnection();
        Statement statement = conn.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("INSERT INTO GAMES (GAME_NAME,GAME_GENRE,COMPANY_ID,PLATFORM,PEGI,MAIN_LANGUAGE,MULTIPLAYER,CO_OP,RELEASE_DATE,PRICE)"
                + "VALUES('"+gameName+"','"+gameGenre+"',"+companyID+" ,'"+platform+"',"+pegi+",'"+mainLanguage+"','"+multiplayer+" ','"+coop+"',TO_DATE('"+releaseDate+"', 'DD.MM.YYYY'), "+price+")");     
        rs.close();
        statement.close();
        conn.close();
    }
    
   public void addNewCompanyToTable(String companyName, String homePage, String creationDate, String country) throws SQLException{
        Connection conn = openSQLConnection();
        Statement statement = conn.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("INSERT INTO COMPANIES (COMPANY_NAME,HOME_PAGE,CREATION_DATE,COUNTRY)"
                + "VALUES('"+companyName+"','"+homePage+"',"+"TO_DATE('"+creationDate+"', 'DD.MM.YYYY'),'"+country+"')");     
        rs.close();
        statement.close();
        conn.close();
    }
        
     public void addNewDeveloperToTable(String developerName, String employmentDate, String address, int companyID) throws SQLException{
        Connection conn = openSQLConnection();
        Statement statement = conn.createStatement();
        ResultSet rs;
        rs = statement.executeQuery("INSERT INTO DEVELOPERS (DEVELOPER_NAME,EMPLOYMENT_DATE,ADDRESS,COMPANY_ID)"
                + "VALUES('"+developerName+"',"+"TO_DATE('"+employmentDate+"','DD.MM.YYYY'), '"+address+"',"+companyID+")");     
        rs.close();
        statement.close();
        conn.close();
    }
    

    private Connection openSQLConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:superadmin/Genshiken_1@localhost:1521:XE");
        Connection conn = ods.getConnection();
        return conn;
    }

}
