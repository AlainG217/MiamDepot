/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.DAO;

import MiamProto.beans.SalesOrderLine;
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
public class SalesOrderLineDAO  extends DAO<SalesOrderLine>{
    
    private final String TABLE = "salesOrderLine";
    
    @Override
    public SalesOrderLine find(Integer id) {
        // Initialisation
        SalesOrderLine so = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                so = new SalesOrderLine();
                so.setId(id);
                so.setOrderQty(rs.getInt("orderQty"));
                so.setUnitPrice(rs.getDouble("unitPrice"));
                so.setTotalPrice(rs.getDouble("totalPrice"));
                so.setType(rs.getInt("type"));
                so.setIdOrder(rs.getInt("idOrder"));
                so.setIdProductSize(rs.getInt("idProductSize"));
                so.setIdMasterLine(rs.getInt("idMasterLine"));
                
            }
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderLineDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return so;
    }
    
    public SalesOrderLine create(SalesOrderLine obj) {
        
        // Accès à la base
        try {
            String req = "INSERT INTO " + TABLE + 
                    " (orderQty, unitPrice, totalPrice, type, "
                    + "idOrder, idProductSize, idMasterLine) VALUES(?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, obj.getOrderQty());
            pstmt.setDouble(2, obj.getUnitPrice());
            pstmt.setDouble(3, obj.getTotalPrice());
            pstmt.setInt(4, obj.getType());
            pstmt.setInt(5, obj.getIdOrder());
            pstmt.setInt(6, obj.getIdProductSize());
            pstmt.setInt(7, obj.getIdMasterLine());

            pstmt.executeUpdate();

            // Récupérer l'ID
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.first()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderLineDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public SalesOrderLine update(SalesOrderLine obj) {
        
        // Accès à la base
        try {
            String req = "UPDATE " + TABLE + 
                    " SET orderQty = ?, unitPrice = ?, totalPrice = ? , "
                    + "type = ?, idOrder = ?, idProductSize = ?,"
                    + " idMasterLine = ? WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getOrderQty());
            pstmt.setDouble(2, obj.getUnitPrice());
            pstmt.setDouble(3, obj.getTotalPrice());
            pstmt.setInt(4, obj.getType());
            pstmt.setInt(5, obj.getIdOrder());
            pstmt.setInt(6, obj.getIdProductSize());
            pstmt.setInt(7, obj.getIdMasterLine());
            pstmt.setInt(8, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderLineDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public SalesOrderLine delete(SalesOrderLine obj) {
        
        // Accès à la base
        try {
            String req = "DELETE FROM " + TABLE + "  WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderLineDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public List<SalesOrderLine> getAll() {
        // Initialisation
        List<SalesOrderLine> entities = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE;
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                entities.add(new SalesOrderLine(
                        rs.getInt("id"), 
                        rs.getInt("orderQty"), 
                        rs.getDouble("unitPrice"),
                        rs.getDouble("totalPrice"),
                        rs.getInt("type"), 
                        rs.getInt("idOrder"),
                        rs.getInt("idProductSize"),
                        rs.getInt("idMasterLine"))
                );
          }
            
        } catch (SQLException e) {
            Logger.getLogger(SalesOrderLineDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return entities;
    }
    
}
