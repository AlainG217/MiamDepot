/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.servlets;



import MiamProto.metier.ProductPilot;
import MiamProto.metier.ProductV;
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
 * @author Monnier.M
 */
@WebServlet(name = "Home", urlPatterns = {"/Home"})
public class Home extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

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

        HttpSession session = request.getSession();
        
        ProductPilot pilot = new ProductPilot();
        
        List<ProductV> foods = pilot.getFood();
        List<ProductV> drinks = pilot.getDrinks();
        
         session.setAttribute("foods", foods);
         session.setAttribute("drinks", drinks);
         
         
         
        /* 
         CompanyPilot company = new CompanyPilot();
         
         String companyName = company.getName();
         String companyAdress_Line1 = company.getLine1();
         String company_PostalC = company.getPostalCode();
         String companyCity = company.getCity();
         String companyPhone = company.getPhone();
         String companyMail = company.getMail();
         
         
         request.setAttribute("companyName", companyName);
         request.setAttribute("companyAdress_Line1", companyAdress_Line1);
         request.setAttribute("company_PostalC", company_PostalC);
         request.setAttribute("companyCity", companyCity);
         request.setAttribute("companyPhone", companyPhone);
         request.setAttribute("companyMail", companyMail);*/

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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

            HttpSession session = request.getSession();

            this.getServletContext().getRequestDispatcher("/WEB-INF/Basket.jsp" ).forward( request, response );
        }
        
        

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }