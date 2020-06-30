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
public class Product {

    /**
     * Attributes
     */
    private int id;
    private String name;
    private String description;
    private byte[] image;
    private String imageRep;
    private int idCompany;

    /**
     * Getters and setters
     */

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public int getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(int idCompany) {
        this.idCompany = idCompany;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + ", imageRep=" + imageRep + ", idCompany=" + idCompany + '}';
    }
    
}
