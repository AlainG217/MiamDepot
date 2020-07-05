/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.metier;

import MiamProto.DAO.AddressDAO;
import MiamProto.DAO.CompanyDAO;
import MiamProto.DAO.MySQLConnexion;
import MiamProto.DAO.SalesOrderDAO;
import MiamProto.DAO.SalesOrderLineDAO;
import MiamProto.beans.Address;
import MiamProto.beans.Company;
import MiamProto.beans.ProductSize;
import MiamProto.beans.SalesOrder;
import MiamProto.beans.SalesOrderLine;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author stagjava
 */
public class SalesOrderPilot {

    private Company co;
    private List<SalesOrderLineV> lines;
    private List<SalesOrderV> orders;
    private List<ProductV> products;
    private SalesOrderV orderView;
    private SalesOrder header;
    private int orderState = 0;
    private int orderStatus = 0;
    private double orderTotal = 0;

    private CompanyDAO coDAO;
    private AddressDAO aDAO;
    private SalesOrderDAO sohDAO;
    private SalesOrderLineDAO solDAO;

    public SalesOrderPilot() {
        // Retrieve Company infos
        coDAO = new CompanyDAO();
        co = coDAO.find(1);
    }

    public void newBasket(List<ProductV> productVs) {
        // Init
        lines = new ArrayList<>();
        orderView = new SalesOrderV();

        for (ProductV product : productVs) {

            if (product.getQty() > 0) {
                if (product.isSmallSelected()) {
                    addLineView(product, 0);
                }
                if (product.isMediumSelected()) {
                    addLineView(product, 1);
                }
                if (product.isLargeSelected()) {
                    addLineView(product, 2);
                }

            }

        }
        orderView.setLines(lines);
        orderView.setOrderTotal(orderTotal);

    }
    
    public void showBasket() {
        orderView = new SalesOrderV();
        orderView.setLines(lines);
        orderView.setOrderTotal(orderTotal);
        
    }

    public List<ProductV> addLineToBasket(
            List<ProductV> products, int id, int size) {

        this.products = products;
        if (lines == null) {
            lines = new ArrayList<>();
        }

        // Check if the product size has already been added
        boolean found = findInBasket(products, id, size);
        if (found == false) {
            // Add the line 
            if (size == 0) {
                addLineView(products.get(id), 0);
            }
            if (size == 1) {
                addLineView(products.get(id), 1);
            }
            if (size == 2) {
                addLineView(products.get(id), 2);
            }

        }

        return products;
    }

    protected boolean findInBasket(List<ProductV> products, int id, int size) {
        // Check if product and size have already been added
        ProductV pv = products.get(id);
        
        Iterator it = lines.listIterator();
        
        while (it.hasNext()) {
            SalesOrderLineV line = (SalesOrderLineV) it.next();
            if (line.getIdProduct() == pv.getId()) {
                        // Size mgt
                switch (size) {
                    // Small
                    case 0:
                       if (line.getSize().equals("PETITE")) {
                           incrementLineQty(line, lines.indexOf(line));
                           return true;
                       }
                        break;
                    case 1:
                       if (line.getSize().equals("MOYENNE")) {
                           incrementLineQty(line, lines.indexOf(line));
                           return true;
                       }
                        break;
                    case 2:
                       if (line.getSize().equals("GRANDE")) {
                           incrementLineQty(line, lines.indexOf(line));
                           return true;
                       }
                        break;
                }

            }
        }
        return false;
    }

    protected void incrementLineQty(SalesOrderLineV line, int id) {

        line.setOrderQty(line.getOrderQty() + 1);
        line.setTotalPrice(line.getOrderQty() * line.getUnitPrice());
        lines.set(id, line);

    }

    protected void addLineView(ProductV product, int sizeSelected) {

        SalesOrderLineV line = new SalesOrderLineV();
        line.setName(product.getName());
        line.setDescription(product.getDescription());
        line.setOrderQty(product.getQty());
        line.setIdProduct(product.getId());
        line.setOrderQty(1);

        // Size mgt
        switch (sizeSelected) {
            // Small
            case 0:
                line.setSize(product.getSmall());
                line.setUnitPrice(product.getSmallPrice());
                break;
            case 1:
                line.setSize(product.getMedium());
                line.setUnitPrice(product.getMediumPrice());
                break;
            case 2:
                line.setSize(product.getLarge());
                line.setUnitPrice(product.getLargePrice());
                break;
        }
        // Find the id of the size
        Iterator it = product.getSizes().listIterator();
        
        while (it.hasNext()) {
            ProductSize ps = (ProductSize) it.next();
            if (line.getSize().equals(ps.getSize())) {
                line.setIdSize(ps.getId());
            }
        }
        line.setTotalPrice(line.getUnitPrice() * line.getOrderQty());

        lines.add(line);
        orderTotal += line.getTotalPrice();
    }
    
    
    public void save() {

        switch (orderState) {
            case 1: add();
            break;
            case 11: update();
            break;
            default: System.out.println("Erreur interne - state invalid");
        }
    }
    
    public void add() {
        // construct the DAOs
        if (aDAO == null)
            aDAO = new AddressDAO();
        if (sohDAO == null)
            sohDAO = new SalesOrderDAO();
        if (solDAO == null)
            solDAO = new SalesOrderLineDAO();
        
        // Get the connexion for Commit/Rollback
        Connection connexion = MySQLConnexion.getInstance();

        // view should be filled at this time
        if (orderView != null) {
            
            try {
                
            // First create the address
            Address address = aDAO.create(orderView.getAddress());
            
            // Create the sales order header
            header = new SalesOrder();
            header.setDeliveryMode(orderView.getDeliveryMode());
            header.setDeliveryTime(orderView.getDeliveryTime());
            header.setTotalPrice(orderView.getOrderTotal());
            header.setIdCompany(co.getId());
            header.setIdAdress(address.getId());
            header = sohDAO.create(header);
            
            // Create the different lines
            for (SalesOrderLineV line : orderView.getLines()) {
                SalesOrderLine sol = new SalesOrderLine();
                sol.setOrderQty(line.getOrderQty());
                sol.setUnitPrice(line.getUnitPrice());
                sol.setTotalPrice(line.getTotalPrice());
                sol.setType(0);
                sol.setIdOrder(header.getId());
                sol.setIdProductSize(line.getIdSize());
                sol.setIdMasterLine(0);
                sol = solDAO.create(sol);
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
    
    public void showOrderList () {

    // Init
    List<SalesOrder> orderBeans = new ArrayList<>();
    if (orders == null)
        orders = new ArrayList<>() ;

    // construct the DAOs
        if (sohDAO == null)
            sohDAO = new SalesOrderDAO();
        if (solDAO == null)
            solDAO = new SalesOrderLineDAO();
        if (aDAO == null)
            aDAO = new AddressDAO();
        
        // Get the list of orders
        orderBeans = sohDAO.getAll();
        
        // For each order, prepare the view for list
        for (SalesOrder bean : orderBeans) {
            SalesOrderV view = new SalesOrderV();
            
            // get the address
            Address adr = aDAO.find(bean.getIdAdress());
            view.setAddress(adr);
            view.init(bean);
            
            orders.add(view);
        }

    }
    
    public Company getCo() {
        return co;
    }

    public void setCo(Company co) {
        this.co = co;
    }

    public List<SalesOrderLineV> getLines() {
        return lines;
    }

    public void setLines(List<SalesOrderLineV> lines) {
        this.lines = lines;
    }

    public SalesOrderV getOrderView() {
        return orderView;
    }

    public void setOrderView(SalesOrderV orderView) {
        this.orderView = orderView;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public CompanyDAO getCoDAO() {
        return coDAO;
    }

    public void setCoDAO(CompanyDAO coDAO) {
        this.coDAO = coDAO;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<SalesOrderV> getOrders() {
        return orders;
    }

    public void setOrders(List<SalesOrderV> orders) {
        this.orders = orders;
    }

    public List<ProductV> getProducts() {
        return products;
    }

    public void setProducts(List<ProductV> products) {
        this.products = products;
    }

    public SalesOrder getHeader() {
        return header;
    }

    public void setHeader(SalesOrder header) {
        this.header = header;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public AddressDAO getaDAO() {
        return aDAO;
    }

    public void setaDAO(AddressDAO aDAO) {
        this.aDAO = aDAO;
    }

    public SalesOrderDAO getSohDAO() {
        return sohDAO;
    }

    public void setSohDAO(SalesOrderDAO sohDAO) {
        this.sohDAO = sohDAO;
    }

    public SalesOrderLineDAO getSolDAO() {
        return solDAO;
    }

    public void setSolDAO(SalesOrderLineDAO solDAO) {
        this.solDAO = solDAO;
    }

}
