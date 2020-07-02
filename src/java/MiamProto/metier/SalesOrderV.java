/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.metier;

import java.util.List;

/**
 *
 * @author stagjava
 */
public class SalesOrderV {
    
    private List<SalesOrderLineV> lines;
    private double orderTotal;

    public List<SalesOrderLineV> getLines() {
        return lines;
    }

    public void setLines(List<SalesOrderLineV> lines) {
        this.lines = lines;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }
    
}
