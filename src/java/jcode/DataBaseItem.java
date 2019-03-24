/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcode;

import java.sql.*;

/**
 *
 * @author Nikita
 */
public class DataBaseItem {    
    
        private DataBaseItem[] dbiArray;
        private String[] stringArray;
    
    public DataBaseItem(){
    }
    
    public DataBaseItem(String[] strArr){
         for(int i=0;i<strArr.length;i++){
             this.stringArray[i]=strArr[i];
         }
    }
    
    public DataBaseItem(DataBaseActivitiesHandler DBAH, String tableName){
        
                try{
                        DataBaseItem[] recievedDBI = DBAH.getDBI(tableName);
                        this.dbiArray = new DataBaseItem[recievedDBI.length];
                        for(int i=0;i<recievedDBI.length;i++){
                            dbiArray[i]=recievedDBI[i];
                        }
                } catch (SQLException e){
                    System.err.println("SQL Error: " + e.getMessage());
                }
              
    }
    

    
    public String[] getItemValues(){
        return stringArray;
    }
    
    public DataBaseItem[] getDBIArray(){
        return dbiArray;
    }
    
    public void setItemValues(String[] values, int valuesQuantity){
        stringArray=new String[valuesQuantity];
        for(int i=0;i<valuesQuantity;i++){
            stringArray[i]=values[i];
        }
    }
    
}
