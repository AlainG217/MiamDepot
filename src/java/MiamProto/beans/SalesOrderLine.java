/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.beans;

/**
 *
 * @author stagjava
 */
public class SalesOrderLine {
    /**
     * Attributes
     * type 0: Normal 1: Menu 
     */
    private int id;
    private int orderQty;
    private int unitPrice;
    private double totalPrice;
    private int type;
    private int idOrder;
    private int idProductSize;
    private int idMasterLine;

    /**
     * Getters and setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdProductSize() {
        return idProductSize;
    }

    public void setIdProductSize(int idProductSize) {
        this.idProductSize = idProductSize;
    }

    public int getIdMasterLine() {
        return idMasterLine;
    }

    public void setIdMasterLine(int idMasterLine) {
        this.idMasterLine = idMasterLine;
    }

    @Override
    public String toString() {
        return "SalesOrderLine{" + "id=" + id + ", orderQty=" + orderQty + ", unitPrice=" + unitPrice + ", totalPrice=" + totalPrice + ", type=" + type + ", idOrder=" + idOrder + ", idProductSize=" + idProductSize + ", idMasterLine=" + idMasterLine + '}';
    }
    
}
