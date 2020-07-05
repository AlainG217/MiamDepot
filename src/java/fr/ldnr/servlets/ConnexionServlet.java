/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.servlets;

import MiamProto.beans.Company;
import MiamProto.metier.ConnectPilot;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
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
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/ConnexionServlet"})
public class ConnexionServlet extends HttpServlet {
     private static final long serialVersionUID = 1L;
    private static final String Vue = "/WEB-INF/gestionProduit.jsp";
    private Map<String, String> erreurs = new HashMap<>();

    private ConnectPilot connectPilot;


    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        String username = request.getParameter("user");
        String motdepasse = request.getParameter("motdepasse");
        Company company = new Company();
        company.setName(username);
        company.setLogoRep(motdepasse);
        connectPilot=new ConnectPilot();
      
        try {
  PrintWriter out=response.getWriter();
            if (connectPilot.connect(username, motdepasse)) {
                response.sendRedirect(request.getContextPath() + "/WEB-INF/manageOrderList.jsp");
/*                this.getServletContext()
                        .getRequestDispatcher("/WEB-INF/manageOrderList.jsp")
                        .forward(request, response);
*/
            } else {

                 
                 out.println("login failled");
            }

        } catch (Exception e) {
            e.getMessage();
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
