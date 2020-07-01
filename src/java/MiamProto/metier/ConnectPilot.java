/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.metier;

import MiamProto.DAO.CompanyDAO;
import MiamProto.beans.Company;

/**
 *
 * @author stagjava
 */
public class ConnectPilot {
    
    public boolean connect (String user, String password) {
            // Retrieve Company infos
        CompanyDAO coDAO = new CompanyDAO();
        Company co = coDAO.find(1);        
    
        boolean isValid = false;
        
        if (co.getUser().equals(user) && co.getPassword().equals(password)) {
            isValid = true;
        } 
        
        return isValid;
    }
    
}
