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
public class Company {

    /**
     * Attributes
     */
    private int id;
    private String name;
    private byte[] logo;
    private String logoRep;
    private int idAdress;

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

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }

    public String getLogoRep() {
        return logoRep;
    }

    public void setLogoRep(String logoRep) {
        this.logoRep = logoRep;
    }

    public int getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(int idAdress) {
        this.idAdress = idAdress;
    }

    @Override
    public String toString() {
        return "Company{" + "id=" + id + ", name=" + name + ", logo=" + logo + ", logoRep=" + logoRep + ", idAdress=" + idAdress + '}';
    }
     
}
