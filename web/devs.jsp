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
                                      <li><a href="catalog.html">Каталог игр</a></li>
                                      <li><a href="stores.html">Магазины</a></li>
                                      <li class="active"><a href="devs.html" class="active">Разработчики</a> </li>                            
                                </ul>                       
                        </nav>
                    </div>  
                    <div class="content">
                        <table>
                            <tr><th>ID</th><th>Date</th></tr>
                            <%@ page import ="jcode.*" %>
                            <%             
                              JDBC kek = new JDBC();
                              kek.simpleSQL();
                               %>
                               <%for(int i =0;i<kek.lolArray().length;i++){
                                   %><tr><td><%out.println(kek.lolArray()[i]);%></td>                     
                               <td><%out.println(kek.lolArray()[i+kek.lolArray().length/2]);%></td><%                                   
                               }%></tr>
                        </table>
                    </div>
                </div>
        </div>
        
    </body>
</html>
