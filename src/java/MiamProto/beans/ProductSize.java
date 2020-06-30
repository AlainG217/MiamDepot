/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.beans;

import java.io.Serializable;

/**
 *
 * @author stagjava
 */
public class ProductSize implements Serializable {

    /**
     * Attributes
     */
    private int id;
    private Size size;
    private double price;
    private int idProduct;

    /**
     * Constructors
     */

    public ProductSize() {
    }

    public ProductSize(int id, Size size, double price, int idProduct) {
        this.id = id;
        this.size = size;
        this.price = price;
        this.idProduct = idProduct;
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

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    @Override
    public String toString() {
        return "ProductSize{" + "id=" + id + ", size=" + size + ", price=" + price + ", idProduct=" + idProduct + '}';
    }
    
}
