/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testBD;

import MiamProto.DAO.AddressDAO;
import MiamProto.DAO.CompanyDAO;
import MiamProto.DAO.MySQLConnexion;
import MiamProto.beans.Address;
import MiamProto.beans.Company;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author stagjava
 */
public class TestAddCompany {
    
    public TestAddCompany() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void addComppany () {
        // Init
        CompanyDAO coDAO = new CompanyDAO();
        AddressDAO adDAO = new AddressDAO();
        
        // Get the connexion for Commit/Rollback
        Connection connexion = MySQLConnexion.getInstance();
        
        // Add address
        Address address = new Address(0, 
                "", 
                "La Java Pizzeria", 
                "Rue JUnit", 
                "", 
                "31000", 
                "Toulouse", 
                "05 61 10 21 32", 
                "contact@javapizzeria.com");
        
        try {
            address = adDAO.create(address);
            connexion.commit();
        } catch (Exception e) {
            // Roll back
            try {
                connexion.rollback();
            } catch (Exception  e2) { 
                
            }                                       
        }
        
        // Checks address exist in DB
        List<Address> adresses = new ArrayList<>();
        adresses = adDAO.getAll();
        System.out.println("Liste des adresses");
        for (Address ad : adresses) {
            System.out.println(ad.toString());
        }
        
        address = adDAO.find(1);
        System.out.println(address.toString());
        
        Company company = new Company(0, 
                "La Java Pizzeria", 
                "", 
                address.getId(),
                "JavaPizza",
                "1234");
        try {
            company = coDAO.create(company);
            connexion.commit();
        } catch (Exception e) {
            // Roll back
            try {
                connexion.rollback();
            } catch (Exception  e2) { 
                
            }                                       
        }
 
        // Checks address exist in DB
        List<Company> cos = new ArrayList<>();
        cos = coDAO.getAll();
        System.out.println("Liste des sociétés");
        for (Company co : cos) {
            System.out.println(co.toString());
        }
        
        company = coDAO.find(1);
        System.out.println(company.toString());
    }
}
