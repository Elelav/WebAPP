/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jcode;

/**
 *
 * @author Nikita
 */
public class DataBaseItem {    
    
    private String[] stringArray;
    
    public String[] getItemValues(){
        return stringArray;
    }
    
    public void setItemValues(String[] values, int valuesQuantity){
        stringArray=new String[valuesQuantity];
        for(int i=0;i<valuesQuantity;i++){
            stringArray[i]=values[i];
        }
    }
    
}
