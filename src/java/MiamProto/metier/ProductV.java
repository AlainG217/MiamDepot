/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiamProto.metier;

import MiamProto.DAO.ProductDAO;
import MiamProto.DAO.ProductSizeDAO;
import MiamProto.beans.ProductSize;
import java.util.List;

/**
 *
 * @author stagjava
 */
public class ProductV {

    private String name;
    private String description;
    private byte[] image;
    private String imageRep;
    private int type;
    private int qty;
    private String small; 
    private double smallPrice; 
    private boolean smallSelected; 
    private String medium; 
    private double mediumPrice; 
    private boolean mediumSelected; 
    private String large; 
    private double largePrice; 
    private boolean largeSelected; 
    private List<ProductSize> sizes;
    private int id;

    public ProductV() {
    }

    public ProductV(String name, String description, byte[] image, 
            String imageRep, int type, int id,
            List<ProductSize> sizes) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.imageRep = imageRep;
        this.sizes = sizes;
        this.type = type;
        this.qty = 0;
        this.id = id;

        small = "";
        smallPrice = 0;
        medium = "";
        mediumPrice = 0;
        large = "";
        largePrice = 0;
        smallSelected = false;
        mediumSelected = false;
        largeSelected = false;
        
        for (ProductSize size : sizes) {
            switch (size.getSize()) {
                case "PETITE" :
                    small = size.getSize();
                    smallPrice = size.getPrice();
                    break;
                case "MOYENNE" :
                    medium = size.getSize();
                    mediumPrice = size.getPrice();
                    break;
                case "GRANDE" :
                    large = size.getSize();
                    largePrice = size.getPrice();
                    break;
             }
        }
    }

    /**
     * Getters and setters
     */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageRep() {
        return imageRep;
    }

    public void setImageRep(String imageRep) {
        this.imageRep = imageRep;
    }

    public List<ProductSize> getSizes() {
        return sizes;
    }

    public void setSizes(List<ProductSize> sizes) {
        this.sizes = sizes;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public double getSmallPrice() {
        return smallPrice;
    }

    public void setSmallPrice(double smallPrice) {
        this.smallPrice = smallPrice;
    }

    public boolean isSmallSelected() {
        return smallSelected;
    }

    public void setSmallSelected(boolean smallSelected) {
        this.smallSelected = smallSelected;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public double getMediumPrice() {
        return mediumPrice;
    }

    public void setMediumPrice(double mediumPrice) {
        this.mediumPrice = mediumPrice;
    }

    public boolean isMediumSelected() {
        return mediumSelected;
    }

    public void setMediumSelected(boolean mediumSelected) {
        this.mediumSelected = mediumSelected;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    public double getLargePrice() {
        return largePrice;
    }

    public void setLargePrice(double largePrice) {
        this.largePrice = largePrice;
    }

    public boolean isLargeSelected() {
        return largeSelected;
    }

    public void setLargeSelected(boolean largeSelected) {
        this.largeSelected = largeSelected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ProductV{" + "name=" + name + ", description=" + description + ", "
                + "imageRep=" + imageRep +  "type=" + type +'}';
    }
    
    
}
