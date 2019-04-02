package jcode;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.sql.*;

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
        try {
            processRequest(request, response);
        } catch (SQLException e) {
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
        switch (recievedRequest) {
            case ("addNewGame"):
                if (DBAH.checkCompanyExistence(request.getParameter("companyName")) != -1) {
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
                } else {
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
                response.sendRedirect(request.getContextPath() + "/games.jsp");
                break;

            case ("addCompany"):
                DBAH.addNewCompanyToTable(request.getParameter("companyName"),
                        request.getParameter("homePage"),
                        request.getParameter("creationDate"),
                        request.getParameter("country"));
                response.sendRedirect(request.getContextPath() + "/companies.jsp");
                break;

            case ("addDeveloper"):
                if (DBAH.checkCompanyExistence(request.getParameter("companyName")) != -1) {
                    newGameCompanyID = DBAH.checkCompanyExistence(request.getParameter("companyName"));
                    DBAH.addNewDeveloperToTable(request.getParameter("developerName"),
                            request.getParameter("employmentDate"),
                            request.getParameter("address"),
                            newGameCompanyID);
                } else {
                    DBAH.addNewEmptyCompany(request.getParameter("companyName"));
                    newGameCompanyID = DBAH.checkCompanyExistence(request.getParameter("companyName"));
                    DBAH.addNewDeveloperToTable(request.getParameter("developerName"),
                            request.getParameter("employmentDate"),
                            request.getParameter("address"),
                            newGameCompanyID);
                }
                response.sendRedirect(request.getContextPath() + "/devs.jsp");
                break;
            case ("deletedeveloper"):
                for (String s : getParameterList(request).subList(1, getParameterList(request).size())) {
                    DBAH.deleteEntryFromTableByID(request.getParameter(s), "DEVELOPERS");
                }
                response.sendRedirect(request.getContextPath() + "/devs.jsp");
                break;
            case ("deletegame"):
                for (String s : getParameterList(request).subList(1, getParameterList(request).size())) {
                    DBAH.deleteEntryFromTableByID(request.getParameter(s), "GAMES");
                }
                response.sendRedirect(request.getContextPath() + "/games.jsp");
                break;
            case ("deletecompany"):
                for (String s : getParameterList(request).subList(1, getParameterList(request).size())) {
                    DBAH.deleteEntryFromTableByID(request.getParameter(s), "COMPANIES");
                }
                response.sendRedirect(request.getContextPath() + "/companies.jsp");
                break;
            case ("editGame"):
                if (DBAH.checkCompanyExistence(request.getParameter("companyName")) != -1) {
                    newGameCompanyID = DBAH.checkCompanyExistence(request.getParameter("companyName"));
                    DBAH.setNewValuesToGame(Integer.parseInt(request.getParameter("id")),
                            request.getParameter("gameName"),
                            request.getParameter("gameGenre"),
                            newGameCompanyID,
                            request.getParameter("platform"),
                            Integer.parseInt(request.getParameter("pegi")),
                            request.getParameter("mainLanguage"),
                            Integer.parseInt(request.getParameter("multiplayer")),
                            Integer.parseInt(request.getParameter("coop")),
                            request.getParameter("releaseDate"),
                            Double.parseDouble(request.getParameter("price")));
                } else {
                    DBAH.addNewEmptyCompany(request.getParameter("companyName"));
                    newGameCompanyID = DBAH.checkCompanyExistence(request.getParameter("companyName"));
                    DBAH.setNewValuesToGame(Integer.parseInt(request.getParameter("id")),
                            request.getParameter("gameName"),
                            request.getParameter("gameGenre"),
                            newGameCompanyID,
                            request.getParameter("platform"),
                            Integer.parseInt(request.getParameter("pegi")),
                            request.getParameter("mainLanguage"),
                            Integer.parseInt(request.getParameter("multiplayer")),
                            Integer.parseInt(request.getParameter("coop")),
                            request.getParameter("releaseDate"),
                            Double.parseDouble(request.getParameter("price")));
                }
                response.sendRedirect(request.getContextPath() + "/games.jsp");
                break;
            case ("editCompany"):
                DBAH.setNewValuesToCompany(Integer.parseInt(request.getParameter("id")),
                        request.getParameter("companyName"),
                        request.getParameter("homePage"),
                        request.getParameter("creationDate"),
                        request.getParameter("country"));
                response.sendRedirect(request.getContextPath() + "/companies.jsp");
                break;
            case ("editDeveloper"):
                if (DBAH.checkCompanyExistence(request.getParameter("companyName")) != -1) {
                    newGameCompanyID = DBAH.checkCompanyExistence(request.getParameter("companyName"));
                    DBAH.setNewValuesToDeveloper(Integer.parseInt(request.getParameter("id")),
                            request.getParameter("developerName"),
                            request.getParameter("employmentDate"),
                            request.getParameter("address"),
                            newGameCompanyID);
                } else {
                    DBAH.addNewEmptyCompany(request.getParameter("companyName"));
                    newGameCompanyID = DBAH.checkCompanyExistence(request.getParameter("companyName"));
                    DBAH.setNewValuesToDeveloper(Integer.parseInt(request.getParameter("id")),
                            request.getParameter("developerName"),
                            request.getParameter("employmentDate"),
                            request.getParameter("address"),
                            newGameCompanyID);
                }
                response.sendRedirect(request.getContextPath() + "/devs.jsp");
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

    private ArrayList<String> getParameterList(HttpServletRequest request) {
        ArrayList<String> requestParameters = new ArrayList<>();
        Enumeration<String> enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            String parameterName = enumeration.nextElement();
            requestParameters.add(parameterName);
        }
        return requestParameters;
    }

}
