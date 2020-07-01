/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.metier;

// Applications
import MiamProto.DAO.CompanyDAO;
import MiamProto.DAO.MySQLConnexion;
import MiamProto.DAO.ProductDAO;
import MiamProto.DAO.ProductSizeDAO;
import MiamProto.beans.Company;
import MiamProto.beans.Product;
import MiamProto.beans.ProductSize;
import java.sql.Connection;

// Java
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stagjava
 */
public class ProductPilot {
    
    ProductV view;
    Company co;
    Product product;
    
    int productState = 0;

    ProductDAO pDAO;
    ProductSizeDAO psDAO;
    CompanyDAO coDAO;

    public ProductPilot() {
        // Retrieve Company infos
        coDAO = new CompanyDAO();
        co = coDAO.find(1);        
    }

    /**
     * Build and return a list of productViews.
     * @return 
     */
    public List<ProductV> getAll() {
        // Init
        List<ProductV> productVs = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<ProductSize> sizes = new ArrayList<>();
        
        // construct the DAOs
        if (pDAO == null)
            pDAO = new ProductDAO();
        if (psDAO == null)
            psDAO = new ProductSizeDAO();
        
        // Get the list of products
        products = pDAO.getAll();
        
        // For each product, get the sizes and build product view
        for (Product product : products) {
            
            sizes = psDAO.getByProductId(product.getId());
            productVs.add(
                new ProductV(
                        product.getName(), 
                        product.getDescription(),
                        product.getImage(), 
                        product.getImageRep(), 
                        product.getType(), 
                        sizes)
                );
            
        }
                
        return productVs;
    }
    
    public void init (String name, String desc, int type, List<ProductSize> sizes ) {
        
        view = new ProductV(
                        name, 
                        desc,
                        null, 
                        "", 
                        type,
                        sizes);
        
        
        // Indicate add operation to do
        productState = 1;
    }
    
    public void save() {

        switch (productState) {
            case 1: add();
            break;
            case 11: update();
            break;
            default: System.out.println("Erreur interne - state invalid");
        }
    }
    
    public void add() {
        // construct the DAOs
        if (pDAO == null)
            pDAO = new ProductDAO();
        if (psDAO == null)
            psDAO = new ProductSizeDAO();
        
        // Get the connexion for Commit/Rollback
        Connection connexion = MySQLConnexion.getInstance();

        // view should be filled at this time
        if (view != null) {
            
            try {
            // Create the product
            product = new Product();
            product.setName(view.getName());
            product.setDescription(view.getDescription());
            product.setImage(view.getImage());
            product.setImageRep(view.getImageRep());
            product.setIdCompany(co.getId());
            product.setType(view.getType());
            product = pDAO.create(product);
            
            // Create the different sizes
            for (ProductSize size : view.getSizes()) {
                size.setIdProduct(product.getId());
                size = psDAO.create(size);
            }
            
            // Commit
            connexion.commit();
            
            } catch (Exception e ) {
                // Roll back
                try {
                    connexion.rollback();
                } catch (Exception  e2) {                            
                }
            }
        }
    }
    public void update() {
        // A implémenter
    }

    public int getProductState() {
        return productState;
    }

    public void setProductState(int productState) {
        this.productState = productState;
    }
    
}
