/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.servlets;

import MiamProto.DAO.ProductDAO;
import MiamProto.beans.Product;
import MiamProto.beans.ProductSize;
import MiamProto.metier.ProductPilot;
import MiamProto.metier.ProductV;
import MiamProto.metier.SalesOrderPilot;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AjouteProduit", urlPatterns = {"/AjouteProduit"})
public class AjouteProduit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom = request.getParameter("nomProduit");
            String description = request.getParameter("detail");
//            String imagerep = request.getParameter("imageRep");
//            int idcompany = Integer.parseInt(request.getParameter("idCompany"));
//            double price = Double.valueOf("prix");
            double price = Double.valueOf(request.getParameter("prixMoyen"));
            String size = request.getParameter("size");

            ProductSize e = new ProductSize();
            e.setPrice(price);
            e.setSize(size);

            List<ProductSize> sizes = new ArrayList<>();
            sizes.add(e);
            ProductPilot obj = new ProductPilot();
            obj.init(nom, description, 0, sizes);
            obj.save();
            System.out.println("ajouter dans la base de donné ");

            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/gestionProduit.jsp")
                    .forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/gestionProduit.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String nom = request.getParameter("nomProduit");
        String description = request.getParameter("detail");
        int type = Integer.parseInt(request.getParameter("type"));
//            String imagerep = request.getParameter("imageRep");
//            int idcompany = Integer.parseInt(request.getParameter("idCompany"));
//            double price = Double.valueOf("prix");

        // Gestion des tailles et prix associés

        List<ProductSize> sizes = new ArrayList<>();
        String size = request.getParameter("sizeSmall");
        String priceParam = request.getParameter("priceSmall");
        double price = 0;
        if (!priceParam.equals("")) {
            price = Double.valueOf(request.getParameter("priceSmall"));
        }
        if (size != null)
            sizes.add(new ProductSize(0,
                    size,
                    price,
                    0
                    ));
    
        size = request.getParameter("sizeMedium");
        priceParam = request.getParameter("priceMedium");
        price = 0;
        if (!priceParam.equals("")) {
            price = Double.valueOf(request.getParameter("priceMedium"));
        }
        if (size != null)
            sizes.add(new ProductSize(0,
                    size,
                    price,
                    0
                    ));
        size = request.getParameter("sizeLarge");
        priceParam = request.getParameter("priceLarge");
        price = 0;
        if (!priceParam.equals("")) {
            price = Double.valueOf(request.getParameter("priceLarge"));
        }
        if (size != null)
            sizes.add(new ProductSize(0,
                    size,
                    price,
                    0
                    ));
            
            ProductPilot obj = new ProductPilot();
            obj.init(nom, description, type, sizes);
            obj.save();
            System.out.println("ajouter dans la base de donné ");
            
            // Reload session attributes with updated list
            HttpSession session = request.getSession();
 
            List<ProductV> foods = obj.getFood();
            List<ProductV> drinks = obj.getDrinks();
        
            session.setAttribute("foods", foods);
            session.setAttribute("drinks", drinks);


            this.getServletContext()
                    .getRequestDispatcher("/WEB-INF/managerProductList.jsp")
                    .forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
