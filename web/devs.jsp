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
                         <div class="search-bar">
                            <form action="searchresult.jsp?tableName=DEVELOPERS" method="post">
                                <table>
                                    <th><div class="bar"><input type="text" name="search"></div><th>
                                    <th><div class="search-button"><input type="submit"  value="Поиск"></div></th>
                                </table>
                            </form>
                        </div>
                        <table>                  
                            <form action="Learnvlet?request=deletedeveloper" method="post">
                             <tr><th>Developer number </th>
                             <th>Name</th>
                             <th>Employment date</th>
                             <th>Addres</th>
                             <th>Company</th></tr>
                            <%@ page import ="jcode.*" %>
                            <%
                                String pageTableName = "DEVELOPERS";
                                DataBaseActivitiesHandler DBAH = new DataBaseActivitiesHandler();
                                DataBaseItem dbi = new DataBaseItem(DBAH, pageTableName);
                                DataBaseItem[] recievedDBI = dbi.getDBIArray().clone();                                
                               %>
                               <%for(int i =0;i<recievedDBI.length;i++){
                                   %><tr><% for(int j=0;j<recievedDBI[i].getItemValues().length;j++){%> 
                                        <td><%
                                            if(j==1){
                                            %><a href="itemview.jsp?id=<%out.print(recievedDBI[i].getItemValues()[j-1]);%>&tableName=<%out.print(pageTableName);%>"><%out.println(recievedDBI[i].getItemValues()[j]);%></a><%}
                                            else if(j==4){
                                                    out.println(DBAH.getItemByID(recievedDBI[i].getItemValues()[j], "COMPANIES").getItemValues()[1]);
                                                 }
                                            else{
                                                    out.println(recievedDBI[i].getItemValues()[j]);
                                            }%></td><%}%>
                                        <td><input type="checkbox" name="delete<%out.print(i);%>" value="<%out.print(recievedDBI[i].getItemValues()[0]);%>"></td><%}%></tr>
                              </table>
                              <div class='buttons'>
                                    <table>
                                    <th><div class="deleteSubmit"><input type="submit" value="Удалить выбранное"></div></th>                     
                                   </form>
                                    <th><div class="addDeveloperSubmit"><a href='createentry.jsp?tableName=DEVELOPERS'><input type="submit" value="Добавить нового разработчика"></a></div><th>
                                    </table>
                               </div>
                    </div>
                </div>
        </div>
        
    </body>
</html>
