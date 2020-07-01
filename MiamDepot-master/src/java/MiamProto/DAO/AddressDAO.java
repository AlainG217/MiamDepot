/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.DAO;

import MiamProto.beans.Address;

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
public class AddressDAO  extends DAO<Address>{
    
    private final String TABLE = "address";
    
    @Override
    public Address find(Integer id) {
        // Initialisation
        Address address = null;
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE + " WHERE id = ?";
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.first()) {
                address = new Address();
                address.setId(id);
                address.setFirstName(rs.getString("firstName"));
                address.setLastName(rs.getString("LastName"));
                address.setLine1(rs.getString("line1"));
                address.setLine2(rs.getString("line2"));
                address.setPostalCode(rs.getString("postalCode"));
                address.setCity(rs.getString("city"));
                address.setPhone(rs.getString("phone"));
                address.setEmail(rs.getString("email"));
               
            }
            
        } catch (SQLException e) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return address;
    }
    
    @Override
    public Address create(Address obj) {
        
        // Accès à la base
        try {
            String req = "INSERT INTO " + TABLE + 
                    " (firstName, lastName, line1,  line2, postalCode, city, "
                    + "phone, email) VALUES(?,  ?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, obj.getFirstName());
            pstmt.setString(2, obj.getLastName());
            pstmt.setString(3, obj.getLine1());
            pstmt.setString(4, obj.getLine2());
            pstmt.setString(5, obj.getPostalCode());
            pstmt.setString(6, obj.getCity());
            pstmt.setString(7, obj.getPhone());
            pstmt.setString(8, obj.getEmail());

            pstmt.executeUpdate();

            // Récupérer l'ID
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.first()) {
                obj.setId(rs.getInt(1));
            }
            
        } catch (SQLException e) {
            Logger.getLogger(
                    AddressDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public Address update(Address obj) {
        
        // Accès à la base
        try {
            String req = "UPDATE " + TABLE + 
                    " SET firstName = ?, lastName = ?, line1 = ? , line2 = ? , "
                    + "postalCode = ? , city = ?, phone = ?, email = ?"
                    + " WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setString(1, obj.getFirstName());
            pstmt.setString(2, obj.getLastName());
            pstmt.setString(3, obj.getLine1());
            pstmt.setString(4, obj.getLine2());
            pstmt.setString(5, obj.getPostalCode());
            pstmt.setString(6, obj.getCity());
            pstmt.setString(7, obj.getPhone());
            pstmt.setString(8, obj.getEmail());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public Address delete(Address obj) {
        
        // Accès à la base
        try {
            String req = "DELETE FROM " + TABLE + "  WHERE id = ?";
            
            PreparedStatement pstmt = 
                    this.connexion.prepareStatement(req);

            pstmt.setInt(1, obj.getId());

            pstmt.executeUpdate();
            
            
        } catch (SQLException e) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return obj;
    }
    
    @Override
    public List<Address> getAll() {
        // Initialisation
        List<Address> entities = new ArrayList<>();
        
        // Accès à la base
        try {
            String req = "SELECT * FROM " + TABLE;
            
            PreparedStatement pstmt = this.connexion.prepareStatement(req);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                entities.add(new Address(
                        rs.getInt("id"), 
                        rs.getString("firstName"), 
                        rs.getString("lastName"), 
                        rs.getString("line1"), 
                        rs.getString("line2"), 
                        rs.getString("postalCode"), 
                        rs.getString("city"), 
                        rs.getString("phone"), 
                        rs.getString("email"))
                );
          }
            
        } catch (SQLException e) {
            Logger.getLogger(AddressDAO.class.getName()).log(Level.SEVERE, null, e);            
        }
        
        return entities;
    }
    
}
