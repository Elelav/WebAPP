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
                    <div class="search-bar">
                        <form action="searchresult.jsp?tableName=GAMES" method="post">
                            <table>
                                <th><div class="bar"><input type="text" name="search"></div><th>
                                <th><div class="search-button"><input type="submit"  value="Поиск"></div></th>
                            </table>
                        </form>
                    </div>
                    <table>      
                        <form action="Learnvlet?request=deletegame" method="post">                                               
                            <tr><th>Game ID</th>
                                <th>Name</th>
                                <th>Genre</th>
                                <th>Comany</th>
                                <th>Platform</th>
                                <th>PEGI</th>
                                <th>Language</th>
                                <th>Players in multiplayer</th>
                                <th>Players in co-op</th>
                                <th>Release date</th>
                                <th>Price ($)</th></tr>
                                    <%@ page import ="jcode.*" %>
                                    <%
                                        String pageTableName = "GAMES";
                                        DataBaseActivitiesHandler DBAH = new DataBaseActivitiesHandler();
                                        DataBaseItem dbi = new DataBaseItem(DBAH, pageTableName);
                                        DataBaseItem[] recievedDBI = dbi.getDBIArray().clone();
                                    %>
                                    <%for (int i = 0; i < dbi.getDBIArray().length; i++) {
                                    %><tr><% for (int j = 0; j < recievedDBI[i].getItemValues().length; j++) {%> 
                                <td>
                                    <%if (j == 1) {
                                    %>
                                    <a href="itemview.jsp?id=<%out.print(recievedDBI[i].getItemValues()[j - 1]);%>&tableName=<%out.print(pageTableName);%>"><%out.println(recievedDBI[i].getItemValues()[j]);%></a>
                                    <%} else if (j == 3) {
                                            out.println(DBAH.getItemByID(recievedDBI[i].getItemValues()[j], "COMPANIES").getItemValues()[1]);
                                        } else {
                                            out.println(recievedDBI[i].getItemValues()[j]);
                                        }%>
                                </td><%}%>
                                <td><input type="checkbox" name="delete<%out.print(i);%>" value="<%out.print(recievedDBI[i].getItemValues()[0]);%>"></td><%}%></tr>
                    </table>
                    <div class='buttons'>
                        <table>
                            <th><div class="deleteSubmit"><input type="submit" value="Удалить выбранное"></div></th>                     
                            </form>
                            <th><div class="addGameSubmit"><a href='createentry.jsp?tableName=GAMES'><input type="submit" value="Добавить новую игру"></a></div><th>
                        </table>
                    </div>
                </div>
            </div>
        </div>


    </body>
</html>
