/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author stagjava
 */
public class SalesOrder implements Serializable {

    /**
     * Attributes
     * deliveryMode 0: Sur place 1: A emporter 2: Livré
     * status 0: Panier 1: Validée 2: Payée 3: Livrée -1: Annulée
     */
    private int id;
    private int deliveryMode;
    private LocalDate deliveryTime;
    private int status;
    private double totalPrice;
    private int idCompany;
    private int idAdress;

    /**
     * Constructors
     */

    public SalesOrder() {
    }

    public SalesOrder(int id, int deliveryMode, LocalDate deliveryTime, int status, double totalPrice, int idCompany, int idAdress) {
        this.id = id;
        this.deliveryMode = deliveryMode;
        this.deliveryTime = deliveryTime;
        this.status = status;
        this.totalPrice = totalPrice;
        this.idCompany = idCompany;
        this.idAdress = idAdress;
    }

    /**
     * Getters and setters
     */
 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    public int getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(int idAdress) {
        this.idAdress = idAdress;
    }

    @Override
    public String toString() {
        return "SalesOrder{" + "id=" + id + ", deliveryMode=" + deliveryMode + ", deliveryTime=" + deliveryTime + ", status=" + status + ", totalPrice=" + totalPrice + ", idCompany=" + idCompany + ", idAdress=" + idAdress + '}';
    }
    
}
