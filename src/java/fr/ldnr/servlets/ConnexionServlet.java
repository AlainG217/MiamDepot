/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.ldnr.servlets;

import MiamProto.DAO.CompanyDAO;
import MiamProto.beans.Company;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
@WebServlet(name = "connexion", urlPatterns = {"/connexion"})
public class ConnexionServlet extends HttpServlet {
    private static final String VUE="/WEB-INF/connexion.jsp";
    
private Map<String,String> erreurs=new HashMap<>();
    private CompanyDAO companyDAO;
    
    
    public void init(){
    companyDAO=new CompanyDAO();
    }

    
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      String username=request.getParameter("user");
      String motdepasse=request.getParameter("motdepasse");
      Company company=new Company();
      company.setName(username);
      company.setLogoRep(motdepasse);
     
        if((!company.getName().equals(username))&&(!company.getLogoRep().equals(motdepasse))) {
          HttpSession session = request.getSession();
            System.out.println(" votre saisie est incorrecte");
            
        }else {
        
            response.sendRedirect("gestionProduit.jsp");
        System.out.println("conexion avec access");
        }
      
      
    }
    
    
    private void setErreur(String champ,String message){
    
    erreurs.put(champ,message);
    }

   


    
    
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
       // ProductDAO productDAO = new ProductDAO ();
        
        
        this.getServletContext()
                .getRequestDispatcher("/WEB-INF/connexion.jsp")
                .forward(request, response);
    } 
}