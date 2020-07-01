/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testBD;

import MiamProto.DAO.AddressDAO;
import MiamProto.DAO.CompanyDAO;
import MiamProto.beans.Address;
import MiamProto.beans.Company;
import MiamProto.beans.ProductSize;
import MiamProto.metier.ProductPilot;
import MiamProto.metier.ProductV;
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
public class TestGetAllProduct {
    
    public TestGetAllProduct() {
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
    public void getAllProduct () {
        // Init
        ProductPilot pilot = new ProductPilot();
                
        List<ProductV> views = pilot.getAll();
        for (ProductV view : views) {
            System.out.println(view.toString());
            for (ProductSize ps : view.getSizes()) {
                System.out.println(ps.toString());                
            }
        }

    }
}
