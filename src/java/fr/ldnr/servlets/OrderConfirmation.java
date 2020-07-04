/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.servlets;

import MiamProto.beans.Address;
import MiamProto.metier.SalesOrderPilot;
import MiamProto.metier.SalesOrderV;
import java.io.IOException;
import java.time.LocalDate;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "OrderConfirmation", urlPatterns = {"/OrderConfirmation"})
public class OrderConfirmation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/orderConfirmation.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         // Récupération de la session et des objets de la session
        HttpSession session = request.getSession();

        SalesOrderPilot pilot = (SalesOrderPilot) session.getAttribute("panierPilot");
        SalesOrderV view = (SalesOrderV) session.getAttribute("panier");
        
        String nom = request.getParameter("nomProduit");
        String description = request.getParameter("detail");

        view.setDeliveryMode(Integer.parseInt(request.getParameter("deliveryMode")));
        view.setDeliveryTime(LocalDate.now());
        view.setAddress(
            new Address(0, 
                    request.getParameter("firstName"), 
                    request.getParameter("lastName"), 
                    request.getParameter("line1"), 
                    request.getParameter("line2"), 
                    request.getParameter("postalCode"), 
                    request.getParameter("city"), 
                    request.getParameter("phone"), 
                    request.getParameter("email")));
        
        pilot.setOrderView(view);
        pilot.setOrderState(1); // A ajouter
        pilot.setOrderStatus(2); // payée

        pilot.save();

        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/Home.jsp")
                .forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
