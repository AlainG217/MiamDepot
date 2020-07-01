/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.DAO;

import MiamProto.beans.Product;
import MiamProto.metier.ProductV;

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
public class ProductDAO  extends DAO<Product>{
    
    private final String TABLE = "product";
    
    @Override
    public Product find(Integer id) {
        // Initialisation
        Product product = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                product = new Product();
                product.setId(id);
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setImageRep(rs.getString("imageRep"));
                product.setIdCompany(rs.getInt("idCompany"));
                
            }
            
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return product;
    }
    
    public Product create(Product obj) {
        
        // Accès à la base
        try {
            String req = "INSERT INTO " + TABLE + 
                    " (name, description, imageRep, idCompany) VALUES(?, ?, ?, ?)";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getDescription());
            pstmt.setString(3, obj.getImageRep());
            pstmt.setInt(4, obj.getIdCompany());

            pstmt.executeUpdate();

            // Récupérer l'ID
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.first()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    ProductDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public Product update(Product obj) {
        
        // Accès à la base
        try {
            String req = "UPDATE " + TABLE + 
                    " SET name = ?, description = ?, imageRep = ? , idCompany = ? WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setString(1, obj.getName());
            pstmt.setString(2, obj.getDescription());
            pstmt.setString(3, obj.getImageRep());
            pstmt.setInt(4, obj.getIdCompany());
            pstmt.setInt(5, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public Product delete(Product obj) {
        
        // Accès à la base
        try {
            String req = "DELETE FROM " + TABLE + "  WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public List<Product> getAll() {
        // Initialisation
        List<Product> entities = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE;
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                entities.add(new Product(
                        rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("description"), 
                        rs.getString("imageRep"), 
                        rs.getInt("idCompany"))
                );
          }
            
        } catch (SQLException e) {
            Logger.getLogger(ProductDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return entities;
    }
    
}
