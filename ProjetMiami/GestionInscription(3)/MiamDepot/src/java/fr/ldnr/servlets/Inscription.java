package fr.ldnr.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Herbert
 */
@WebServlet(name = "Inscription", urlPatterns = {"/inscription"})
public class Inscription extends HttpServlet {

    /* Des constantes */
    public static final String VUE = "/WEB-INF/inscription.jsp";

    /**
     *
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Affichage de la page d'inscription */
        this.getServletContext()
                .getRequestDispatcher(VUE)
                .forward(request, response);
    }

    /**
     *
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     *
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        throw new ServletException("doPost() not implemented");
    }

    /**
     *
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet d'inscription";
    }
}
