<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="css/bootstrap.css">        
        <link rel="stylesheet" href="css/style.css">

    </head>
    <body>
        <header>
            <div class="container">
                <a href="\" class="logo">WebApp</a>
                <a href="Learnvlet" class="click">CLICK ON ME AND I TELL YOU SOMETHING</a>
             </div>
        </header>
        <div class="main">
                <div class="container">
                    <div class="menu">
                        <nav>                        
                                <ul>
									  <li class="inactive"></li>
                                      <li class="inactive"></li>
                                      <li><a href="index.html"><span>Главная<span/></a></li>
                                      <li class="active"><a href="games.jsp" class="active">Каталог игр</a></li>
                                      <li><a href="companies.jsp">Компании</a></li>
                                      <li><a href="devs.jsp">Разработчики</a> </li>   
									  <li class="inactive"></li>
                                      <li class="inactive"></li>   
                                      <li class="inactive"></li>  
                                      <li class="inactive"></li>
                                      <li class="inactive"></li>
                                      <li class="inactive"></li>
                                      <li class="inactive"></li>
                                      <li class="inactive"></li>
                                      <li class="inactive"></li>
                                </ul>                       
                        </nav>
                    </div>                      
                    <div class="content">
                          <table>                  
                            
                             <tr><th>Games</th></tr>
                            <%@ page import ="jcode.*" %>
                            <%
                                String pageTableName = "GAMES";
                                DataBaseActivitiesHandler DBAH = new DataBaseActivitiesHandler();
                                DataBaseItem dbi = new DataBaseItem(DBAH, pageTableName);
                               %>
                               <%for(int i =0;i<dbi.getDBIArray().length;i++){
                                   %><tr><% for(int j=0;j<dbi.getDBIArray()[i].getItemValues().length;j++){%> 
                                        <td><%if(j==1){
                                            %><a href="itemview.jsp?id=<%out.print(dbi.getDBIArray()[i].getItemValues()[j-1]);%>&tableName=<%out.print(pageTableName);%>"><%out.println(dbi.getDBIArray()[i].getItemValues()[j]);%></a><%}
                                                else if(j==3){
                                                    out.println(DBAH.getItemByID(dbi.getDBIArray()[i].getItemValues()[j], "COMPANIES").getItemValues()[1]);
                                                }else   {
                                                    out.println(dbi.getDBIArray()[i].getItemValues()[j]);
                                        }%></td>
                              <%                                   
                               }}%></tr>
                        </table> 
                    </div>
                </div>
        </div>
 
        
    </body>
</html>
