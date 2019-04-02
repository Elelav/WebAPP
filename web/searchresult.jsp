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
                        <%@ page import ="jcode.*" %>
                        <%
                            DataBaseActivitiesHandler DBAH = new DataBaseActivitiesHandler();
                            String inputData = request.getParameter("search");
                            String tableName = request.getParameter("tableName");
                            DataBaseItem[] dbi = DBAH.searchInTable(tableName, inputData);
                            switch (tableName) {
                                case ("GAMES"):
                        %><h1>Search results for <%out.print(inputData);%>:</h1><%
                            for (int i = 0; i < dbi.length; i++) {
                        %><h2>Game ID: <% out.println(dbi[i].getItemValues()[0]);%></h2> <%
                        %><h2>Game name: <% out.println(dbi[i].getItemValues()[1]);%></h2> <%
                        %><h2>Genre: <% out.println(dbi[i].getItemValues()[2]);%></h2> <%
                        %><h2>Company name: <% out.println(DBAH.getItemByID(dbi[i].getItemValues()[3], "COMPANIES").getItemValues()[1]);%></h2> <%
                        %><h2>Platform: <% out.println(dbi[i].getItemValues()[4]);%></h2> <%
                        %><h2>PEGI:<% out.println(dbi[i].getItemValues()[5]);%></h2> <%
                        %><h2>Language: <% out.println(dbi[i].getItemValues()[6]);%></h2> <%
                        %><h2>Players in multiplayer: <% out.println(dbi[i].getItemValues()[7]);%></h2> <%
                        %><h2>Players in co-op: <% out.println(dbi[i].getItemValues()[8]);%></h2> <%
                        %><h2>Release date: <% out.println(dbi[i].getItemValues()[9]);%></h2> <%
                        %><h2>Price: <% out.println(dbi[i].getItemValues()[10]);%></h2> 
                        <div class="editSubmit"><a href="itemedit.jsp?id=<%out.print(dbi[i].getItemValues()[0]);%>&tableName=<%out.print(tableName);%>"><input type='submit' value='Редактировать'></a></div>
                                <%
                                        }
                                        break;
                                    case ("COMPANIES"):
                                %><h1>Search results for <%out.print(inputData);%>:</h1><%
                                    for (int i = 0; i < dbi.length; i++) {
                        %><h2>Company ID: <% out.println(dbi[i].getItemValues()[0]);%></h2> <%
                        %><h2>Company name: <% out.println(dbi[i].getItemValues()[1]);%></h2> <%
                        %><h2>Home page: <% out.println(dbi[i].getItemValues()[2]);%></h2> <%
                        %><h2>Creation date: <% out.println(dbi[i].getItemValues()[3]);%></h2> <%
                        %><h2>Country: <% out.println(dbi[i].getItemValues()[4]);%></h2> 
                        <div class="editSubmit">
                            <a href="itemedit.jsp?id=<%out.println(dbi[i].getItemValues()[0]);%>&tableName=<%out.println(tableName);%>"><input type='submit' value='Редактировать'></a>
                        </div>
                        <%
                                }
                                break;
                            case ("DEVELOPERS"):
                        %><h1>Search results for <%out.print(inputData);%>:</h1><%
                            for (int i = 0; i < dbi.length; i++) {
                        %><h2>Developer ID: <% out.println(dbi[i].getItemValues()[0]);%></h2> <%
                        %><h2>Name:  <% out.println(dbi[i].getItemValues()[1]);%></h2> <%
                        %><h2>Employment date: <% out.println(dbi[i].getItemValues()[2]);%></h2> <%
                        %><h2>Address:  <% out.println(dbi[i].getItemValues()[3]);%></h2> <%
                        %><h2>Company <% out.println(DBAH.getItemByID(dbi[i].getItemValues()[4], "COMPANIES").getItemValues()[1]);%></h2>
                        <div class="editSubmit">
                            <a href="itemedit.jsp?id=<%out.println(dbi[i].getItemValues()[0]);%>&tableName=<%out.println(tableName);%>"><input type='submit' value='Редактировать'></a>
                        </div>
                        <%
                                            }
                                            break;
                                    }%>
                    </table> 

                </div>
            </div>
        </div>

    </body>
</html>
