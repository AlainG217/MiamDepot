/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
* comm
 */
package fr.ldnr.servlets;

import MiamProto.metier.ProductV;
import MiamProto.metier.SalesOrderPilot;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "AddBasketProduct", urlPatterns = {"/AddBasketProduct"})
public class AddBasketProduct extends HttpServlet {


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
        
        String idParam = request.getParameter("id") ;
        int id = Integer.parseInt(idParam);
        String typeParam = request.getParameter("type") ;
        int type = Integer.parseInt(typeParam);
        String sizeParam = request.getParameter("size") ;
        int size = Integer.parseInt(sizeParam);

            
        
        // Récupération de la session et des objets de la session
        HttpSession session = request.getSession();

        SalesOrderPilot pilot = (SalesOrderPilot) session.getAttribute("panierPilot");
        if (pilot == null) {
            pilot = new SalesOrderPilot();
        }

        List<ProductV> foods =  (List<ProductV>) session.getAttribute("foods");
        List<ProductV> drinks =  (List<ProductV>) session.getAttribute("drinks");
        
        // Traitement des actions
        // Food
        if (type == 0) {
            foods = pilot.addLineToBasket(foods, id, size);
            session.setAttribute("foods", foods);
        }

        // Food
        if (type == 1) {
            drinks = pilot.addLineToBasket(drinks, id, size);
            session.setAttribute("drinks", drinks);
        }

        session.setAttribute("panierPilot", pilot);

        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/Home.jsp")
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
