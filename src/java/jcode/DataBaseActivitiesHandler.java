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
import oracle.jdbc.pool.OracleDataSource;

public class DataBaseActivitiesHandler {

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
        colCount = rsmd.getColumnCount();
        rs = statement.executeQuery("SELECT COUNT(*) FROM " + tableName);
        while (rs.next()) {
            rowCount = rs.getInt(1);
        }
        dbi = new DataBaseItem[rowCount];
        rs = statement.executeQuery("SELECT * FROM " + tableName);
        while (rs.next()) {
            strArr = new String[colCount];
            for (int j = 1; j <= colCount; j++) {
                strArr[j - 1] = rs.getString(j);
            }
            DataBaseItem dbiContent = new DataBaseItem();
            dbiContent.setItemValues(strArr, strArr.length);
            dbi[i] = dbiContent;
            i++;
        }
        rs.close();
        statement.close();
        conn.close();
        return dbi;
    }

    public void addNewGameToTable(String gameName, String gameGenre, int companyID, String platform, int pegi,
            String mainLanguage, int multiplayer, int coop, String releaseDate, double price) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("INSERT INTO GAMES (GAME_NAME,GAME_GENRE,COMPANY_ID,PLATFORM,PEGI,MAIN_LANGUAGE,MULTIPLAYER,CO_OP,RELEASE_DATE,PRICE)"
                    + "VALUES('"
                    + gameName + "','"
                    + gameGenre + "',"
                    + companyID + " ,'"
                    + platform + "',"
                    + pegi + ",'"
                    + mainLanguage + "','"
                    + multiplayer + " ','"
                    + coop
                    + "',TO_DATE('" + releaseDate + "', 'DD.MM.YYYY'), "
                    + price + ")");
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {

        }
    }

    public void addNewCompanyToTable(String companyName, String homePage, String creationDate, String country) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("INSERT INTO COMPANIES (COMPANY_NAME,HOME_PAGE,CREATION_DATE,COUNTRY)"
                    + "VALUES('"
                    + companyName + "','"
                    + homePage + "',"
                    + "TO_DATE('" + creationDate + "', 'DD.MM.YYYY'),'"
                    + country + "')");
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {

        }
    }

    public void addNewDeveloperToTable(String developerName, String employmentDate, String address, int companyID) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("INSERT INTO DEVELOPERS (DEVELOPER_NAME,EMPLOYMENT_DATE,ADDRESS,COMPANY_ID)"
                    + "VALUES('"
                    + developerName + "',"
                    + "TO_DATE('" + employmentDate + "','DD.MM.YYYY'), '"
                    + address + "',"
                    + companyID + ")"
            );
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {

        }
    }

    public void setNewValuesToCompany(int companyID, String companyName, String homePage, String creationDate, String country) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("UPDATE COMPANIES "
                    + "SET "
                    + "COMPANY_NAME = '" + companyName + "',"
                    + "HOME_PAGE = '" + homePage + "',"
                    + "CREATION_DATE = TO_DATE('" + creationDate + "','DD.MM.YYYY'),"
                    + "COUNTRY = '" + country + "'"
                    + "WHERE COMPANY_ID = '" + companyID + "'"
            );
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL error : " + e.getMessage());
        }
    }

    public void setNewValuesToDeveloper(int developerID, String developerName, String employmentDate, String address, int companyID) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("UPDATE DEVELOPERS "
                    + "SET "
                    + "DEVELOPER_NAME = '" + developerName + "',"
                    + "EMPLOYMENT_DATE = TO_DATE('" + employmentDate + "','DD.MM.YYYY'),"
                    + "ADDRESS = '" + address + "',"
                    + "COMPANY_ID = '" + companyID + "'"
                    + "WHERE DEVELOPER_ID = '" + developerID + "'"
            );
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL error : " + e.getMessage());
        }
    }

    public void setNewValuesToGame(int gameID, String gameName, String gameGenre, int companyID, String platform, int pegi,
            String mainLanguage, int multiplayer, int coop, String releaseDate, double price) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs;

            rs = statement.executeQuery("UPDATE GAMES "
                    + "SET "
                    + "GAME_NAME = '" + gameName + "',"
                    + "GAME_GENRE = '" + gameGenre + "',"
                    + "COMPANY_ID = " + companyID + ","
                    + "PLATFORM = '" + platform + "',"
                    + "PEGI = " + pegi + ","
                    + "MAIN_LANGUAGE = '" + mainLanguage + "',"
                    + "MULTIPLAYER = " + multiplayer + ","
                    + "CO_OP = " + coop + ","
                    + "RELEASE_DATE = TO_DATE('" + releaseDate + "','DD.MM.YYYY'),"
                    + "PRICE = " + price + ""
                    + "WHERE GAME_ID= " + gameID + ""
            );
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL error : " + e.getMessage());
        }
    }

    public DataBaseItem getItemByID(String ID, String tableName) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            String idColumnName = "";
            int colCount = 0;
            ResultSet rs;
            rs = statement.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();
            rs = statement.executeQuery("SELECT column_name FROM all_tab_columns WHERE table_name='" + tableName + "'");
            while (rs.next()) {
                idColumnName = rs.getString(1);
                break;
            }
            rs = statement.executeQuery("SELECT * FROM " + tableName
                    + " WHERE " + idColumnName + "= " + ID);
            while (rs.next()) {
                strArr = new String[colCount];
                for (int j = 1; j <= colCount; j++) {
                    strArr[j - 1] = rs.getString(j);
                }
            }
            DataBaseItem dbiContent = new DataBaseItem();
            dbiContent.setItemValues(strArr, strArr.length);
            rs.close();
            statement.close();
            conn.close();
            return dbiContent;
        } catch (SQLException e) {
            System.err.println("SQL error : " + e.getMessage());
        }
        return null;
    }

    public int checkCompanyExistence(String companyName) {
        String cID = null;
        int companyID;
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("SELECT * FROM COMPANIES WHERE COMPANY_NAME = '"
                    + companyName + "'");
            while (rs.next()) {
                cID = rs.getString(1);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL error : " + e.getMessage());
        }
        if (cID != null) {
            companyID = Integer.parseInt(cID);
            return companyID;
        } else {
            return -1;
        }
    }

    public void addNewEmptyCompany(String companyName) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            ResultSet rs;
            rs = statement.executeQuery("INSERT INTO COMPANIES(COMPANY_NAME) VALUES( '" + companyName + "')");
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL error : " + e.getMessage());
        }
    }

    public void deleteEntryFromTableByID(String id, String tableName) {
        try {
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            String idColumnName = "";
            ResultSet rs;
            rs = statement.executeQuery("SELECT column_name FROM all_tab_columns WHERE table_name='" + tableName + "'");
            while (rs.next()) {
                idColumnName = rs.getString(1);
                break;
            }
            rs = statement.executeQuery("DELETE FROM " + tableName + " WHERE " + idColumnName + "=" + id);
            System.out.println("Deleted " + id + " from " + tableName);
            rs.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("SQL error : " + e.getMessage());
        }
    }

    /* FOR ONLY ONE RESULT (LAST ENTRY)
    public DataBaseItem searchInTable(String tableName, String inputData){
          boolean flag = false;
          DataBaseItem dbiContent = new DataBaseItem();
           try{  
                        int rowCount = 0;
                        Connection conn = openSQLConnection();
                        Statement statement = conn.createStatement();
                        String nameColumn = "";
                        int colCount = 0;
                        ResultSet rs;  
                        rs = statement.executeQuery("SELECT * FROM " + tableName);
                        ResultSetMetaData rsmd = rs.getMetaData();
                        colCount=rsmd.getColumnCount();
                         rs = statement.executeQuery("SELECT column_name FROM all_tab_columns WHERE table_name='"+tableName+"'");
                        while (rs.next()) {   
                            nameColumn=rs.getString(1);
                            rowCount++;
                            System.out.println("NAME ROW "+nameColumn);
                            if(rowCount==2){
                                break;
                            }
                        }
                        rs = statement.executeQuery("SELECT * FROM "+tableName+" WHERE "+nameColumn+" LIKE '"+inputData+"%'"); 
                        while (rs.next()) {   
                            strArr=new String[colCount];
                            for(int j=1;j<=colCount;j++){
                                    strArr[j-1]=rs.getString(j); 
                                    System.out.println("Added "+rs.getString(j));
                            }
                            flag=true;                            
                        }                        
                        dbiContent.setItemValues(strArr, strArr.length);
                        rs.close();
                        statement.close();
                        conn.close();
                        return dbiContent;
                          } catch(SQLException e){
                        System.err.println("SQL error : "+e.getMessage());
                }    
           return null;
      }*/
    
    public DataBaseItem[] searchInTable(String tableName, String inputData) {
        try {
            int i = 0;
            int rowCount = 0;
            int colCount = 0;
            Connection conn = openSQLConnection();
            Statement statement = conn.createStatement();
            String nameColumn = "";
            ResultSet rs;
            rs = statement.executeQuery("alter session  set NLS_DATE_FORMAT='DD.MM.YYYY'");
            rs = statement.executeQuery("SELECT * FROM " + tableName);
            ResultSetMetaData rsmd = rs.getMetaData();
            colCount = rsmd.getColumnCount();
            rs = statement.executeQuery("SELECT column_name FROM all_tab_columns WHERE table_name='" + tableName + "'");
            while (rs.next()) {
                nameColumn = rs.getString(1);
                rowCount++;
                System.out.println("NAME ROW " + nameColumn);
                if (rowCount == 2) {
                    break;
                }
            }
            rs = statement.executeQuery("SELECT COUNT(*) FROM " + tableName + " WHERE upper(" + nameColumn + ") LIKE upper('" + inputData + "%')");
            while (rs.next()) {
                rowCount = rs.getInt(1);
            }
            dbi = new DataBaseItem[rowCount];
            rs = statement.executeQuery("SELECT * FROM " + tableName + " WHERE upper(" + nameColumn + ") LIKE upper('" + inputData + "%')");
            while (rs.next()) {
                strArr = new String[colCount];
                for (int j = 1; j <= colCount; j++) {
                    strArr[j - 1] = rs.getString(j);
                }
                DataBaseItem dbiContent = new DataBaseItem();
                dbiContent.setItemValues(strArr, strArr.length);
                dbi[i] = dbiContent;
                i++;
            }

            rs.close();
            statement.close();
            conn.close();
            return dbi;
        } catch (SQLException e) {
            System.err.println("SQL error : " + e.getMessage());
        }
        return null;
    }

    private Connection openSQLConnection() throws SQLException {
        OracleDataSource ods = new OracleDataSource();
        ods.setURL("jdbc:oracle:thin:superadmin/Genshiken_1@localhost:1521:XE");
        Connection conn = ods.getConnection();
        return conn;
    }

}
