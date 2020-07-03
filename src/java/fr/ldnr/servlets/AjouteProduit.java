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
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AjouteProduit", urlPatterns = {"/AjouteProduit"})
public class AjouteProduit extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nom = request.getParameter("nomProduit");
            String description = request.getParameter("detail");
            String imagerep = request.getParameter("imageRep");
            int idcompany = Integer.parseInt(request.getParameter("idCompany"));
          //  List<ProductSize> sizes = new ArrayList<>();
            Product p=new Product(0, nom, description, imagerep, idcompany, idcompany);
            ProductDAO obj=new ProductDAO();
            obj.create(p);
            System.out.println("ajouter dans la base de donné ");
        }   
    }
      
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>


}
