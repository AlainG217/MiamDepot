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
@WebServlet(name = "Basket", urlPatterns = {"/Basket"})
public class BasketServlet extends HttpServlet {


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
         // Récupération de la session et des objets de la session
        HttpSession session = request.getSession();

        SalesOrderPilot pilot = (SalesOrderPilot) session.getAttribute("panierPilot");
        
        // Pour tests
/*        ProductPilot productPilot = new ProductPilot();
        List<ProductV> views = productPilot.getAll();
        for (ProductV pview : views) {
            pview.setQty(1);
            pview.setMediumSelected(true);
            pview.setLargeSelected(true);
        }
        session.setAttribute("products", views);
*/        
        // Fin pour tests

        
        // Fill the basket with selected products
        
        pilot.showBasket();
        
        session.setAttribute("basket", pilot.getOrderView());
        
        // Envoi jsp
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/Basket.jsp")
                .forward(request, response);
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
