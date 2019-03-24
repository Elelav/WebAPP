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
                                      <li><a href="index.html"><span>Главная<span/></a></li>
                                      <li><a href="games.jsp">Каталог игр</a></li>
                                      <li><a href="companies.jsp">Магазины</a></li>
                                      <li><a href="devs.jsp">Разработчики</a> </li>
                                      
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
                            <%@ page import ="jcode.*" %>
                            <%
                                DataBaseActivitiesHandler DBAH = new DataBaseActivitiesHandler();
                                DataBaseItem dbi = new DataBaseItem();
                                String id = request.getParameter("id");
                                String tableName = request.getParameter("tableName");
                                dbi=DBAH.getItemByID(id, tableName);                                
                                for(int i=1;i<dbi.getItemValues().length;i++){
                                    %><h2><% out.println(dbi.getItemValues()[i]);
                                            } %></h2>
                               
                        </table>
                    </div>
                </div>
        </div>
        
    </body>
</html>
