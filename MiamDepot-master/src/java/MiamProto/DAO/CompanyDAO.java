/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.DAO;

import MiamProto.beans.Company;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Company DAO
 * @author stagjava
 */
public class CompanyDAO  extends DAO<Company>{
    
    private final String TABLE = "company";
    
    @Override
    public Company find(Integer id) {
        // Initialisation
        Company co = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                co = new Company();
                co.setId(id);
                co.setName(rs.getString("name"));
                co.setIdAdress(rs.getInt("idAddress"));
                
            }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    CompanyDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return co;
    }
    
    @Override
    public Company create(Company obj) {
        
        // Accès à la base
        try {
            String req = "INSERT INTO " + TABLE + 
                    " (name, logoRep,  idAddress) VALUES(?,  ?, ?)";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getLogoRep());
            pstmt.setInt(3, obj.getIdAdress());

            pstmt.executeUpdate();

            // Récupérer l'ID
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.first()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    Company.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public Company update(Company obj) {
        
        // Accès à la base
        try {
            String req = "UPDATE " + TABLE + 
                    " SET name = ?, logoRep = ? , idAddress = ? WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getLogoRep());
            pstmt.setInt(3, obj.getIdAdress());
            pstmt.setInt(4, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(
                    CompanyDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public Company delete(Company obj) {
        
        // Accès à la base
        try {
            String req = "DELETE FROM " + TABLE + "  WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(
                    CompanyDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public List<Company> getAll() {
        // Initialisation
        List<Company> entities = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE;
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                entities.add(new Company(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("logoRep"), 
                        rs.getInt("idAddress"))
                );
          }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    CompanyDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return entities;
    }
    
}
