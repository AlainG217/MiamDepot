/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.metier;

import MiamProto.DAO.CompanyDAO;
import MiamProto.beans.Company;
import MiamProto.beans.SalesOrderLine;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author stagjava
 */
public class SalesOrderPilot {
    Company co;
    List<SalesOrderLineV> lines;    
    int orderState = 0;

    CompanyDAO coDAO;

    public SalesOrderPilot() {
        // Retrieve Company infos
        coDAO = new CompanyDAO();
        co = coDAO.find(1);        
    }
    
    public void newBasket(List<ProductV> productVs) {
        // Init
        lines = new ArrayList<>();
        SalesOrderV orderView;
        
        for (ProductV product : productVs) {
            
            if (product.isSmallSelected()) {
                addLineView( product,  0);
            }
            if (product.isMediumSelected()) {
                addLineView( product,  1);
            }
            if (product.isLargeSelected()) {
                addLineView( product,  2);
            }
        }

    }

    protected void addLineView (ProductV product,int sizeSelected) {
        
        SalesOrderLineV line = new SalesOrderLineV();
        line.setName(product.getName());
        line.setDescription(product.getDescription());
        line.setOrderQty(product.getQty());
        line.setIdProduct(product.getId());
        
        // Size mgt
        switch (sizeSelected) {
            // Small
            case 0:
                line.setSize(product.getSmall());
                line.setUnitPrice(product.getSmallPrice());
                line.setTotalPrice(product.getSmallPrice() * product.getQty());
                break;
            case 1:
                line.setSize(product.getMedium());
                line.setUnitPrice(product.getMediumPrice());
                line.setTotalPrice(product.getMediumPrice() * product.getQty());
                break;
            case 2:
                line.setSize(product.getLarge());
                line.setUnitPrice(product.getLargePrice());
                line.setTotalPrice(product.getLargePrice() * product.getQty());
                break;
        }
        
        lines.add(line);
    }
}
