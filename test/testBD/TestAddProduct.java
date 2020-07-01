/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testBD;

import MiamProto.beans.Product;
import MiamProto.beans.ProductSize;
import MiamProto.metier.ProductPilot;
import MiamProto.metier.ProductV;
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
public class TestAddProduct {
    
    public TestAddProduct() {
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
    public void addProduct() {
        // Init
        ProductPilot pilot = new ProductPilot();

        // Sizes
        List<ProductSize> sizes = new ArrayList<>();
        sizes.add(new ProductSize(0, "PETITE", 9, 0));
        sizes.add(new ProductSize(0, "MOYENNE", 11, 0));
        sizes.add(new ProductSize(0, "GRANDE", 13, 0));
        
        // Product
        pilot.init(
                "Margharita", 
                "Base tomate, champignons, olives", 
                0,
                sizes);
        System.out.println(pilot.getProductState());
        
        pilot.save();
        
        // Check in DB
        List<ProductV> views = pilot.getAll();
        for (ProductV view : views) {
            System.out.println(view.toString());
            for (ProductSize ps : view.getSizes()) {
                System.out.println(ps.toString());                
            }
        }
    }
}
