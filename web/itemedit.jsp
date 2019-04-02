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
                            dbi = DBAH.getItemByID(id, tableName);
                            switch (tableName) {
                                case ("GAMES"):
                        %>
                        <form action="Learnvlet?request=editGame&id=<%out.print(id);%>" method="post">
                            <div class="gameName"><p>Название игры: <input name="gameName" type="text" value='<%out.println(dbi.getItemValues()[1]);%>'><br></p></div>
                            <div class="gameGenre"><p>Жанр: <input name="gameGenre" type="text" value='<%out.println(dbi.getItemValues()[2]);%>'><br></p> </div>
                            <div class="companyName"><p>Компания разработчик: <input name="companyName" type="text" value='<%out.println(DBAH.getItemByID(dbi.getItemValues()[3], "COMPANIES").getItemValues()[1]);%>'> <br></p></div>
                            <div class="platform"><p>Платформа/ы: <input name="platform" type="text" value='<%out.println(dbi.getItemValues()[4]);%>'>   <br></p></div>
                            <div class="pegi"><p>Возрастные ограничения: <input name="pegi" pattern="\d+" value='<%out.println(dbi.getItemValues()[5]);%>'>   <br></p></div>
                            <div class="mainLanguage"><p>Язык: <input name="mainLanguage" type="text" value='<%out.println(dbi.getItemValues()[6]);%>'>   <br></p></div>
                            <div class="multiplayer"><p>Количество игроков в мультиплеере: <input name="multiplayer" pattern="^[ 0-9]+$" value='<%out.println(dbi.getItemValues()[7]);%>'>  <br></p></div>
                            <div class="coop"><p>Количество игроков в кооперативе: <input name="coop" pattern="^[ 0-9]+$" value='<%out.println(dbi.getItemValues()[8]);%>'> <br></p></div>
                            <div class="releaseDate"><p>Дата релиза: <input name="releaseDate" pattern="\d\d\.\d\d\.\d\d\d\d" value='<%out.println(dbi.getItemValues()[9]);%>'> <br></p></div>
                            <div class="price"><p>Цена: <input name="price" pattern="\d+(\.\d{1,2})?" value='<%out.println(dbi.getItemValues()[10]);%>'> <br></p></div>
                            <div class="submitButton"><input type="submit"></div>
                        </form>
                        <%
                                break;
                            case ("COMPANIES"):
                        %> 
                        <form action="Learnvlet?request=editCompany&id=<%out.print(id);%>" method="post">
                            <div class="cCompanyName"><p>Название компании: <input name="companyName" type="text" value='<%out.println(dbi.getItemValues()[1]);%>'><br></p></div>
                            <div class="homePage"><p>Домашняя страница: <input name="homePage" type="text" value='<%out.println(dbi.getItemValues()[2]);%>'><br></p> </div>
                            <div class="creationDate"><p>Дата создания:  <input name="creationDate" pattern="\d\d\.\d\d\.\d\d\d\d" value='<%out.println(dbi.getItemValues()[3]);%>'> <br></p></div>
                            <div class="country"><p>Страна:  <input name="platform" type="country" value='<%out.println(dbi.getItemValues()[4]);%>'>   <br></p></div>                                                                                
                            <div class="submitButton"><input type="submit"></div>
                        </form>
                        <%
                                break;
                            case ("DEVELOPERS"):
                        %>
                        <form action="Learnvlet?request=editDeveloper&id=<%out.print(id);%>" method="post">
                            <div class="developerName"><p>Имя разработчика: <input name="developerName" type="text" value='<%out.println(dbi.getItemValues()[1]);%>'><br></p></div>
                            <div class="employmentDate"><p>Дата устройства: <input name="employmentDate" pattern="\d\d\.\d\d\.\d\d\d\d" value='<%out.println(dbi.getItemValues()[2]);%>'><br></p> </div>
                            <div class="address"><p>Адрес: <input name="address" type="text" value='<%out.println(dbi.getItemValues()[3]);%>'> <br></p></div>
                            <div class="companyName"><p>Компания: <input name="companyName" type="text" value='<% out.println(DBAH.getItemByID(dbi.getItemValues()[4], "COMPANIES").getItemValues()[1]);%>'>   <br></p></div>                                            
                            <div class="submitButton"><input type="submit"></div>
                        </form>
                        <%
                                                    break;
                                            }%>
                    </table> 
                </div>
            </div>
        </div>

    </body>
</html>
