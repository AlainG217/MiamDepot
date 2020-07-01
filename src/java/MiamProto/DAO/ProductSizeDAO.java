/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.DAO;

import MiamProto.beans.Product;
import MiamProto.beans.ProductSize;
import MiamProto.beans.Size;

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
public class ProductSizeDAO  extends DAO<ProductSize>{
    
    private final String TABLE = "productSize";
    
    @Override
    public ProductSize find(Integer id) {
        // Initialisation
        ProductSize size = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                size = new ProductSize();
                size.setId(id);
                size.setSize(rs.getString("size"));
                size.setPrice(rs.getDouble("price"));
                size.setIdProduct(rs.getInt("idProduct"));
                
            }
            
        } catch (SQLException e) {
            Logger.getLogger(ProductSizeDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return size;
    }
    
    @Override
    public ProductSize create(ProductSize obj) {
        
        // Accès à la base
        try {
            String req = "INSERT INTO " + TABLE + 
                    " (size, price, idProduct) VALUES(?,  ?, ?)";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, obj.getSize());
            pstmt.setDouble(2, obj.getPrice());
            pstmt.setInt(3, obj.getIdProduct());

            pstmt.executeUpdate();

            // Récupérer l'ID
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.first()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(ProductSizeDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public ProductSize update(ProductSize obj) {
        
        // Accès à la base
        try {
            String req = "UPDATE " + TABLE + 
                    " SET size = ?, price = ? , idProduct = ? WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setString(1, obj.getSize());
            pstmt.setDouble(2, obj.getPrice());
            pstmt.setInt(3, obj.getIdProduct());
            pstmt.setInt(4, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(ProductSizeDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public ProductSize delete(ProductSize obj) {
        
        // Accès à la base
        try {
            String req = "DELETE FROM " + TABLE + "  WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(ProductSizeDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public List<ProductSize> getAll() {
        // Initialisation
        List<ProductSize> entities = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE;
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                entities.add(new ProductSize(
                        rs.getInt("id"), 
                        rs.getString("size"), 
                        rs.getDouble("price"), 
                        rs.getInt("idProduct"))
                );
          }
            
        } catch (SQLException e) {
            Logger.getLogger(ProductSizeDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return entities;
    }
    
    public List<ProductSize> getByProductId(int id) {
        // Initialisation
        List<ProductSize> entities = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE idProduct = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                entities.add(new ProductSize(
                        rs.getInt("id"), 
                        rs.getString("size"), 
                        rs.getDouble("price"), 
                        rs.getInt("idProduct"))
                );
          }
            
        } catch (SQLException e) {
            Logger.getLogger(ProductSizeDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return entities;
    }
    
}
