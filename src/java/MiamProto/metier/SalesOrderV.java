/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.metier;

import MiamProto.beans.Address;
import MiamProto.beans.SalesOrder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author stagjava
 */
public class SalesOrderV {

    // header attributes
    private int id;
    private int deliveryMode;
    private LocalDate deliveryTime;
    private double orderTotal;
    private int status;
    
    // attributes for list
    String mode;
    String clientName;
    String lStatus;

    // Address
    Address address;

    public void init(SalesOrder bean) {
        id = bean.getId();
        deliveryMode = bean.getDeliveryMode();
        deliveryTime = bean.getDeliveryTime();
        orderTotal = bean.getTotalPrice();
        status = bean.getStatus();
        
        switch (deliveryMode) {
            case 0 : mode = "A emporter";
            break;
            case 1 : mode = "Livraison";
            break;
        }
        
        clientName = address.getFirstName() + " " + address.getLastName();

        lStatus = "";
        switch (status) {
            case 0 : lStatus = "Panier";
            break;
            case 1 : lStatus = "Validée";
            break;
            case 2 : lStatus = "Réglée";
            break;
            case 3 : lStatus = "Livrée";
            break;
            case -1 : lStatus = "Annulée";
            break;
        }
        
    }
    // Lines
    private List<SalesOrderLineV> lines;

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

    public int getDeliveryMode() {
        return deliveryMode;
    }

    public void setDeliveryMode(int deliveryMode) {
        this.deliveryMode = deliveryMode;
    }

    public LocalDate getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(LocalDate deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }
    
}
