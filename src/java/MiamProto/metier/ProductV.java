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
    private List<ProductSize> sizes;

    public ProductV() {
    }

    public ProductV(String name, String description, byte[] image, 
            String imageRep, int type, List<ProductSize> sizes) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.imageRep = imageRep;
        this.sizes = sizes;
        this.type = type;
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

    @Override
    public String toString() {
        return "ProductV{" + "name=" + name + ", description=" + description + ", "
                + "imageRep=" + imageRep +  "type=" + type +'}';
    }
    
    
}
