<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Add new game</title>
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
                                      <li class="active"><a href="games.jsp">Каталог игр</a></li>
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
                    <div class="content"> <%String tableName = request.getParameter("tableName");
                        switch(tableName){
                            case("GAMES"):
                        %>
                        <form action="Learnvlet?request=addNewGame" method="post">
                            <div class="gameName"><p>Название игры: <input name="gameName" type="text"><br></p></div>
                            <div class="gameGenre"><p>Жанр: <input name="gameGenre" type="text"><br></p> </div>
                            <div class="companyName"><p>Компания разработчик: <input name="companyName" type="text"> <br></p></div>
                            <div class="platform"><p>Платформа/ы: <input name="platform" type="text">   <br></p></div>
                            <div class="pegi"><p>Возрастные ограничения: <input name="pegi" pattern="\d+">   <br></p></div>
                            <div class="mainLanguage"><p>Язык: <input name="mainLanguage" type="text">   <br></p></div>
                            <div class="multiplayer"><p>Количество игроков в мультиплеере: <input name="multiplayer" pattern="^[ 0-9]+$">  <br></p></div>
                            <div class="coop"><p>Количество игроков в кооперативе: <input name="coop" pattern="^[ 0-9]+$"> <br></p></div>
                            <div class="releaseDate"><p>Дата релиза: <input name="releaseDate" pattern="\d\d\.\d\d\.\d\d\d\d"> <br></p></div>
                            <div class="price"><p>Цена: <input name="price" pattern="\d+(\.\d{1,2})?"> <br></p></div>
                             <div class="submitButton"><input type="submit"></div>
                        </form>
                        <%
                            break;
                            case("COMPANIES"):
                            %>
                            <form action="Learnvlet?request=addCompany>" method="post">
                                            <div class="cCompanyName"><p>Название компании: <input name="companyName" type="text"><br></p></div>
                                            <div class="homePage"><p>Домашняя страница: <input name="homePage" type="text"><br></p> </div>
                                            <div class="creationDate"><p>Дата создания:  <input name="creationDate" pattern="\d\d\.\d\d\.\d\d\d\d"> <br></p></div>
                                            <div class="country"><p>Страна:  <input name="platform" type="country" value=>   <br></p></div>                                                                                
                                            <div class="submitButton"><input type="submit"></div>
                              </form>
                        <%
                            break;
                            case("DEVELOPERS"):                            
                        %>
                                <form action="Learnvlet?request=addDeveloper" method="post">
                                            <div class="developerName"><p>Имя разработчика: <input name="developerName" type="text"><br></p></div>
                                            <div class="employmentDate"><p>Дата устройства: <input name="employmentDate" pattern="\d\d\.\d\d\.\d\d\d\d"><br></p> </div>
                                            <div class="address"><p>Адрес: <input name="address" type="text" > <br></p></div>
                                            <div class="companyName"><p>Компания: <input name="companyName" type="text">   <br></p></div>                                            
                                             <div class="submitButton"><input type="submit"></div>
                                </form>
                        <%break;}%>
                               
                    </div>
                </div>
        </div>
 
        
    </body>
</html>
