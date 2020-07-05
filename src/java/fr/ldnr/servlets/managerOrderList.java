/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.servlets;

import MiamProto.metier.ProductPilot;
import MiamProto.metier.ProductV;
import MiamProto.metier.SalesOrderPilot;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author stagjava
 */
@WebServlet(name = "managerOrderList", urlPatterns = {"/manageOrderList"})
public class managerOrderList extends HttpServlet {

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
        // Récupération de la session et des objets de la session
        HttpSession session = request.getSession();

        SalesOrderPilot pilot = (SalesOrderPilot) session.getAttribute("panierPilot");
        
        if (pilot == null) {
            pilot = new SalesOrderPilot();
        }

        double ca = pilot.showOrderList();

        session.setAttribute("orders", pilot.getOrders());
        session.setAttribute("ca", ca);

        // Envoi jsp
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/manageOrderList.jsp")
                .forward(request, response);

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

}
