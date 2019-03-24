<%-- 
    Document   : firstjsp
    Created on : 09.03.2019, 16:34:30
    Author     : Nikita
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                                      <li><a href="games.jsp">Каталог игр</a></li>
                                      <li><a href="companies.jsp">Компании</a></li>
                                      <li class="active"><a href="devs.jsp" class="active">Разработчики</a> </li> 
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
                            
                             <tr><th>Developers</th></tr>
                            <%@ page import ="jcode.*" %>
                            <%
                                String pageTableName = "DEVELOPERS";
                                DataBaseActivitiesHandler DBAH = new DataBaseActivitiesHandler();
                                DataBaseItem dbi = new DataBaseItem(DBAH, pageTableName);
                               %>
                               <%for(int i =0;i<dbi.getDBIArray().length;i++){
                                   %><tr><% for(int j=0;j<dbi.getDBIArray()[i].getItemValues().length;j++){%> 
                                        <td><%if(j==1){
                                            %><a href="itemview.jsp?id=<%out.print(dbi.getDBIArray()[i].getItemValues()[j-1]);%>&tableName=<%out.print(pageTableName);%>"><%out.println(dbi.getDBIArray()[i].getItemValues()[j]);%></a><%}
                                        else{
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
