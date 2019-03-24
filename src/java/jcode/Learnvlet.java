package jcode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import jcode.DataBaseActivitiesHandler;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

import java.sql.*;
import oracle.jdbc.*;
import oracle.jdbc.pool.OracleDataSource;


/**
 *
 * @author Nikita
 */
@WebServlet(urlPatterns = {"/Learnvlet"})
public class Learnvlet extends HttpServlet {
    DataBaseActivitiesHandler DBAH = new DataBaseActivitiesHandler();
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {       
        /*response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            // TODO output your page here. You may use following sample code.            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Learnvlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Learnvlet at " + request.getContextPath() + "</h1>");
            for(DataBaseItem dbi: recieveTableContent("GAMES")){
                for(String s: dbi.getItemValues()){
                    out.println("<h2>"+s+"</h2>"); 
                }
            }
            out.println("</body>");
            out.println("</html>");
           
        }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        processRequest(request, response);
        } catch(SQLException e){            
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {       
        String recievedRequest = request.getParameter("request");
        System.out.println(recievedRequest);
        int newGameCompanyID;
        switch (recievedRequest){
                case("addNewGame"):
                   try{
                        if(DBAH.checkCompanyExistence(request.getParameter("companyName"))!=-1){
                            newGameCompanyID = DBAH.checkCompanyExistence(request.getParameter("companyName"));
                            DBAH.addNewGameToTable(request.getParameter("gameName"),
                                    request.getParameter("gameGenre"),
                                    newGameCompanyID,
                                    request.getParameter("platform"),
                                    Integer.parseInt(request.getParameter("pegi")),
                                    request.getParameter("mainLanguage"),
                                    Integer.parseInt(request.getParameter("multiplayer")),
                                    Integer.parseInt(request.getParameter("coop")),
                                    request.getParameter("releaseDate"),
                                    Double.parseDouble(request.getParameter("price"))
                                    );
                        } else{
                            DBAH.addNewEmptyCompany(request.getParameter("companyName"));
                            newGameCompanyID = DBAH.checkCompanyExistence(request.getParameter("companyName"));
                            DBAH.addNewGameToTable(request.getParameter("gameName"),
                                    request.getParameter("gameGenre"),
                                    newGameCompanyID,
                                    request.getParameter("platform"),
                                    Integer.parseInt(request.getParameter("pegi")),
                                    request.getParameter("mainLanguage"),
                                    Integer.parseInt(request.getParameter("multiplayer")),
                                    Integer.parseInt(request.getParameter("coop")),
                                    request.getParameter("releaseDate"),
                                    Double.parseDouble(request.getParameter("price"))
                                    );
                        }
                    } catch(SQLException e){
                        System.err.println("SQL error : "+e.getMessage());
                    }
                    
                    
                break;

            }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    private DataBaseItem[] recieveTableContent(String tableName) throws SQLException{             
            DataBaseItem[] recievedDBI = DBAH.getDBI(tableName);
            DataBaseItem[] dbi= new DataBaseItem[recievedDBI.length];
            for(int i=0;i<recievedDBI.length;i++){
                dbi[i]=recievedDBI[i];
            }
            //DBAH.addNewGameToTable("The Crew", "Racing", 7, "Windows", 12, "English", 64, 64, "22.12.2017", 9.99);
            //DBAH.addNewDeveloperToTable("Mark Smith", "22.12.2017", "Moscow", 7);
            //DBAH.addNewCompanyToTable("Epic Games", "epic-games.com", "22.12.1995", "USA");
            //DBAH.setNewValuesToCompany(25, "Epic Games",  "epic-games.com", "10.12.1995", "USSSSA");
            DBAH.setNewValuesToDeveloper(29, "Mark Sledge", "22.12.2017", "Moscow", 7);
            //DBAH.setNewValuesToGame(9,"The Crew 2", "Racing", 7, "Windows", 12, "English", 64, 64, "22.12.2017", 9.99);
            return dbi;
    }

 }
    

