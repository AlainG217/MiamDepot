/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.DAO;

import MiamProto.beans.SalesOrder;
import java.sql.Date;

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
public class SalesOrderDAO  extends DAO<SalesOrder>{
    
    private final String TABLE = "salesOrder";
    
    @Override
    public SalesOrder find(Integer id) {
        // Initialisation
        SalesOrder so = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                so = new SalesOrder();
                so.setId(id);
                so.setDeliveryMode(rs.getInt("deliveryMode"));
                Date uneDate = rs.getDate("deliveryTime");
                so.setDeliveryTime(uneDate.toLocalDate());
                so.setStatus(rs.getInt("status"));
                so.setTotalPrice(rs.getDouble("totalPrice"));
                so.setIdCompany(rs.getInt("idCompany"));
                so.setIdAdress(rs.getInt("idAddress"));
                
            }
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return so;
    }
    
    public SalesOrder create(SalesOrder obj) {
        
        // Accès à la base
        try {
            String req = "INSERT INTO " + TABLE + 
                    " (deliveryMode, deliveryTime, status, totalPrice, "
                    + "idCompany, idAddress) VALUES(?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, obj.getDeliveryMode());
            Date uneDate = Date.valueOf(obj.getDeliveryTime());
            pstmt.setDate(2, uneDate);
            pstmt.setInt(3, obj.getStatus());
            pstmt.setDouble(4, obj.getTotalPrice());
            pstmt.setInt(5, obj.getIdCompany());
            pstmt.setInt(6, obj.getIdAdress());

            pstmt.executeUpdate();

            // Récupérer l'ID
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.first()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public SalesOrder update(SalesOrder obj) {
        
        // Accès à la base
        try {
            String req = "UPDATE " + TABLE + 
                    " SET deliveryMode = ?, deliveryTime = ?, status = ? , "
                    + "totalPrice = ?, idCompany = ?, idAddress = ? WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getDeliveryMode());
            Date uneDate = Date.valueOf(obj.getDeliveryTime());
            pstmt.setDate(2, uneDate);
            pstmt.setInt(3, obj.getStatus());
            pstmt.setDouble(4, obj.getTotalPrice());
            pstmt.setInt(5, obj.getIdCompany());
            pstmt.setInt(6, obj.getIdAdress());
            pstmt.setInt(7, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public SalesOrder delete(SalesOrder obj) {
        
        // Accès à la base
        try {
            String req = "DELETE FROM " + TABLE + "  WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public List<SalesOrder> getAll() {
        // Initialisation
        List<SalesOrder> entities = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE;
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Date uneDate = rs.getDate("deliveryTime");
                entities.add(new SalesOrder(
                        rs.getInt("id"), 
                        rs.getInt("deliveryMode"), 
                        uneDate.toLocalDate(), 
                        rs.getInt("status"), 
                        rs.getDouble("totalPrice"),
                        rs.getInt("idCompany"),
                        rs.getInt("idAddress"))
                );
          }
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return entities;
    }
    
}
