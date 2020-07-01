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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author stagjava
 */
public class TestFindCompany {
    
    public TestFindCompany() {
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
    public void findCompany () {
                // Init
        CompanyDAO coDAO = new CompanyDAO();
        AddressDAO adDAO = new AddressDAO();
                
        Address address = adDAO.find(1);
        System.out.println(address.toString());
                
        Company co = coDAO.find(1);
        System.out.println(co.toString());

    }
}
